package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import fr.eni.ghtprojet.bll.UtilisateurManager;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.UtilisateurDAOImpl;

/**
 * Servlet implementation class ModifierProfil
 */
@WebServlet("/modifierprofil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String messageErreur = "";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierprofil.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = request.getParameter("pseudo").trim().toLowerCase(); 
		String nom = request.getParameter("nom").trim().toUpperCase();
		String prenom = request.getParameter("prenom").trim().toLowerCase();
		String email = request.getParameter("email").trim().toLowerCase();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String code_Postal = request.getParameter("code_postal").trim();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String mot_de_passe = request.getParameter("mdp").trim();
		String nouveau_mot_de_passe = request.getParameter("mdpnew").trim();
		String confirmation = request.getParameter("confirmation").trim();
		System.out.println((Utilisateur) request.getSession().getAttribute("user"));
		
		// Liste de nouveaux parametres
		
		List <String> listParamUserNew = new ArrayList<>();
		listParamUserNew.add(pseudo);
		listParamUserNew.add(nom);
		listParamUserNew.add(prenom);
		listParamUserNew.add(email);
		listParamUserNew.add(telephone);
		listParamUserNew.add(rue);
		listParamUserNew.add(code_Postal);
		listParamUserNew.add(ville);
		listParamUserNew.add(nouveau_mot_de_passe);
		
		Utilisateur user = null;
		user = ((Utilisateur) request.getSession().getAttribute("user"));
		
		// Liste de parametres avant de changement
		
		List <String> listParamUser = new ArrayList<>();
		
		listParamUser.add(user.getPseudo());
		listParamUser.add(user.getNom());
		listParamUser.add(user.getPrenom());
		listParamUser.add(user.getEmail());
		listParamUser.add(user.getTelephone());
		listParamUser.add(user.getRue());
		listParamUser.add(user.getCode_Postal());
		listParamUser.add(user.getVille());
		listParamUser.add(user.getMot_de_passe());
		
		for (int i = 0; i < listParamUser.size(); i++) {
			if (listParamUserNew.get(i) != null && listParamUserNew.get(i) != "") {
				listParamUser.set(i, listParamUserNew.get(i));
				System.out.println("champ " + listParamUser.get(i) + "n'est pas vide");
			}
		}
		
			
			
		pseudo = listParamUser.get(0);
		nom = listParamUser.get(1);
		prenom = listParamUser.get(2);
		email = listParamUser.get(3);
		telephone = listParamUser.get(4);
		rue = listParamUser.get(5);
		code_Postal = listParamUser.get(6);
		ville = listParamUser.get(7);
		mot_de_passe = listParamUser.get(8);
		
		int credit = user.getCredit();
		byte administrateur = user.getAdministrateur();
		int no_utilisateur = user.getNo_Utilisateur();
		
		if ( request.getParameter("mdp").trim().equals(user.getMot_de_passe())) {
			Utilisateur userUpdate = new Utilisateur (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_Postal, ville, mot_de_passe, user.getCredit(), user.getAdministrateur());
			System.out.println("user apres update" + userUpdate);
			
			if (request.getParameter("mdpnew").trim() != "" && request.getParameter("mdpnew").trim() != null) {
				
				if (request.getParameter("confirmation").trim().equals("") || request.getParameter("confirmation").trim() == null){
					messageErreur = "Le confirmation est obligatoire";
					request.setAttribute("messageErreur", messageErreur);
					response.sendRedirect(request.getContextPath() + "/modifierprofil");
				}
				
				
				
			}

			
			
			try {
				UtilisateurManager mger = new UtilisateurManager();
				mger.update(userUpdate);
				if (UtilisateurDAOImpl.isUnique == false) {
					messageErreur = "Pseudo ou email déjà utilisés";
					request.setAttribute("messageErreur", messageErreur);
					System.out.println(UtilisateurDAOImpl.isUnique);
					UtilisateurDAOImpl.isUnique = true;
					response.sendRedirect(request.getContextPath() + "/modifierprofil");
					System.out.println("message : "+ messageErreur);
				}
				System.out.println(userUpdate);
				request.setAttribute("messageErreur", messageErreur);
				request.getSession().setAttribute("user", userUpdate);
				response.sendRedirect(request.getContextPath() + "/afficherprofil");
			} catch (Exception e) {
				e.printStackTrace();
		
			}
			
		} else {
			
			messageErreur = "Le mot de passe n'est pas valide";
			request.setAttribute("messageErreur", messageErreur);
			response.sendRedirect(request.getContextPath() + "/modifierprofil");
			
		}
		
		//request.getRequestDispatcher(request.getContextPath() + "/afficherprofil").forward(request, response);
		
		
	} 
	
	}

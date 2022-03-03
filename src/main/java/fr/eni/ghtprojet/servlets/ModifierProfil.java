package fr.eni.ghtprojet.servlets;

import java.io.IOException;

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
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pagemodifier.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pseudo = "Tatiiiiana"; //request.getParameter("pseudo").trim().toLowerCase(); 
		String nom = request.getParameter("nom").trim().toUpperCase();
		String prenom = request.getParameter("prenom").trim().toUpperCase();
		String email = request.getParameter("email").trim().toLowerCase();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String code_Postal = request.getParameter("code_postal").trim();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String mot_de_passe = request.getParameter("mdp").trim();
		String nouveau_mot_de_passe = request.getParameter("mdpnew").trim();
		String confirmation = request.getParameter("confirmation").trim();
		System.out.println((Utilisateur) request.getSession().getAttribute("user"));
		
		Utilisateur user = null;
		String messageErreur = "";
		user = ((Utilisateur) request.getSession().getAttribute("user"));
		int credit = user.getCredit();
		if(mot_de_passe.equals (user.getMot_de_passe())){
			System.out.println(user.getMot_de_passe());
			
		}
		
		if (nouveau_mot_de_passe.equals(confirmation)) {
			System.out.println("mot_de_passe et confirmation sont égaux");
			Utilisateur userUpdate = new Utilisateur (user.getNo_Utilisateur(), pseudo, nom, prenom, email, telephone, rue, code_Postal, ville, nouveau_mot_de_passe);
			request.setAttribute("messageErreur", messageErreur);
			
			
			try {
				UtilisateurManager mger = new UtilisateurManager();
				mger.update(userUpdate);
				System.out.println(userUpdate);
				
			/*	if (UtilisateurDAOImpl.isUnique == false) {
					messageErreur = "Pseudo ou email dï¿½jï¿½ utilisï¿½s";
					request.setAttribute("messageErreur", messageErreur);
					System.out.println(UtilisateurDAOImpl.isUnique);
					UtilisateurDAOImpl.isUnique = true;
					request.getRequestDispatcher("/WEB-INF/jsp/pageinscription.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("/WEB-INF/jsp/pageaccueil.jsp").forward(request, response);
					System.out.println(UtilisateurDAOImpl.isUnique);
				}
				*/	
		
				
				
			} catch (Exception e) {
				e.printStackTrace();
		
			}
			
		/*} else {
			messageErreur = "Motes de passe ne sont pas identiques";
			request.setAttribute("messageErreur", messageErreur);
			request.getRequestDispatcher("/WEB-INF/jsp/pageinscription.jsp").forward(request, response);
		}
	}*/

}}}

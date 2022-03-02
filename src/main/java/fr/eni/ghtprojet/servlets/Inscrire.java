package fr.eni.ghtprojet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ghtprojet.bll.UtilisateurManager;
import fr.eni.ghtprojet.bo.Utilisateur;

/**
 * Servlet implementation class Inscrire
 */
@WebServlet("/inscrire")
public class Inscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscrire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/pageinscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pseudo = request.getParameter("pseudo").trim().toLowerCase(); 
		String nom = request.getParameter("nom").trim().toUpperCase();
		String prenom = request.getParameter("prenom").trim().toUpperCase();
		String email = request.getParameter("email").trim().toLowerCase();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim().toLowerCase();
		String code_Postal = request.getParameter("code_postal").trim();
		String ville = request.getParameter("ville").trim().toLowerCase();
		String mot_de_passe = request.getParameter("mdp").trim();
		String confirmation = request.getParameter("confirmation").trim();
		int credit = 100;
		Utilisateur user = null;
		String messageErreur = "";
		
		
		if (mot_de_passe.equals(confirmation)) {
		
			user = new Utilisateur (pseudo, nom, prenom, email, telephone, rue, code_Postal, ville, mot_de_passe, credit);
			request.setAttribute("messageErreur", messageErreur);
			
			
			try {
				UtilisateurManager mger = new UtilisateurManager();
				mger.insert(user);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/WEB-INF/jsp/pageaccueil.jsp").forward(request, response);
			
		} else {
			messageErreur = "Motes de passe ne sont pas identiques";
			request.setAttribute("messageErreur", messageErreur);
			request.getRequestDispatcher("/WEB-INF/jsp/pageinscription.jsp").forward(request, response);
		}
		
		
		
		
		
		System.out.println(user);
		
		
	}

}

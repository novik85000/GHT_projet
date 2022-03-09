package fr.eni.ghtprojet.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import fr.eni.ghtprojet.bll.UtilisateurManager;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.dal.UtilisateurDAOImpl;

/**
 * Servlet implementation class Connecter
 */
@WebServlet("/connecter")
public class Connecter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Utilisateur user = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connecter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pagelogin.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession mySession = request. getSession();
		String pseudo = request.getParameter("identifiant").toLowerCase().trim();
		String mot_de_passe = request.getParameter("mdp").trim();
		String email = pseudo;
		boolean isFound = false;
		String messageError =" ";
	
		
		
		try {
			UtilisateurManager mger = new UtilisateurManager();
			user = mger.seConnecter(pseudo, email, mot_de_passe);
			mySession.setAttribute("user", user);
			//System.out.println(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if (user!= null && pseudo.equals(user.getPseudo())&& mot_de_passe.equals(user.getMot_de_passe())) {
		System.out.println("user existe");
		isFound = true;
		request.setAttribute("messageError", messageError);
		response.sendRedirect(request.getContextPath()+"/accueillirconnecte");
		}
		else {
			System.out.println("user existe pas");
			isFound = false;
			messageError = "Mot de passe et/ou login incorrect";
			request.setAttribute("messageError", messageError);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pagelogin.jsp");
			rd.forward(request, response);
			
			
			}
		
		}
	
	
}

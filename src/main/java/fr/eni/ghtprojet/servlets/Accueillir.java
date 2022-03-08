package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ghtprojet.bll.ArticleManager;
import fr.eni.ghtprojet.bll.UtilisateurManager;
import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Utilisateur;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/accueil_servlet")
public class Accueillir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueillir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Article_vendu> listArticles = null;
		
		
		try {
			ArticleManager mgerArticle = new ArticleManager();
			listArticles = mgerArticle.selectAll();
			System.out.println(listArticles);
			request.getSession().setAttribute("listeArticles", listArticles);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageaccueil.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageaccueil.jsp");
		rd.forward(request, response);
	}

}

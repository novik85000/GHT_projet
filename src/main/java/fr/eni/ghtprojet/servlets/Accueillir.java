package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ghtprojet.bll.ArticleManager;
import fr.eni.ghtprojet.bo.Article_vendu;

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
		try {
			ArticleManager mgerArt = new ArticleManager();
			List <Article_vendu> listeArticles= new ArrayList<>();
			listeArticles = mgerArt.selectAll();
			System.out.println(listeArticles);
			request.setAttribute("listeArticles", listeArticles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/pageaccueil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArticleManager mgerArt = new ArticleManager();
			List <Article_vendu> listeArticlesApresFiltre= new ArrayList<>();
			listeArticlesApresFiltre = mgerArt.rechercheArticle((String)request.getParameter("recherche").trim(), 
					Integer.parseInt(request.getParameter("categorie")));
			System.out.println(listeArticlesApresFiltre);
			request.setAttribute("listeArticles", listeArticlesApresFiltre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/pageaccueil.jsp").forward(request, response);
	}
}

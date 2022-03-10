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
import fr.eni.ghtprojet.bll.EnchereManager;
import fr.eni.ghtprojet.bll.RetraitManager;
import fr.eni.ghtprojet.bll.UtilisateurManager;
import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Categorie;
import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;

/**
 * Servlet implementation class VisualiserDetail
 */
@WebServlet("/visualiserdetail")
public class VisualiserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article_vendu article = null;
		Utilisateur user = null;
		Retrait rt = null;
		List<Article_vendu> listArticles = null;
		Encheres enchere = null; 
		Categorie categorie = null;
		int prixVente = 0;
		
<<<<<<< HEAD
		System.out.println("No_Article : " + request.getParameter("idArticle"));

		request.setAttribute("idArticle", request.getParameter("idArticle"));
		int idArticle = Integer.parseInt((String)request.getAttribute("idArticle"));
=======
		System.out.println("No_Article" + request.getParameter("idArticle"));
		//System.out.println("Libelle categorie A" + categorie);
		request.getSession().setAttribute("idArticle", request.getParameter("idArticle"));
		String idArticleString = (String) request.getAttribute("idArticle");
		int idArticle = Integer.parseInt(idArticleString);
>>>>>>> branch 'main' of https://github.com/novik85000/GHT_projet2.git
		ArticleManager mger = null;
		try {
			mger = new ArticleManager();
			article = mger.selectById(idArticle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			UtilisateurManager mgerUser = new UtilisateurManager();
			RetraitManager mgerRetr = new RetraitManager();
			EnchereManager mgerEnch = new EnchereManager();
			
			categorie = mger.selectById1(article.getNo_Categorie());
				request.setAttribute("libelle", categorie );
				request.setAttribute("article", article );
				user = mgerUser.selectById(article.getNo_Utilisateur());
				request.setAttribute("userVendeur", user);
		request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp").forward(request, response);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		}
	}


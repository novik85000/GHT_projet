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
		
		System.out.println("No_Article" + request.getParameter("idArticle"));
		//System.out.println("Libelle categorie A" + categorie);
		request.getSession().setAttribute("idArticle", request.getParameter("idArticle"));
		String idArticleString = (String) request.getSession().getAttribute("idArticle");
		int idArticle = Integer.parseInt(idArticleString);
		ArticleManager mger = null;
		try {
			mger = new ArticleManager();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		article = mger.selectById(idArticle);
		
		
		
		
		try {
			UtilisateurManager mgerUser = new UtilisateurManager();
			RetraitManager mgerRetr = new RetraitManager();
			EnchereManager mgerEnch = new EnchereManager();
			
			
			
			
			
			//test
			// Test pour insert enchere 
			//EnchereManager mgerench = new EnchereManager();
			//enchere = new Encheres(2, 5, "2021-12-24", 700);
			//mgerench.insert(enchere); 
			//System.out.println(enchere);
			
			//System.out.println(article);
			//System.out.println(user);
			//System.out.println(rt);
			//System.out.println(listArticles);
			

				
				
				
				//article = mger.selectById(Integer.parseInt(request.getSession().getAttribute("idArticle")));
				categorie = mger.selectById1(article.getNo_Categorie());
				request.getSession().setAttribute("libelle", categorie );
				request.getSession().setAttribute("article", article );
				user = mgerUser.selectById(article.getNo_Utilisateur());
				request.getSession().setAttribute("userVendeur", user);
		request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp").forward(request, response);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		}
	}


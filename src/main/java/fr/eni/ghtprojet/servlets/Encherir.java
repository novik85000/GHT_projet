package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
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
import fr.eni.ghtprojet.bo.Encheres;
import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;

/**
 * Servlet implementation class Encherir
 */
@WebServlet("/encherir")
public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Encherir() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		// TODO Auto-generated method stub
		Article_vendu article = null;
		Utilisateur user = null;
		Retrait rt = null;
		List<Article_vendu> listArticles = null;
		Encheres enchere = null; 
		try {
			ArticleManager mger = new ArticleManager();
			UtilisateurManager mgerUser = new UtilisateurManager();
			RetraitManager mgerRetr = new RetraitManager();
			
			article = mger.selectById(4);
			user = mgerUser.selectById(4);
			rt = mgerRetr.selectById(11);
			listArticles = mger.selectAll();
			 // Test pour insert enchere 
			//EnchereManager mgerench = new EnchereManager();
			//enchere = new Encheres(2, 5, "2021-12-24", 700);
			//mgerench.insert(enchere); 
			//System.out.println(enchere);
			
			System.out.println(article);
			System.out.println(user);
			System.out.println(rt);
			System.out.println(listArticles);
			System.out.println("No_Article" + request.getParameter("idArticle"));
			
			article = mger.selectById(Integer.valueOf(request.getParameter("idArticle")));
			
			
			request.getSession().setAttribute("article", article );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp").forward(request, response);
	}

}

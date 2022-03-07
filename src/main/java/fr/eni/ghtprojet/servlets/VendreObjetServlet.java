package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import fr.eni.ghtprojet.bll.ArticleManager;
import fr.eni.ghtprojet.bo.Article_vendu;
import fr.eni.ghtprojet.bo.Utilisateur;

/**
 * Servlet implementation class VendreObjetServlet
 */
@WebServlet("/vendreobjet")
public class VendreObjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendreObjetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/nouvellevente.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Article_vendu article = null;
		Utilisateur user = null;
		
		user = (Utilisateur)request.getSession().getAttribute("user");
		
		String nom_article = request.getParameter("Article");
		String description = request.getParameter("Description");
		int categorie = Integer.parseInt(request.getParameter("categories"));
		
		String date1 = request.getParameter("dateDebut");
		String date2 = request.getParameter("dateFin");
		
		int prixDepart = Integer.parseInt(request.getParameter("prixDepart"));
		
		
		// rentrer des données en dur pour test 
		article = new Article_vendu(nom_article,description ,date1 ,date2 ,prixDepart,prixDepart,"EC",
				categorie,user.getNo_Utilisateur(),"0");
		
		/*TODO
		 * Finir la partie insertion en prenant en compte les données rentré par utilisateur 
		 */
		try {
			ArticleManager mgr = new ArticleManager();
			mgr.insert(article);
			System.out.println(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageaccueilconnecte.jsp");
		rd.forward(request, response);
	}

}

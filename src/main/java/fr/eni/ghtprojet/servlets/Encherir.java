package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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

		Encheres enchere = null; 
		
		int prixVente = 0;
		try {
			
			EnchereManager mgerEnch = new EnchereManager();
			
			
			if (request.getParameter("prixVente") != null) {
				prixVente = Integer.parseInt(request.getParameter("prixVente"));
				System.out.println("Prix vente" + prixVente);
				
				String idArticleString = (String)(request.getSession().getAttribute("idArticle"));
				
				int idArticle = Integer.parseInt(idArticleString);
				
				
				Utilisateur userCourant =  (Utilisateur) request.getSession().getAttribute("user");
				int paramNoUtil = userCourant.getNo_Utilisateur();
				
				LocalDateTime currentDateTime = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
				String formattedDateTime = currentDateTime.format(formatter);
				System.out.println(currentDateTime);
				System.out.println(formattedDateTime);
				
				enchere = new Encheres(paramNoUtil, idArticle , formattedDateTime, prixVente);
				
				
				Encheres enchereById = mgerEnch.selectById(idArticle);
			
				
				if (enchereById == null || enchereById.getNo_utilisateur() != userCourant.getNo_Utilisateur()) {
					System.out.println("User n'a pas encore enchere ");
					mgerEnch.insert(enchere);
				} else {
					System.out.println("User deja enchere ");
				}
				
				System.out.println("enchere by id :" + enchereById);
				
				
				
				
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/visualiserdetail");
		//request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp").forward(request, response);
	}

}

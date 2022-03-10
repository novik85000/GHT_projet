package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
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
		String message = "";
		
		int prixVente = 0;
		try {
			
			EnchereManager mgerEnch = new EnchereManager();
			ArticleManager mgerArt = new ArticleManager();
			Utilisateur userCourant =  (Utilisateur) request.getSession().getAttribute("user");
			Utilisateur userVendeur =  (Utilisateur) request.getSession().getAttribute("userVendeur");
			boolean isMonEnchere = false;
			
			Article_vendu article = (Article_vendu)request.getSession().getAttribute("article");
			
			if (request.getParameter("prixVente") != null) {
				
				
				prixVente = Integer.parseInt(request.getParameter("prixVente"));
				System.out.println("Prix vente" + prixVente);
				request.getSession().setAttribute("messageEnchere", "");
				
				if (prixVente <= article.getMiseAPrix() || 
						prixVente <= article.getPrixVente() ) {
						System.out.println("La prix d'enchere n'est pas bonne");
						message = "Votre proposition de prix est trop petite";
					} else {
						System.out.println("La prix est bon");
						
						String idArticleString = (String)(request.getSession().getAttribute("idArticle"));
						
						int idArticle = Integer.parseInt(idArticleString);
						
						
						
						int paramNoUtil = userCourant.getNo_Utilisateur();
						
						LocalDateTime currentDateTime = LocalDateTime.now();
						DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
						String formattedDateTime = currentDateTime.format(formatter);
						System.out.println(currentDateTime);
						System.out.println(formattedDateTime);
						
						enchere = new Encheres(paramNoUtil, idArticle , formattedDateTime, prixVente);
						
						
						Encheres enchereById = mgerEnch.selectById(idArticle);
						
						System.out.println(enchereById);
						
						
						if (userVendeur.getNo_Utilisateur() == enchere.getNo_utilisateur()) {
							message = "Vous ne pouvez pas enchirir sur votre article";
							isMonEnchere = true;
							
						}
					
						
						if (enchereById == null && isMonEnchere == false) {
							System.out.println("User n'a pas encore enchere ");
							mgerEnch.insert(enchere);
							mgerArt.update(enchere);
							message = "Votre enchere a passe avec succes, vous allez être redirigez sur page d'accueil";
							System.out.println("insertion a reussi");
						} else if (userCourant.getNo_Utilisateur()!= enchereById.getNo_utilisateur() && isMonEnchere == false){
							System.out.println("User deja enchere ");
							mgerEnch.update(enchere);
							mgerArt.update(enchere);
							System.out.println("Update a reusi");
							message = "Votre enchere a passe avec succes, vous allez être redirigez sur page d'accueil";
						}
							else if (isMonEnchere == false){
								System.out.println("Utilisateur a deja encheri sur cet article (dernière enchère)");
								message = "Vous avez deja enchere sur cette article";
							}
							
						
					}
					
					
				
				
					}
					
		request.getSession().setAttribute("messageEnchere", message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/detailvente.jsp").forward(request, response);
	}

}

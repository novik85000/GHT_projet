package fr.eni.ghtprojet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ghtprojet.bll.ArticleManager;
import fr.eni.ghtprojet.bo.Article_vendu;

/**
 * Servlet implementation class AccueillirConnecte
 */
@WebServlet("/accueillirconnecte")
public class AccueillirConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueillirConnecte() {
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
			
			List<Article_vendu> articlesEC = new ArrayList<>();
			
			for (int i = 0; i < listArticles.size(); i++) {
				if (listArticles.get(i).getEtatVente().trim().toLowerCase().equals("ec") == false) {
					System.out.println(listArticles.get(i) + " - article n'est pas en cours");
					
				}
				else {
					System.out.println("article en cours");
					articlesEC.add(listArticles.get(i));
				}
			}
			
			
			request.getSession().setAttribute("listeArticles", articlesEC);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageaccueilconnecte.jsp");
		rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int categorie = Integer.valueOf(request.getParameter("categorie"));
		System.out.println(categorie);
		List<Article_vendu> newListArticles = new ArrayList<>();
		
		List<Article_vendu> listArticles = (List<Article_vendu>) request.getSession().getAttribute("listeArticles");
		
		
		
		
		
		
		for (int i = 0; i < listArticles.size(); i++) {
			if (listArticles.get(i).getNo_Categorie()==categorie) {
				newListArticles.add(listArticles.get(i));
			}
				
		}
		if (categorie ==0) {
			request.getSession().setAttribute("articleApresFiltre", listArticles);
		}else {
			request.getSession().setAttribute("articleApresFiltre", newListArticles);
		}
		String recherche = null;
		recherche = request.getParameter("recherche").trim().toLowerCase();
		System.out.println(recherche);
		List<Article_vendu> articlesApresRecherche = new ArrayList<>();
		
		if ((recherche != null)&& (recherche!= "")){
			for (int i = 0; i < listArticles.size(); i++) {
				int index = listArticles.get(i).getNom_Article().trim().toLowerCase().indexOf(recherche);
				if (index == -1) {
					System.out.println("article ne pas trouv�");	
				} else {
					System.out.println("article est trouv�");
					articlesApresRecherche.add(listArticles.get(i));
				}
			}
			
			if (articlesApresRecherche != null) {
				System.out.println(articlesApresRecherche);
			}
			
			System.out.println("article apres rechereche : " + articlesApresRecherche);
			
			List<Article_vendu> listApresFiltre = (List<Article_vendu>) request.getSession().getAttribute("articleApresFiltre") ;
			List<Article_vendu> listeApresFiltreEtRecherche = new ArrayList<>();
			
			if (listApresFiltre!=null) {
				for (int i = 0; i < listApresFiltre.size(); i++) {
					if (articlesApresRecherche.contains(listApresFiltre.get(i))) {
						listeApresFiltreEtRecherche.add(listApresFiltre.get(i));
					}
				}
			}
			
			if (listeApresFiltreEtRecherche!=null) {
				request.getSession().setAttribute("articleApresFiltre", listeApresFiltreEtRecherche);
			}
			
			
		}
		
		System.out.println(listArticles);
		System.out.println(newListArticles);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/pageaccueilconnecte.jsp");
		rd.forward(request, response);
		
	}

}

package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.ArticleVenduManager;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.businessException.BusinessException;

/**
 * Servlet implementation class ServletAccueilConnecté
 */
@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/JSP/nouvelleVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date_debut_encheres = LocalDate.parse(request.getParameter("auctionStart"),dtf);
		LocalDate date_fin_encheres = LocalDate.parse(request.getParameter("auctionEnd"),dtf);
		int prixInitial = Integer.parseInt(request.getParameter("prixInitial"));
		int categorie = Integer.parseInt(request.getParameter("categorie"));
		int vendeur = Integer.parseInt(request.getParameter("noUtilisateur"));
		
		ArticleVendu a;			
		a = new ArticleVendu(request.getParameter("article"), request.getParameter("description"), date_debut_encheres,
				date_fin_encheres, prixInitial, vendeur,categorie);

		try {
			ArticleVenduManager.getInstance().insert(a);
		} catch (BusinessException e) {
				e.printStackTrace();
		}
		response.sendRedirect("ServletAccueilConnecte");

	}

}

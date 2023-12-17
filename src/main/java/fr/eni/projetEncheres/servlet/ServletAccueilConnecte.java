package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.ArticleVenduManager;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;
import fr.eni.projetEncheres.dal.UtilisateurDAO;
import fr.eni.projetEncheres.dal.UtilisateurDAOjdbcImpl;

/**
 * Servlet implementation class ServletAccueilConnecté
 */
@WebServlet("/ServletAccueilConnecte")
public class ServletAccueilConnecte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses;
		ses = request.getSession();
		Utilisateur u;
		u = (Utilisateur) ses.getAttribute("userConnected");

		try {
			List<ArticleVendu> lst = ArticleVenduManager.getInstance().selectAll();
			request.setAttribute("liste", lst);
		} catch (Exception e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/JSP/AccueilConnecte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int categorie = Integer.parseInt(request.getParameter("categorie"));
		String filtre = request.getParameter("filtre");
		List<ArticleVendu> lst = null;

		if (filtre != null) {
			try {
				lst = ArticleVenduManager.getInstance().selectByFiltre(filtre);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}

		if (categorie != 0) {
			try {
				lst = ArticleVenduManager.getInstance().selectByCategorie(categorie);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("liste", lst);
		getServletContext().getRequestDispatcher("/WEB-INF/JSP/AccueilConnecte.jsp").forward(request, response);

	}

}

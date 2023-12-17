package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
@WebServlet("/encheres")
public class encheres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<ArticleVendu> lst = null;
		try {
			lst = ArticleVenduManager.getInstance().selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		request.setAttribute("liste", lst);
		getServletContext().getRequestDispatcher("/WEB-INF/JSP/encheres.jsp").forward(request, response);
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
		getServletContext().getRequestDispatcher("/WEB-INF/JSP/encheres.jsp").forward(request, response);

	}

}

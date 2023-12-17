package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.UtilisateurManager;
import fr.eni.projetEncheres.businessException.BusinessException;

/**
 * Servlet implementation class ServletSuppressionUtilisateur
 */
@WebServlet("/ServletSuppressionUtilisateur")
public class ServletSuppressionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
		try {
			UtilisateurManager.getInstance().delete(noUtilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		response.sendRedirect("encheres");
	}

}

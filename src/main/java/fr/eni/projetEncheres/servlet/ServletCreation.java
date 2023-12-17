package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.UtilisateurManager;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

/**
 * Servlet implementation class ServletCreation
 */
@WebServlet("/ServletCreation")
public class ServletCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/JSP/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session;
		Utilisateur u;
		u = new Utilisateur(request.getParameter("pseudo"), request.getParameter("nom"), request.getParameter("prenom"),
				request.getParameter("email"), request.getParameter("telephone"), request.getParameter("rue"),
				request.getParameter("codePostal"), request.getParameter("ville"), request.getParameter("motDePasse"));

		try {
			UtilisateurManager.getInstance().insert(u);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		session = request.getSession();
		session.setAttribute("userConnected", u);
		session.setAttribute("lastPseudo", u.getPseudo());
		response.sendRedirect("ServletAccueilConnecte");

	}

}

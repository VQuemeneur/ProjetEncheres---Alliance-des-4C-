package fr.eni.projetEncheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.UtilisateurManager;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

/**
 * Servlet implementation class ServletLogin
 */

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo, motDePasse;
		Utilisateur u = null;
		HttpSession session;
		pseudo = request.getParameter("pseudo");
		motDePasse = request.getParameter("motDePasse");

		try {
			u = UtilisateurManager.getInstance().login(pseudo, motDePasse);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		if (u != null) {
			session = request.getSession();
			session.setAttribute("userConnected", u);
			session.setAttribute("lastPseudo", u.getPseudo());
			response.sendRedirect("ServletAccueilConnecte");
		} else {
			String messageError = "Login inconnu ou Mot de passe erroné";
			request.setAttribute("messageError", messageError);
			request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
			response.sendRedirect("ServletLogin");
		}
	}
}
package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetEncheres.bll.ArticleVenduManager;
import fr.eni.projetEncheres.bll.UtilisateurManager;
import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

/**
 * Servlet implementation class ServletDetailVente
 */
@WebServlet("/ServletDetailVente")
public class ServletDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession ses;
		ses = request.getSession();
		Utilisateur uc;
		uc = (Utilisateur) ses.getAttribute("userConnected");

		int noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
		int noArticle = Integer.parseInt(request.getParameter("noArticle"));

		try {
			Utilisateur u = UtilisateurManager.getInstance().selectById(noUtilisateur);
			request.setAttribute("user", u);
			ArticleVendu a = ArticleVenduManager.getInstance().selectById(noArticle);
			request.setAttribute("article", a);
		} catch (BusinessException e) {

			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/JSP/detailVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session;
		session = request.getSession();
		Utilisateur uc = (Utilisateur) session.getAttribute("userConnected");
		int monCredit = uc.getCredit();

		int montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));

		if (monCredit > montantEnchere) {
			String messageOK = "l'Alliance des 4C vous remercie pour votre enchère !";
			request.setAttribute("messageOK", messageOK);
		} else {
			String messageError = "Crédit insuffisant pour cette enchère !";
			request.setAttribute("messageError", messageError);
		}
		doGet(request, response);

	}

}

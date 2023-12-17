package fr.eni.projetEncheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetEncheres.bll.UtilisateurManager;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

/**
 * Servlet implementation class ServletModificationProfil
 */
@WebServlet("/ServletModificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
		try {

			request.setAttribute("userConnected", UtilisateurManager.getInstance().selectById(noUtilisateur));

		} catch (BusinessException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher("/WEB-INF/JSP/modifSupprProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
		Utilisateur u;
		u = new Utilisateur();

		try {
			u = UtilisateurManager.getInstance().selectById(noUtilisateur);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		u.setPseudo(request.getParameter("pseudo"));
		u.setNom(request.getParameter("nom"));
		u.setPrenom(request.getParameter("prenom"));
		u.setEmail(request.getParameter("email"));
		u.setTelephone(request.getParameter("telephone"));
		u.setRue(request.getParameter("rue"));
		u.setCodePostal(request.getParameter("codePostal"));
		u.setVille(request.getParameter("ville"));
		u.setMotDePasse(request.getParameter("motDePasseActuel"));

		try {
			UtilisateurManager.getInstance().update(u);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		response.sendRedirect("ServletAccueilConnecte");
	}

}

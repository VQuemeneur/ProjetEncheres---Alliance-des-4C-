package fr.eni.projetEncheres.bo;

import java.time.LocalDate;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;

	private int vendeur;
	private int noUtilisateur;
	private int categorie;

	public ArticleVendu() {
		super();

	}

	/**
	 * @param nomArticle
	 * @param dateFinEncheres
	 * @param prixVente
	 * @param vendeur
	 */
	public ArticleVendu(String nomArticle, LocalDate dateFinEncheres, int prixVente, int vendeur) {
		this.nomArticle = nomArticle;
		this.dateFinEncheres = dateFinEncheres;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
	}

	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, int vendeur, int categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}

	// Constructeur pour la création d'un nouvel articleVendu - A VOIR UTILITE DE CE
	// CONSTRUCTEUR
	// public ArticleVendu(String nomArticle, String description, LocalDate
	// dateDebutEncheres,
	// LocalDate dateFinEncheres, int miseAPrix, int prixVente, Categorie categorie)

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int prixVente, int vendeur, int categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}
	// Constructeur pour la création d'un nouvel articleVendu
	// public ArticleVendu(String nomArticle, String description, LocalDate
	// dateDebutEncheres,
	// LocalDate dateFinEncheres, int miseAPrix, Categorie categorie)

	public ArticleVendu(String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			int miseAPrix, int vendeur, int categorie) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}

	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateFinEncheres, int miseAPrix,
			int prixVente, int vendeur, int categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.vendeur = vendeur;
		this.categorie = categorie;
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	// public Categorie getCategorie() {
	public int getCategorie() {
		return categorie;
	}

	// public void setCategorie(Categorie categorie) {
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", categorie=" + categorie
				+ "]";
	}

	/**
	 * @return the vendeur
	 */
	public int getVendeur() {
		return vendeur;
	}

	/**
	 * @param vendeur the vendeur to set
	 */
	public void setVendeur(int vendeur) {
		this.vendeur = vendeur;
	}

	public void setVendeur(Utilisateur u) {
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

}

package dev.top.entities;

public class CollegueWeb {

	// champs
	private String pseudo;

	private Integer score;

	private String photo;

	// constructeurs
	public CollegueWeb(String pseudo, Integer score, String photo) {
		super();
		this.pseudo = pseudo;
		this.score = score;
		this.photo = photo;
	}

	public CollegueWeb() {
		super();
	}

	// Getters et setters
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}

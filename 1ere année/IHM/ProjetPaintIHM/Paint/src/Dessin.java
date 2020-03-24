import java.awt.Color;

/***
 * Attribut basique pas grand chose a commente. Juste "couleurs" qui est de type "color" et x,y qui serviront pour la position de la souris.
 * @author saied
 *
 */
public class Dessin { //Question 8
	private int taille;
	private String formes;
	private Color couleurs;
	private int x;
	private int y;

	/***
	 * Question 10. Constructeur champs a champs pour le dessin, on lui donne la position de la souris , la couleur et la forme sont defini avec le choix de l'utilisateur
	 * Les getteurs et setteurs sont mise en place mais ne servent pas réellement, possibilité de les supprimer.
	 * Exemple si la couleur choisi est "bleu" on établit la couleur bleu à la variable couleurs.
	 * Si jamais je n'ai pas assez bien commenter mon code , je serai disponible pour vous expliquez ma methode a tout moment.
	 * Merci 
	 */
	public Dessin(int x, int y, String couleur, String forme, int taille){
		super();
		this.taille = taille;
		this.formes = forme;
		this.x = x;
		this.y = y;
		if(couleur.equals("bleu")) {
			this.couleurs = Color.blue;
		}
		if(couleur.equals("rouge")){
			this.couleurs = Color.red;
		}
		if(couleur.equals("vert")){
			this.couleurs = Color.green;
		}
		if(couleur.equals("blanc")){
			this.couleurs = Color.white;
		}
	}
	
	/***
	 * Getter et setter des attributs
	 * @return
	 */
	public int getTaille() {
		return taille;
	}

	public String getFormes() {
		return formes;
	}

	public Color getCouleurs() {
		return couleurs;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void setFormes(String formes) {
		this.formes = formes;
	}

	public void setCouleurs(Color couleurs) {
		this.couleurs = couleurs;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
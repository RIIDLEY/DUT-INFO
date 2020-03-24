import java.util.ArrayList;

/***
 * Ici l'interface Donnees qui contient un tableau de couleurs et de formes pour les combo box.
 * Contient aussi une liste de dessins qui contient les dessins faite pas les utilisateurs. Il nous servira aussi pour les boutons "effac" et "revenir"
 * Avec par exemple removeAll pour tout supprimer.
 * Si jamais je n'ai pas assez bien commenter mon code , je serai disponible pour vous expliquez ma methode a tout moment.
 * Merci
 * @author saied
 *
 */
public interface Donnees {
	//Question 3
	public final static String[] couleurs = {"rouge","bleu","vert"};
	
	public final static String[] formes = {"cercle","carre"};
	//Question 9 
	ArrayList <Dessin> dessins = new ArrayList <Dessin>();
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

//Question 1

public class Paint extends JFrame{
	/***
	 * Ici je met en private les boutons qu'on a besoin ( on les utilisera dans les action et mouse listener)
	 * Le "e" est mit en private c'est une inner-class nommé Ecouteur qui implements ActionListener et MouseListener .
	 */
	private Ecouteur e = new Ecouteur();
	private JPanel haut= new JPanel();
	private PanneauSud bas = new PanneauSud();
	private PanneauCentre centre = new PanneauCentre();//Question 6
	private JToggleButton crayon = new JToggleButton(new ImageIcon("logoCrayon.png"));//Question 4
	private JToggleButton gomme = new JToggleButton(new ImageIcon("logoGomme.png"));//Question 4
	private JToggleButton doubl = new JToggleButton(new ImageIcon("logo2.png"));//pour fonctionnalité perso
	private JComboBox<String> box1 = new JComboBox<String>();
	private JComboBox<String> box2 = new JComboBox<String>();
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenu propos = new JMenu("A propos");
	private JTextField text = new JTextField(10);
	private JButton effac = new JButton("Effacer tout");
	private JButton revenir = new JButton("Revenir en arriere");
	
	/***
	 * Ici la fenetre qui contient tout le code du paint
	 * Les fonctions sont assez explicite , la fenetre est divisé en plusieurs partie nord/milieu/sud et menu.
	 * Nous verrons en bas leurs contenus.
	 * @param titre
	 */
	public Paint(String titre){
			super(titre);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(1200,800);
			this.setExtendedState(JFrame.MAXIMIZED_BOTH);
			this.menu();
			this.nord();
			this.milieu();
			this.sud();			
			this.setVisible(true);
	}
	
	/***
	 * Tout d'abord j'appelle le composante grapique "JMenuBar" pour gerer le menu dans la fenetre.
	 * 2 menu : "fichier" et "a propos" (Mouselistener car quand on va cliquer sur ce menu un message d'erreur apparaitra.
	 * "Quitter" un sous-menu de fichier (Actionlistener car quand on va appuyer sur ce sous-menu la fenetre devra se fermer.
	 * On cree d'abord les menu puis sous-menu et enfin on ajoute dans la fenetre. 
	 * Le "e" est mit en private c'est une inner-class nommé Ecouteur qui implements ActionListener et MouseListener.
	 */
	public void menu(){
		//Question 2 
		JMenuBar a = new JMenuBar();
		JMenu fichier = new JMenu("Fichier");
				
		this.quitter.addActionListener(e);//Question 7 
		this.propos.addMouseListener(e);//Question 7
		this.setJMenuBar(a);
		
		fichier.add(quitter);
		a.add(fichier);
		a.add(propos);
	}
	
	/***
	 * Ici c'est pour gerer le nord de la fenetre. JLabel couleur puis juste apres on utilise une combo box car c'est une liste de couleurs.
	 * Pareille pour "formes", c'est une liste de forme (cercle,carre). On fait une boucle pour parcourir toutes la liste dans l'interface "Donnees"
	 * Pour rajouter tous les couleurs et formes. Bien sur on va mettre des actionListener pour les boutons "crayon" et "gomme" car nous aurons besoin
	 * De mettre des evenements pour ces boutons. Le JTextField "text" est mise en private car nous aurons besoin de l'utiliser pour le dessin.
	 * Le "e" est mit en private c'est une inner-class nommé Ecouteur qui implements ActionListener et MouseListener.
	 */
	public void nord(){
		//Question 4 
		JLabel couleur = new JLabel("Couleur : ");
		
		this.haut.add(couleur);
		this.box1.setPreferredSize(new Dimension(100, 25));
		for(int i = 0; i < 3; i++){ 
			this.box1.addItem(Donnees.couleurs[i]);
		}
		haut.add(box1);
		
		JLabel forme = new JLabel("Forme : ");
		
		this.haut.add(forme);
		this.box2.setPreferredSize(new Dimension(100, 25));
		for(int i = 0; i < 2; i++){ 
			this.box2.addItem(Donnees.formes[i]);
		}
		haut.add(box2);
		
		JLabel taille = new JLabel(" Taille : ");
		
		this.haut.add(taille);
		this.haut.add(text);
		this.haut.add(crayon);
		this.haut.add(gomme);
		this.haut.add(doubl);
		this.crayon.addActionListener(e);
		this.gomme.addActionListener(e);
		this.doubl.addActionListener(e);
		this.haut.setLayout(new FlowLayout());
		this.add(haut, BorderLayout.NORTH);
		
	}
	
	/***
	 * C'est pour gerer le sud de la fenetre."effac"(tout effacer) et "revenir"(revenir en arriere) sont des JButton mit en private tout en haut.
	 * Nous les mettons actionListener pour ces 2 boutons car nous allons mettre des evenements pour ces boutons. "FlowLayout" pour centrer les boutons.
	 * Le "e" est mit en private c'est une inner-class nommé Ecouteur qui implements ActionListener et MouseListener 
	 */
	public void sud(){
		//Question 5
		this.bas.add(effac);
		this.bas.add(revenir);
		revenir.addActionListener(e);
		effac.addActionListener(e);
		this.bas.setLayout(new FlowLayout());
		this.add(bas, BorderLayout.SOUTH);
	}
	
	/***
	 * C'est pour gerer le milieu de la fenetre. "centre" est mit en private. C'est une class special pour le centre de la fenetre.
	 * Il faut donc aller voir la class panneauCentre pour plus de detail.(Pour mettre le background en blanc
	 * et MouseListener pour les evenements des dessins. Le "e" est mit en private c'est une inner-class nommé Ecouteur qui implements ActionListener et MouseListener)
	 */
	public void milieu(){
		//Question 6 
		this.add(centre, BorderLayout.CENTER);
		this.addMouseListener(e);
	}
	
	/***
	 * Voici l'inner-class "Ecouteur" qui implements "ActionListener" et "MouseListener", c'est pour gerer tous les evenements des boutons et clique de souris.
	 * Exemple quand on clique sur le sous-menu "quitter" la fenetre se ferme. "Repaint" pour rafraichir le panneauCentre (pour voir les modifciations).
	 * 2 methode une actionPerformed pour gerer les boutons l'autre MousePressed pour gerer les cliques de la souris.
	 * "IsSelected" est pour savoir si un bouton a ete cliquer ou pas.
	 * Si "crayon" seulement est selectionne alors on appelle la class Dessin pour gerer le dessin par rapport aux choix de l'utilisateur.
	 * Si jamais l'utilisateur n'a pas mit de taille, une taille par defaut est mise en place, fixer a 50. Comme c'est un string "50" on le cast en int.
	 * @author saied
	 *
	 */
	private class Ecouteur implements ActionListener, MouseListener{

		public void actionPerformed(ActionEvent a) {
			Object source = a.getSource();
			//Question 7 
			if(source.equals(quitter)){//Ferme la fenetre quand on clique sur quitter
				System.exit(0);
			}
			
			if(gomme.isSelected() && crayon.isSelected()){//Question 10) b) si "gomme" et "crayon" sont choisi en meme temps un msg d'erreur apparait
				JOptionPane.showMessageDialog(null, "Cela est interdit de cliquer sur les 2 boutons en meme temps petit malin !\nChoisit qu'un bouton à la fois");
			}
			if(source.equals(revenir)){//Question 10) e)
				Donnees.dessins.remove(Donnees.dessins.size()-1);
				centre.repaint();
			}
			if(source.equals(effac)){//Question 10) e)
				Donnees.dessins.removeAll(Donnees.dessins);
				centre.repaint();
			}
			
		}

		public void mousePressed(MouseEvent e) {
			if(e.getSource().equals(propos)){//Question 7
				JOptionPane.showMessageDialog(null, "Petit programme developpe par Saied Suroth\nUn jour je le vendrai.");//Afficher un msg d'erreur quand on clique sur "a propos"
			}
			
			if(crayon.isSelected()){//Question 10) a)
				int taille;
				if(text.getText().isEmpty()){//Si le texte est vide dans taille alors on met par defaut à 50.
					taille = 50;
				}			
				else{
					taille = Integer.parseInt(text.getText());//Si c'est rempli , on recupere la valeur mis dans taille
				}
				String couleur = (String) box1.getSelectedItem();
				String forme = (String) box2.getSelectedItem();
				
				Dessin d = new Dessin(e.getX()-(taille/2), e.getY()-(taille/2)-85,couleur,forme,taille);//Question 10) c)
				Donnees.dessins.add(d);
			
			}
			if(gomme.isSelected()){//Question 10) d)
				int taille;
				if(text.getText().isEmpty()){
					taille = 50;
				}			
				else{
					taille = Integer.parseInt(text.getText());
				}
				String forme = (String) box2.getSelectedItem();
				Dessin d = new Dessin(e.getX()-(taille/2), e.getY()-(taille/2)-85,"blanc",forme,taille);
				Donnees.dessins.add(d);
			}
			if(doubl.isSelected()) { // Question 11 fonctionnalite "double". En appuyant sur le bouton double on dessine 2 formes differentes d'un clique.
				int taille;
				if(text.getText().isEmpty()){//Si le texte est vide dans taille alors on met par defaut à 50.
					taille = 50;
				}			
				else{
					taille = Integer.parseInt(text.getText());//Si c'est rempli , on recupere la valeur mis dans taille
				}
				String couleur = (String) box1.getSelectedItem();
				String forme = (String) box2.getSelectedItem();
				
				Dessin d = new Dessin(e.getX()-(taille/2), e.getY()-(taille/2)-85,couleur,forme,taille);
				Donnees.dessins.add(d);
				if(forme.equals("cercle")) {
					forme="carre";
					Dessin d2 = new Dessin(e.getX(), e.getY(),couleur,forme,taille);
					Donnees.dessins.add(d2);
				}
				if(forme.equals("carre")) {
					forme="cercle";
					Dessin d2 = new Dessin(e.getX(), e.getY(),couleur,forme,taille);
					Donnees.dessins.add(d2);
				}				
				
			}
			centre.repaint();//Rafraichir le centre de la fenetre
			
		}
		/***
		 * Ces methodes sont automatiquement mise car nous avons implements MouseListener mais nous en avons pas besoin.
		 * Si jamais je n'ai pas assez bien commenter mon code , je serai disponible pour vous expliquez ma methode a tout moment.
		 * Merci
		 */
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}

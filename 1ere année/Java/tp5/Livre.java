public class Livre {
    String titre ;
    String auteur ;
    int numero ;

    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
        this.numero=-1;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String toString() {
        return "Livre [titre=" + this.titre
                + ", auteur=" + this.auteur
                + ", numero=" + this.numero + "]";
    }
}

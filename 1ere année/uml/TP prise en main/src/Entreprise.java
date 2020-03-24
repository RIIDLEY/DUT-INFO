import com.modeliosoft.modelio.javadesigner.annotations.mdl;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("8b765213-bcc6-4f7d-8691-278af712ae5d")
public class Entreprise {
    @objid ("2aa4dcb6-6d11-43e5-9c8b-6ecec63e9ef7")
    private String nom;

    @mdl.prop
    @objid ("81979f9b-4537-495b-bf25-332bf0cc81d1")
    private Adresse adresse;

    @mdl.propgetter
    public Adresse getAdresse() {
        // Automatically generated method. Please do not modify this code.
        return this.adresse;
    }

    @mdl.propsetter
    public void setAdresse(Adresse value) {
        // Automatically generated method. Please do not modify this code.
        this.adresse = value;
    }

    @objid ("0a940621-9115-4a3b-9d58-c2f03b5859ed")
    public String getNom() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.nom;
    }

    @objid ("fe9570ab-94d0-4b3b-a338-7d2ab1352500")
    public void setNom(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.nom = value;
    }
    public Entreprise(String nom, Adresse adresse){
      this.nom=nom;
      this.adresse=adresse;
    }
}

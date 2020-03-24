import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("d7994a0a-faf2-4f5e-8ae3-112028ef7cdb")
class Adresse {
    @objid ("95ed0351-ab90-42c5-9df4-584dca95b4bd")
    private String numeoro;

    @objid ("eb08b9f4-45af-49cc-9b2b-e3e6ee8f4e60")
    private String rue;

    @objid ("557da81a-ab89-4327-abe2-1ded1735485a")
    private String codePostal;

    @objid ("6e91a6db-d32a-4b06-95f4-6785aa7b6eba")
    private String ville;

    @objid ("47b11e2b-0a31-470a-9437-13b6e7117104")
    private String pays;



    @objid ("5017aefa-ca86-424a-bb49-1a61e01cdc89")
    String getNumeoro() {

        return this.numeoro;
    }

    @objid ("f0228f1a-14f9-453a-a3f8-c57c8d0eb33d")
    void setNumeoro(String value) {

        this.numeoro = value;
    }

    @objid ("63f57dc9-ca03-427f-ae50-90286f9055a2")
    String getRue() {

        return this.rue;
    }

    @objid ("23428193-ad3e-4a7e-a111-4626b20dd145")
    void setRue(String value) {

        this.rue = value;
    }

    @objid ("5aeb7104-521c-433a-b817-2ca292c4d227")
    String getCodePostal() {
        return this.codePostal;
    }

    @objid ("019b86c7-03dd-446e-b1a5-6e26a99912b6")
    void setCodePostal(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.codePostal = value;
    }

    @objid ("aa21f2ff-60c0-47f2-81f3-1a1222f4e20d")
    String getVille() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.ville;
    }

    @objid ("ac2f2490-fa69-48ef-a72c-d1bb7fc16aba")
    void setVille(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.ville = value;
    }

    @objid ("231c262c-628a-4e6b-977a-e8597d308c38")
    String getPays() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.pays;
    }

    @objid ("ea5d40a3-1ec0-47fb-9c65-1770447d8c68")
    void setPays(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pays = value;
    }



}

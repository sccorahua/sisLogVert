package modelo;

public class Usuario {

    private int id;
    private String use_usuario;
    private String nom_usuario;
    private String ape_usuario;
    private String password;
    private String tel_usuario;
    private String est_usuario;

    public Usuario() {
        this.id = 0;
        this.use_usuario = "";
        this.nom_usuario = "";
        this.ape_usuario = "";
        this.password = "";
        this.tel_usuario = "";
        this.est_usuario = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUse_usuario() {
        return use_usuario;
    }

    public void setUse_usuario(String use_usuario) {
        this.use_usuario = use_usuario;
    }
    
    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getApe_usuario() {
        return ape_usuario;
    }

    public void setApe_usuario(String ape_usuario) {
        this.ape_usuario = ape_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel_usuario() {
        return tel_usuario;
    }

    public void setTel_usuario(String tel_usuario) {
        this.tel_usuario = tel_usuario;
    }

    public String getEst_usuario() {
        return est_usuario;
    }

    public void setEst_usuario(String est_usuario) {
        this.est_usuario = est_usuario;
    }
    
        

}

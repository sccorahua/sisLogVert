package modelo;

//v1.0 SCN
public class CentroCosto {

    private String id_cen_costo;
    private String nom_cen_costo;
    private String dir_cen_costo;
    private String tel_cen_costo;
    private String estado;

    public CentroCosto() {
        this.id_cen_costo = "";
        this.nom_cen_costo = "";
        this.dir_cen_costo = "";
        this.tel_cen_costo = "";
        this.estado = "";
    }

    public CentroCosto(String id_cen_costo, String nom_cen_costo, String dir_cen_costo, String tel_cen_costo, String estado) {
        this.id_cen_costo = id_cen_costo;
        this.nom_cen_costo = nom_cen_costo;
        this.dir_cen_costo = dir_cen_costo;
        this.tel_cen_costo = tel_cen_costo;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_cen_costo() {
        return id_cen_costo;
    }

    public void setId_cen_costo(String id_cen_costo) {
        this.id_cen_costo = id_cen_costo;
    }

    public String getNom_cen_costo() {
        return nom_cen_costo;
    }

    public void setNom_cen_costo(String nom_cen_costo) {
        this.nom_cen_costo = nom_cen_costo;
    }

    public String getDir_cen_costo() {
        return dir_cen_costo;
    }

    public void setDir_cen_costo(String dir_cen_costo) {
        this.dir_cen_costo = dir_cen_costo;
    }

    public String getTel_cen_costo() {
        return tel_cen_costo;
    }

    public void setTel_cen_costo(String tel_cen_costo) {
        this.tel_cen_costo = tel_cen_costo;
    }

    
    
}

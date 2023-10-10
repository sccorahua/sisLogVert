package modelo;

import lombok.Data;

@Data
public class Proveedor {
    private int id_proveedor;
    private String nom_proveedor;
    private String tip_doc;
    private String num_doc;
    private String telefono;
    private String des_proveedor;
    private String dir_proveedor;
    private String estado;
}

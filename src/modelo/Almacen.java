package modelo;

//V1.0 SCN

import lombok.Data;

@Data
public class Almacen {
    private String cod_alm;
    private String nom_alm;
    private String dir_alm;
    private int id_emp;
    private String estado;

}

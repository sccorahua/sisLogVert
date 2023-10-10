package modelo;

import lombok.Data;

@Data
public class Item {
    private String id_item;
    private String nom_item;
    private String des_item;
    private String estado;
    private String id_categoria;
}

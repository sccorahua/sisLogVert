package modelo;

// v1.0 SCN

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemOrdenCompraInter {
    private int ref_ano_ord_com;
    private int ref_num_ord_com;
    private int periodo_ord_com;
    private int item_ord_com;
    private String cod_item_ord_com;
    private String id_item;
    private String unidad;
    private int cantidad;
    private BigDecimal uni_precio;
    private BigDecimal descuento;
    private BigDecimal importe_tot;
}

package modelo;

//v1.0 SCN
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemOrdenCompraNacional {

    private String id_item;
    private int cantidad;
    private String tip_unidad;
    private BigDecimal precioU;
    private BigDecimal descuento;
    private BigDecimal precioF;
    private int ref_num_ord_com;
    private int ref_ano_ord_com;
    private int item_ord_com;
    private int periodo_ord_com;
    private boolean IGV;
    private BigDecimal montoUniIng;

}

package modelo;

// v1.0 SCN
import java.math.BigDecimal;
import lombok.Data;

@Data
public class ItemOrdenServicio {

    private int ref_numero;
    private int ref_ano;
    private int ref_periodo;
    private int nro_item;
    private String descripcion;
    private String unidad;
    private int cantidad;
    private BigDecimal pre_unitario;
    private BigDecimal descuento;
    private BigDecimal importe;
    private boolean IGV;
    private BigDecimal montoUniIng;

}

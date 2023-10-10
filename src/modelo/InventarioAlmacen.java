package modelo;

// v1.0 SCN

import java.math.BigDecimal;
import lombok.Data;

@Data
public class InventarioAlmacen {
    private String id_almacen;
    private String id_item;
    private BigDecimal precio_red;
    private int cantidad;
}
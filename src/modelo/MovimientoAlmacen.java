package modelo;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Data;

//v1.0 SCN
@Data
public class MovimientoAlmacen {

    private String cod_almacen;
    private int id_mov_alm;
    private String id_item;
    private String tip_mov;
    private String mot_mov;
    private Date fec_mov;
    private String ref_mov;
    private int id_proveedor;
    private int cantidad;
    private BigDecimal precio_unit;
    private String comentario;
}

package modelo;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Data;

@Data
public class TipoCambio {

    private Date fec_tip_cambio;
    private BigDecimal tip_cambio_compra;
    private BigDecimal tip_cambio_venta;
}

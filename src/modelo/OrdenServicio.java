package modelo;

// v1.0 SCN
import java.math.BigDecimal;
import lombok.Data;
import java.sql.Date;

@Data
public class OrdenServicio {

    private int numero;
    private int ano;
    private int periodo;
    private int proveedor;
    private String cotizacion;
    private String are_sol;
    private Date fecha;
    private String contacto;
    private String telefono;
    private String email;
    private String cta_cte_banco;
    private String observaciones;
    private String cen_costo;
    private Date fec_entrega;
    private String ent_lugar;
    private String moneda;
    private String for_pago;
    private int dias_pago;
    private String per_sol;
    private BigDecimal imp_bruto_sol;
    private BigDecimal dto_sol;
    private BigDecimal sub_tot_sol;
    private BigDecimal total_sol;
    private int igv;
    private BigDecimal imp_bruto_dol;
    private BigDecimal dto_dol;
    private BigDecimal sub_tot_dol;
    private BigDecimal total_dol;
    private String estado;
}

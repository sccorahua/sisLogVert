package modelo;

// v1.0 SCN
import java.math.BigDecimal;
import lombok.Data;
import java.sql.Date;

@Data
public class OrdenCompraInter {

    private int num_ord_com_int;
    private int ano_ord_com_int;
    private int periodo_est_com_int;
    private int id_proveedor;
    private String email;
    private String quote_number;
    private Date fec_ord_com;
    private String pay_ter;
    private String incoterms;
    private String req_ship_date;
    private String fre_forw;
    private String cen_cost_ord_com;
    private String moneda;
    private String user_sol;
    private String ban_det;
    private String nro_cta;
    private String swi_cod;
    private BigDecimal sub_total_dol;
    private BigDecimal descuento_dol;
    private BigDecimal neto_dol;
    private BigDecimal transporte_dol;
    private BigDecimal total_amo_dol;
    private BigDecimal sub_total_sol;
    private BigDecimal descuento_sol;
    private BigDecimal neto_sol;
    private BigDecimal transporte_sol;
    private BigDecimal total_amo_sol;
    private String estado;
}

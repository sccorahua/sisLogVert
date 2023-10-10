package modelo;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Data;

//v1.0 SCN
@Data
public class OrdenCompraNacional {

    private int num_ord_com_nac;
    private int ano_ord_com_nac;
    private int periodo_est_com_nac;
    private int id_proveedor;
    private String cotizacion;
    private Date fec_ord_com;
    private String con_ord_com;
    private String tel_ord_com;
    private String email;
    private String cta_cte_ban_ord_com;
    private String cen_cos_ord_com;
    private Date fec_ent_ord_com;
    private String lug_ent_ord_com;
    private String moneda;
    private String for_pago_ord_com;
    private int pag_cre_dias;
    private String sol_ord_com;
    private BigDecimal imp_bruto_sol;
    private BigDecimal descuento_sol;
    private BigDecimal sub_total_sol;
    private BigDecimal total_sol;
    private int igv;
    private BigDecimal imp_bruto_dol;
    private BigDecimal descuento_dol;
    private BigDecimal sub_total_dol;
    private BigDecimal total_dol;
    private String estado;
    private String observacion;

    
}

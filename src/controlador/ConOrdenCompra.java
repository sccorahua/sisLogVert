package controlador;

//v1.0 SCN
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Calendar;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import modelo.CentroCosto;
import modelo.ItemOrdenCompraInter;
import modelo.ItemOrdenCompraNacional;
import modelo.OrdenCompraInter;
import modelo.OrdenCompraNacional;
import modelo.TipoCambio;

public class ConOrdenCompra {

    //obtener ultima orden nacional ingresada
    public int getUltOrdenCompraNacional() {
        int ultCompraNacional = 0;
        Connection con = conexion.Conexion.conectar();
        int anoActual = getAnoActual("c");
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select max(num_ord_com_nac) as id from mae_ord_com_nac where ano_ord_com_nac = " + anoActual + ";");
            if (rs.next()) {
                ultCompraNacional = rs.getInt("id");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de consultar getUltOrdenCompraNacional(): " + e);
        }
        return ultCompraNacional;
    }

    //ingresar compra nacional
    public boolean insOrdCompraNac(OrdenCompraNacional compra, String moneda) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            if (moneda.equals("Soles")) {
                //soles = 1
                PreparedStatement queryS = con.prepareStatement("INSERT INTO MAE_ORD_COM_NAC(NUM_ORD_COM_NAC,ANO_ORD_COM_NAC,PERIODO_EST_COM_NAC, ID_PROVEEDOR,COTIZACION,FEC_ORD_COM,CON_ORD_COM,TEL_ORD_COM,EMAIL,CTA_CTE_BAN_ORD_COM,CEN_COS_ORD_COM,FEC_ENT_ORD_COM,LUG_ENT_ORD_COM,MONEDA,FOR_PAG_ORD_COM,PAG_CRE_DIAS, SOL_ORD_COM, IMP_BRUTO_SOL,DESCUENTO_SOL, SUB_TOT_SOL, TOTAL_SOL, IGV,IMP_BRUTO_DOL, DESCUENTO_DOL, SUB_TOT_DOL,TOTAL_DOL, ESTADO, OBSERVACION)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,'1',?,?,?,?,?,?,?,?,?,?,?,?,'P',?);");
                queryS.setInt(1, compra.getNum_ord_com_nac());
                queryS.setInt(2, compra.getAno_ord_com_nac());
                queryS.setInt(3, compra.getPeriodo_est_com_nac());
                queryS.setInt(4, compra.getId_proveedor());
                queryS.setString(5, compra.getCotizacion());
                queryS.setDate(6, compra.getFec_ord_com());
                queryS.setString(7, compra.getCon_ord_com());
                queryS.setString(8, compra.getTel_ord_com());
                queryS.setString(9, compra.getEmail());
                queryS.setString(10, compra.getCta_cte_ban_ord_com());
                queryS.setString(11, compra.getCen_cos_ord_com());
                queryS.setDate(12, compra.getFec_ent_ord_com());
                queryS.setString(13, compra.getLug_ent_ord_com());
                queryS.setString(14, compra.getFor_pago_ord_com());
                queryS.setInt(15, compra.getPag_cre_dias());
                queryS.setString(16, compra.getSol_ord_com());

                BigDecimal ImpBrutoSol = compra.getImp_bruto_sol();
                BigDecimal DescuentoSol = compra.getDescuento_sol();
                BigDecimal SubTotalSol = compra.getSub_total_sol();
                BigDecimal TotalSol = compra.getTotal_sol();

                queryS.setBigDecimal(17, ImpBrutoSol);
                queryS.setBigDecimal(18, DescuentoSol);
                queryS.setBigDecimal(19, SubTotalSol);
                queryS.setBigDecimal(20, TotalSol);
                queryS.setInt(21, compra.getIgv());

                ConTipoCambio metTipCambio = new ConTipoCambio();
                TipoCambio TipCambio = metTipCambio.conFecha(compra.getFec_ord_com());
                try {
                    BigDecimal compraDol = TipCambio.getTip_cambio_compra();

                    BigDecimal ImpBrutoDol = compra.getImp_bruto_sol().divide(compraDol, MathContext.DECIMAL128);
                    ImpBrutoDol = ImpBrutoDol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal DescuentoDol = compra.getDescuento_sol().divide(compraDol, MathContext.DECIMAL128);
                    DescuentoDol = DescuentoDol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal SubTotalDol = compra.getSub_total_sol().divide(compraDol, MathContext.DECIMAL128);
                    SubTotalDol = SubTotalDol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal TotalDol = compra.getTotal_sol().divide(compraDol, MathContext.DECIMAL128);
                    TotalDol = TotalDol.setScale(2, RoundingMode.HALF_UP);

                    queryS.setBigDecimal(22, ImpBrutoDol);
                    queryS.setBigDecimal(23, DescuentoDol);
                    queryS.setBigDecimal(24, SubTotalDol);
                    queryS.setBigDecimal(25, TotalDol);
                } catch (SQLException e) {
                    System.out.println("Error al momento de guardar la cabecera de Orden de Compra Nacional(Soles): " + e);
                }
                queryS.setString(26, compra.getObservacion());

                if (queryS.executeUpdate() > 0) {
                    confirma = true;
                }
            }
            if (moneda.equals("Dolares")) {
                //dolares = 2
                PreparedStatement queryD = con.prepareStatement("INSERT INTO MAE_ORD_COM_NAC(NUM_ORD_COM_NAC,ANO_ORD_COM_NAC,PERIODO_EST_COM_NAC ,ID_PROVEEDOR,COTIZACION,FEC_ORD_COM,CON_ORD_COM,TEL_ORD_COM,EMAIL,CTA_CTE_BAN_ORD_COM,CEN_COS_ORD_COM,FEC_ENT_ORD_COM,LUG_ENT_ORD_COM,MONEDA,FOR_PAG_ORD_COM,PAG_CRE_DIAS, SOL_ORD_COM, IMP_BRUTO_SOL,DESCUENTO_SOL, SUB_TOT_SOL, TOTAL_SOL, IGV,IMP_BRUTO_DOL, DESCUENTO_DOL, SUB_TOT_DOL,TOTAL_DOL, ESTADO, OBSERVACION)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,'2',?,?,?,?,?,?,?,?,?,?,?,?,'P',?);");
                queryD.setInt(1, compra.getNum_ord_com_nac());
                queryD.setInt(2, compra.getAno_ord_com_nac());
                queryD.setInt(3, compra.getPeriodo_est_com_nac());
                queryD.setInt(4, compra.getId_proveedor());
                queryD.setString(5, compra.getCotizacion());
                queryD.setDate(6, compra.getFec_ord_com());
                queryD.setString(7, compra.getCon_ord_com());
                queryD.setString(8, compra.getTel_ord_com());
                queryD.setString(9, compra.getEmail());
                queryD.setString(10, compra.getCta_cte_ban_ord_com());
                queryD.setString(11, compra.getCen_cos_ord_com());
                queryD.setDate(12, compra.getFec_ent_ord_com());
                queryD.setString(13, compra.getLug_ent_ord_com());
                queryD.setString(14, compra.getFor_pago_ord_com());
                queryD.setInt(15, compra.getPag_cre_dias());
                queryD.setString(16, compra.getSol_ord_com());

                BigDecimal DescuentoDol = compra.getDescuento_dol();
                BigDecimal SubTotalDol = compra.getSub_total_dol();
                BigDecimal TotalDol = compra.getTotal_dol();
                BigDecimal ImpBrutoDol = compra.getImp_bruto_dol();

                queryD.setBigDecimal(22, ImpBrutoDol);
                queryD.setBigDecimal(23, DescuentoDol);
                queryD.setBigDecimal(24, SubTotalDol);
                queryD.setBigDecimal(25, TotalDol);

                queryD.setInt(21, compra.getIgv());
                ConTipoCambio metTipCambio = new ConTipoCambio();
                TipoCambio TipCambio = metTipCambio.conFecha(compra.getFec_ord_com());
                try {
                    BigDecimal ventaDol = TipCambio.getTip_cambio_venta();

                    BigDecimal ImpBrutoSol = compra.getImp_bruto_dol().multiply(ventaDol);
                    ImpBrutoSol = ImpBrutoSol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal DescuentoSol = compra.getDescuento_dol().multiply(ventaDol);
                    DescuentoSol = DescuentoSol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal SubTotalSol = compra.getSub_total_dol().multiply(ventaDol);
                    SubTotalSol = SubTotalSol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal TotalSol = compra.getTotal_dol().multiply(ventaDol);
                    TotalSol = TotalSol.setScale(2, RoundingMode.HALF_UP);

                    queryD.setBigDecimal(17, ImpBrutoSol);
                    queryD.setBigDecimal(18, DescuentoSol);
                    queryD.setBigDecimal(19, SubTotalSol);
                    queryD.setBigDecimal(20, TotalSol);
                } catch (SQLException e) {
                    System.out.println("Error al momento de guardar la cabecera de Orden de Compra Nacional (Dolares): " + e);
                }
                queryD.setString(26, compra.getObservacion());

                if (queryD.executeUpdate() > 0) {
                    confirma = true;
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar la cabecera de la orden. Error:" + e);
        }
        return confirma;
    }

    //insertar item de orden de compra nacional
    public boolean itemOrdCompraNac(ItemOrdenCompraNacional item) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO MAE_ITE_ORD_COM_NAC(REF_ANO_ORD_COM,REF_NUM_ORD_COM,PERIODO_ORD_COM,ITEM_ORD_COM,ID_ITEM,CANTIDAD,TIP_UNIDAD,PRECIOU,DESCUENTO,PRECIOF) VALUES (?,?,?,?,?,?,?,?,?,?);");
            query.setInt(1, item.getRef_ano_ord_com());
            query.setInt(2, item.getRef_num_ord_com());
            query.setInt(3, item.getPeriodo_ord_com());
            query.setInt(4, item.getItem_ord_com());
            query.setString(5, item.getId_item());
            query.setInt(6, item.getCantidad());
            query.setString(7, item.getTip_unidad());
            query.setBigDecimal(8, item.getPrecioU());
            query.setBigDecimal(9, item.getDescuento());
            query.setBigDecimal(10, item.getPrecioF());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar el item " + item.getId_item() + " de Orden de Compra Nacional: " + e);
        }

        return confirma;
    }

    //obtener año actual c(año completo) d(ultimos dos digitos)
    public int getAnoActual(String forma) {
        Calendar fecha = new GregorianCalendar();
        int ano = fecha.get(Calendar.YEAR);
        switch (forma) {
            case "c":
                return ano;
            case "d":
                ano = ano - 2000;
                return ano;
            default:
                throw new AssertionError();
        }

    }

    //obtener mes actual
    public int getMesActual() {
        Calendar fecha = new GregorianCalendar();
        int mesAct = fecha.get(Calendar.MONTH);
        return mesAct;
    }

    //ingresar compra internacional
    public boolean insOrdCompraInt(OrdenCompraInter compra) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO MAE_ORD_COM_INT(NUM_ORD_COM_INT,ANO_ORD_COM_INT,PERIODO_EST_COM_INT,ID_PROVEEDOR,EMAIL,QUOTE_NUMBER,FEC_ORD_COM,PAY_TER,INCOTERMS,REQ_SHIP_DATE,FRE_FORW,CEN_COS_ORD_COM,MONEDA,USER_SOL,BAN_DET,NRO_CTA,SWI_COD,SUB_TOTAL_DOL,DESCUENTO_DOL,NETO_DOL,TRANSPORTE_DOL,TOTAL_AMO_DOL,SUB_TOTAL_SOL,DESCUENTO_SOL,NETO_SOL,TRANSPORTE_SOL,TOTAL_AMO_SOL,ESTADO) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,'2',?,?,?,?,?,?,?,?,?,?,?,?,?,?,'P');");
            query.setInt(1, compra.getNum_ord_com_int());
            query.setInt(2, compra.getAno_ord_com_int());
            query.setInt(3, compra.getPeriodo_est_com_int());
            query.setInt(4, compra.getId_proveedor());
            query.setString(5, compra.getEmail());
            query.setString(6, compra.getQuote_number());
            query.setDate(7, compra.getFec_ord_com());
            query.setString(8, compra.getPay_ter());
            query.setString(9, compra.getIncoterms());
            query.setString(10, compra.getReq_ship_date());
            query.setString(11, compra.getFre_forw());
            query.setString(12, compra.getCen_cost_ord_com());
            query.setString(13, compra.getUser_sol());
            query.setString(14, compra.getBan_det());
            query.setString(15, compra.getNro_cta());
            query.setString(16, compra.getSwi_cod());

            BigDecimal SubTotalDol = compra.getSub_total_dol();
            BigDecimal DescuentoDol = compra.getDescuento_dol();
            BigDecimal NetoDol = compra.getNeto_dol();
            BigDecimal TransporteDol = compra.getTransporte_dol();
            BigDecimal TotalAmortDol = compra.getTotal_amo_dol();

            query.setBigDecimal(17, SubTotalDol);
            query.setBigDecimal(18, DescuentoDol);
            query.setBigDecimal(19, NetoDol);
            query.setBigDecimal(20, TransporteDol);
            query.setBigDecimal(21, TotalAmortDol);

            ConTipoCambio metTipCambio = new ConTipoCambio();
            TipoCambio TipCambio = metTipCambio.conFecha(compra.getFec_ord_com());
            try {
                BigDecimal ventaDol = TipCambio.getTip_cambio_venta();

                BigDecimal SubTotalSol = compra.getSub_total_dol().multiply(ventaDol);
                BigDecimal DescuentoSol = compra.getDescuento_dol().multiply(ventaDol);
                BigDecimal NetoSol = compra.getNeto_dol().abs().multiply(ventaDol);
                BigDecimal TransporteSol = compra.getTransporte_dol().multiply(ventaDol);
                BigDecimal TotalAmortSol = compra.getTotal_amo_dol().multiply(ventaDol);

                query.setBigDecimal(22, SubTotalSol);
                query.setBigDecimal(23, DescuentoSol);
                query.setBigDecimal(24, NetoSol);
                query.setBigDecimal(25, TransporteSol);
                query.setBigDecimal(26, TotalAmortSol);
            } catch (SQLException e) {
                System.out.println("Error al momento de guardar la cabecera de Orden de Compra Internacional: " + e);
            }

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar la cabecera de la orden. Error:" + e);
        }
        return confirma;
    }

    //insertar item compra internacional
    public boolean insItemOrdCompraInt(ItemOrdenCompraInter item) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO MAE_ITE_ORD_COM_INT(REF_ANO_ORD_COM,REF_NUM_ORD_COM,PERIODO_ORD_COM,ITEM_ORD_COM,COD_ITEM_ORD_COM,ID_ITEM,UNIDAD,CANTIDAD,UNI_PRECIO,DESCUENTO,IMPORTE_TOT) VALUE(?,?,?,?,?,?,?,?,?,?,?);");
            query.setInt(1, item.getRef_ano_ord_com());
            query.setInt(2, item.getRef_num_ord_com());
            query.setInt(3, item.getPeriodo_ord_com());
            query.setInt(4, item.getItem_ord_com());
            query.setString(5, item.getCod_item_ord_com());
            query.setString(6, item.getId_item());
            query.setString(7, item.getUnidad());
            query.setInt(8, item.getCantidad());
            query.setBigDecimal(9, item.getUni_precio());
            query.setBigDecimal(10, item.getDescuento());
            query.setBigDecimal(11, item.getImporte_tot());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar el item " + item.getId_item() + " de Orden de Compra Internacional: " + e);
        }

        return confirma;
    }

    //obtener ultima orden internacional ingresada
    public int getUltOrdenCompraInternacional() {
        int ultCompraInter = 0;
        Connection con = conexion.Conexion.conectar();
        int anoActual = getAnoActual("c");
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select max(num_ord_com_int) as id from mae_ord_com_int where ano_ord_com_int = " + anoActual + ";");
            if (rs.next()) {
                ultCompraInter = rs.getInt("id");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de consultar getUltOrdenCompraInternacional(): " + e);
        }
        return ultCompraInter;
    }

    //obtener lista de compra nacional
    public ArrayList<OrdenCompraNacional> getCompraNac(int anoBus, int periodoBus) {
        ArrayList<OrdenCompraNacional> ListNac = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select num_ord_com_nac,ano_ord_com_nac,periodo_est_com_nac,id_proveedor,cotizacion,fec_ord_com,con_ord_com,tel_ord_com,email,cta_cte_ban_ord_com,cen_cos_ord_com,fec_ent_ord_com,lug_ent_ord_com,moneda,for_pag_ord_com,pag_cre_dias,sol_ord_com,imp_bruto_sol,descuento_sol,sub_tot_sol,total_sol,igv,imp_bruto_dol,descuento_dol,sub_tot_dol,total_dol,estado,observacion from mae_ord_com_nac where ano_ord_com_nac = " + anoBus + " and periodo_est_com_nac = " + periodoBus + " and estado = 'P' order by num_ord_com_nac asc;");
            while (rs.next()) {
                OrdenCompraNacional compra = new OrdenCompraNacional();
                compra.setAno_ord_com_nac(rs.getInt("ano_ord_com_nac"));
                compra.setNum_ord_com_nac(rs.getInt("num_ord_com_nac"));
                compra.setPeriodo_est_com_nac(rs.getInt("periodo_est_com_nac"));
                compra.setId_proveedor(rs.getInt("id_proveedor"));
                compra.setCotizacion(rs.getString("cotizacion"));
                compra.setFec_ord_com(rs.getDate("fec_ord_com"));
                compra.setCon_ord_com(rs.getString("con_ord_com"));
                compra.setTel_ord_com(rs.getString("tel_ord_com"));
                compra.setEmail(rs.getString("email"));
                compra.setCta_cte_ban_ord_com(rs.getString("cta_cte_ban_ord_com"));
                compra.setCen_cos_ord_com(rs.getString("cen_cos_ord_com"));
                compra.setFec_ent_ord_com(rs.getDate("fec_ent_ord_com"));
                compra.setLug_ent_ord_com(rs.getString("lug_ent_ord_com"));
                compra.setMoneda(rs.getString("moneda"));
                compra.setFor_pago_ord_com(rs.getString("for_pag_ord_com"));
                compra.setPag_cre_dias(rs.getInt("pag_cre_dias"));
                compra.setSol_ord_com(rs.getString("sol_ord_com"));
                compra.setImp_bruto_sol(rs.getBigDecimal("imp_bruto_sol"));
                compra.setDescuento_sol(rs.getBigDecimal("descuento_sol"));
                compra.setSub_total_sol(rs.getBigDecimal("sub_tot_sol"));
                compra.setTotal_sol(rs.getBigDecimal("total_sol"));
                compra.setIgv(rs.getInt("igv"));
                compra.setImp_bruto_dol(rs.getBigDecimal("imp_bruto_dol"));
                compra.setDescuento_dol(rs.getBigDecimal("descuento_dol"));
                compra.setSub_total_dol(rs.getBigDecimal("sub_tot_dol"));
                compra.setTotal_dol(rs.getBigDecimal("total_dol"));
                compra.setEstado(rs.getString("estado"));
                compra.setObservacion(rs.getString("observacion"));
                ListNac.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar item: " + e);
        }
        return ListNac;
    }

    //obtener lista de compra internacinoal
    public ArrayList<OrdenCompraInter> getCompraInter(int anoBus, int periodoBus, String estadoBus) {
        ArrayList<OrdenCompraInter> ListInt = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select num_ord_com_int,ano_ord_com_int,periodo_est_com_int,id_proveedor,email,quote_number,fec_ord_com,pay_ter,incoterms,req_ship_date,fre_forw,cen_cos_ord_com,moneda,user_sol,ban_det,nro_cta,swi_cod,sub_total_dol,descuento_dol,neto_dol,transporte_dol,total_amo_dol,sub_total_sol,descuento_sol,neto_sol,transporte_sol,total_amo_sol,estado from mae_ord_com_int where ano_ord_com_int = " + anoBus + " and periodo_est_com_int = " + periodoBus + " and estado like '" + estadoBus + "' order by num_ord_com_int asc;");
            while (rs.next()) {

                OrdenCompraInter compra = new OrdenCompraInter();
                compra.setNum_ord_com_int(rs.getInt("num_ord_com_int"));
                compra.setAno_ord_com_int(rs.getInt("ano_ord_com_int"));
                compra.setPeriodo_est_com_int(rs.getInt("periodo_est_com_int"));
                compra.setId_proveedor(rs.getInt("id_proveedor"));
                compra.setEmail(rs.getString("email"));
                compra.setQuote_number(rs.getString("quote_number"));
                compra.setFec_ord_com(rs.getDate("fec_ord_com"));
                compra.setPay_ter(rs.getString("pay_ter"));
                compra.setIncoterms(rs.getString("incoterms"));
                compra.setReq_ship_date(rs.getString("req_ship_date"));
                compra.setFre_forw(rs.getString("fre_forw"));
                compra.setCen_cost_ord_com(rs.getString("cen_cos_ord_com"));
                compra.setMoneda(rs.getString("moneda"));
                compra.setUser_sol(rs.getString("user_sol"));
                compra.setBan_det(rs.getString("ban_det"));
                compra.setNro_cta(rs.getString("nro_cta"));
                compra.setSwi_cod(rs.getString("swi_cod"));
                compra.setSub_total_dol(rs.getBigDecimal("sub_total_dol"));
                compra.setDescuento_dol(rs.getBigDecimal("descuento_dol"));
                compra.setNeto_dol(rs.getBigDecimal("neto_dol"));
                compra.setTransporte_dol(rs.getBigDecimal("transporte_dol"));
                compra.setTotal_amo_dol(rs.getBigDecimal("total_amo_dol"));
                compra.setSub_total_sol(rs.getBigDecimal("sub_total_sol"));
                compra.setDescuento_sol(rs.getBigDecimal("descuento_sol"));
                compra.setNeto_sol(rs.getBigDecimal("neto_sol"));
                compra.setTransporte_sol(rs.getBigDecimal("transporte_sol"));
                compra.setTotal_amo_sol(rs.getBigDecimal("total_amo_sol"));
                compra.setEstado(rs.getString("estado"));
                ListInt.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar item: " + e);
        }
        return ListInt;
    }

    //obtener años que tienen compras nacionales
    public ArrayList<Integer> getAnoComNac() {
        ArrayList<Integer> ListAno = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ano_ord_com_nac from mae_ord_com_nac group by ano_ord_com_nac order by ano_ord_com_nac;");
            while (rs.next()) {
                ListAno.add(rs.getInt("ano_ord_com_nac"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar año: " + e);
        }
        return ListAno;
    }

    //obtener años que tienen compras internacionales
    public ArrayList<Integer> getAnoComInt() {
        ArrayList<Integer> ListAno = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ano_ord_com_int from mae_ord_com_int group by ano_ord_com_int order by ano_ord_com_int;");
            while (rs.next()) {
                ListAno.add(rs.getInt("ano_ord_com_int"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar año: " + e);
        }
        return ListAno;
    }

    //obtener periodos que tienen compras nacionales
    public ArrayList<Integer> getPerComNac(String anoSel) {
        ArrayList<Integer> ListPer = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select periodo_est_com_nac from mae_ord_com_nac where ano_ord_com_nac = " + anoSel + " group by periodo_est_com_nac order by periodo_est_com_nac;");
            while (rs.next()) {
                ListPer.add(rs.getInt("periodo_est_com_nac"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar año: " + e);
        }
        return ListPer;
    }

    //obtener periodos que tienen compras internacionales
    public ArrayList<Integer> getPerComInt(String anoSel) {
        ArrayList<Integer> ListPer = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select periodo_est_com_int from mae_ord_com_int where ano_ord_com_int = " + anoSel + " group by periodo_est_com_int order by periodo_est_com_int;");
            while (rs.next()) {
                ListPer.add(rs.getInt("periodo_est_com_int"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar año: " + e);
        }
        return ListPer;
    }

    //obtener 1 compra internacional
    public OrdenCompraInter getOneCompraInt(int anoCompra, int periodoCompra, int numCompra) {
        OrdenCompraInter CompraInt = new OrdenCompraInter();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select num_ord_com_int,ano_ord_com_int,periodo_est_com_int,id_proveedor,email,quote_number,fec_ord_com,pay_ter,incoterms,req_ship_date,fre_forw,cen_cos_ord_com,moneda,user_sol,ban_det,nro_cta,swi_cod,sub_total_dol,descuento_dol,neto_dol,transporte_dol,total_amo_dol,sub_total_sol,descuento_sol,neto_sol,transporte_sol,total_amo_sol,estado from mae_ord_com_int where ano_ord_com_int = " + anoCompra + " and periodo_est_com_int = " + periodoCompra + " and num_ord_com_int = " + numCompra + ";");
            if (rs.next()) {
                CompraInt.setNum_ord_com_int(rs.getInt("num_ord_com_int"));
                CompraInt.setAno_ord_com_int(rs.getInt("ano_ord_com_int"));
                CompraInt.setPeriodo_est_com_int(rs.getInt("periodo_est_com_int"));
                CompraInt.setId_proveedor(rs.getInt("id_proveedor"));
                CompraInt.setEmail(rs.getString("email"));
                CompraInt.setQuote_number(rs.getString("quote_number"));
                CompraInt.setFec_ord_com(rs.getDate("fec_ord_com"));
                CompraInt.setPay_ter(rs.getString("pay_ter"));
                CompraInt.setIncoterms(rs.getString("incoterms"));
                CompraInt.setReq_ship_date(rs.getString("req_ship_date"));
                CompraInt.setFre_forw(rs.getString("fre_forw"));
                CompraInt.setCen_cost_ord_com(rs.getString("cen_cos_ord_com"));
                CompraInt.setMoneda(rs.getString("moneda"));
                CompraInt.setUser_sol(rs.getString("user_sol"));
                CompraInt.setBan_det(rs.getString("ban_det"));
                CompraInt.setNro_cta(rs.getString("nro_cta"));
                CompraInt.setSwi_cod(rs.getString("swi_cod"));
                CompraInt.setSub_total_dol(rs.getBigDecimal("sub_total_dol"));
                CompraInt.setDescuento_dol(rs.getBigDecimal("descuento_dol"));
                CompraInt.setNeto_dol(rs.getBigDecimal("neto_dol"));
                CompraInt.setTransporte_dol(rs.getBigDecimal("transporte_dol"));
                CompraInt.setTotal_amo_dol(rs.getBigDecimal("total_amo_dol"));
                CompraInt.setSub_total_sol(rs.getBigDecimal("sub_total_sol"));
                CompraInt.setDescuento_sol(rs.getBigDecimal("descuento_sol"));
                CompraInt.setNeto_sol(rs.getBigDecimal("neto_sol"));
                CompraInt.setTransporte_sol(rs.getBigDecimal("transporte_sol"));
                CompraInt.setTotal_amo_sol(rs.getBigDecimal("total_amo_sol"));
                CompraInt.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de recuperar Compra Internacional 1: " + e);
        }
        return CompraInt;
    }

    //obtener 1 compra nacional
    public OrdenCompraNacional getOneCompraNac(int anoCompra, int periodoCompra, int numCompra) {
        OrdenCompraNacional CompraNac = new OrdenCompraNacional();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select num_ord_com_nac,ano_ord_com_nac,periodo_est_com_nac,id_proveedor,cotizacion,fec_ord_com,con_ord_com,tel_ord_com,email,cta_cte_ban_ord_com,cen_cos_ord_com,fec_ent_ord_com,lug_ent_ord_com,moneda,for_pag_ord_com,pag_cre_dias,sol_ord_com,imp_bruto_sol,descuento_sol,sub_tot_sol,total_sol,igv,imp_bruto_dol,descuento_dol,sub_tot_dol,total_dol,estado,observacion from mae_ord_com_nac where ano_ord_com_nac = " + anoCompra + " and periodo_est_com_nac = " + periodoCompra + " and num_ord_com_nac = " + numCompra + ";");
            if (rs.next()) {
                CompraNac.setAno_ord_com_nac(rs.getInt("ano_ord_com_nac"));
                CompraNac.setNum_ord_com_nac(rs.getInt("num_ord_com_nac"));
                CompraNac.setPeriodo_est_com_nac(rs.getInt("periodo_est_com_nac"));
                CompraNac.setId_proveedor(rs.getInt("id_proveedor"));
                CompraNac.setCotizacion(rs.getString("cotizacion"));
                CompraNac.setFec_ord_com(rs.getDate("fec_ord_com"));
                CompraNac.setCon_ord_com(rs.getString("con_ord_com"));
                CompraNac.setTel_ord_com(rs.getString("tel_ord_com"));
                CompraNac.setEmail(rs.getString("email"));
                CompraNac.setCta_cte_ban_ord_com(rs.getString("cta_cte_ban_ord_com"));
                CompraNac.setCen_cos_ord_com(rs.getString("cen_cos_ord_com"));
                CompraNac.setFec_ent_ord_com(rs.getDate("fec_ent_ord_com"));
                CompraNac.setLug_ent_ord_com(rs.getString("lug_ent_ord_com"));
                CompraNac.setMoneda(rs.getString("moneda"));
                CompraNac.setFor_pago_ord_com(rs.getString("for_pag_ord_com"));
                CompraNac.setPag_cre_dias(rs.getInt("pag_cre_dias"));
                CompraNac.setSol_ord_com(rs.getString("sol_ord_com"));
                CompraNac.setImp_bruto_sol(rs.getBigDecimal("imp_bruto_sol"));
                CompraNac.setDescuento_sol(rs.getBigDecimal("descuento_sol"));
                CompraNac.setSub_total_sol(rs.getBigDecimal("sub_tot_sol"));
                CompraNac.setTotal_sol(rs.getBigDecimal("total_sol"));
                CompraNac.setIgv(rs.getInt("igv"));
                CompraNac.setImp_bruto_dol(rs.getBigDecimal("imp_bruto_dol"));
                CompraNac.setDescuento_dol(rs.getBigDecimal("descuento_dol"));
                CompraNac.setSub_total_dol(rs.getBigDecimal("sub_tot_dol"));
                CompraNac.setTotal_dol(rs.getBigDecimal("total_dol"));
                CompraNac.setEstado(rs.getString("estado"));
                CompraNac.setObservacion(rs.getString("observacion"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de recuperar Compra Nacional One: " + e);
        }
        return CompraNac;
    }

    //obtener los items de una orden de compra nacional
    public ArrayList<ItemOrdenCompraNacional> getListItemOfCompraNac(int anoCompra, int periodoCompra, int numCompra) {
        ArrayList<ItemOrdenCompraNacional> listArt = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT REF_ANO_ORD_COM, REF_NUM_ORD_COM, PERIODO_ORD_COM, ITEM_ORD_COM, ID_ITEM, CANTIDAD, TIP_UNIDAD, PRECIOU, DESCUENTO, PRECIOF FROM MAE_ITE_ORD_COM_NAC WHERE REF_ANO_ORD_COM =  " + anoCompra + " AND  PERIODO_ORD_COM =  " + periodoCompra + " AND  REF_NUM_ORD_COM =  " + numCompra + ";");
            while (rs.next()) {
                ItemOrdenCompraNacional compra = new ItemOrdenCompraNacional();
                compra.setRef_ano_ord_com(rs.getInt("REF_ANO_ORD_COM"));
                compra.setRef_num_ord_com(rs.getInt("REF_NUM_ORD_COM"));
                compra.setPeriodo_ord_com(rs.getInt("PERIODO_ORD_COM"));
                compra.setItem_ord_com(rs.getInt("ITEM_ORD_COM"));
                compra.setId_item(rs.getString("ID_ITEM"));
                compra.setCantidad(rs.getInt("CANTIDAD"));
                compra.setTip_unidad(rs.getString("TIP_UNIDAD"));
                compra.setPrecioU(rs.getBigDecimal("PRECIOU"));
                compra.setDescuento(rs.getBigDecimal("DESCUENTO"));
                compra.setPrecioF(rs.getBigDecimal("PRECIOF"));
                listArt.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de recuperar items de Compra Nacional One: " + e);
        }
        return listArt;
    }

    //obtener los items de una orden de compra internacional
    public ArrayList<ItemOrdenCompraInter> getListItemOfCompraInt(int anoCompra, int periodoCompra, int numCompra) {
        ArrayList<ItemOrdenCompraInter> listArt = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT REF_ANO_ORD_COM,PERIODO_ORD_COM,REF_NUM_ORD_COM,ITEM_ORD_COM,COD_ITEM_ORD_COM,ID_ITEM,UNIDAD,CANTIDAD,UNI_PRECIO,DESCUENTO,IMPORTE_TOT FROM MAE_ITE_ORD_COM_INT WHERE REF_ANO_ORD_COM = " + anoCompra + " AND PERIODO_ORD_COM = " + periodoCompra + " AND REF_NUM_ORD_COM = " + numCompra + ";");
            while (rs.next()) {
                ItemOrdenCompraInter compra = new ItemOrdenCompraInter();
                compra.setRef_ano_ord_com(rs.getInt("REF_ANO_ORD_COM"));
                compra.setRef_num_ord_com(rs.getInt("REF_NUM_ORD_COM"));
                compra.setPeriodo_ord_com(rs.getInt("PERIODO_ORD_COM"));
                compra.setItem_ord_com(rs.getInt("ITEM_ORD_COM"));
                compra.setId_item(rs.getString("ID_ITEM"));
                compra.setUnidad(rs.getString("UNIDAD"));
                compra.setCantidad(rs.getInt("CANTIDAD"));
                compra.setUni_precio(rs.getBigDecimal("UNI_PRECIO"));
                compra.setDescuento(rs.getBigDecimal("DESCUENTO"));
                compra.setImporte_tot(rs.getBigDecimal("IMPORTE_TOT"));
                listArt.add(compra);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de recuperar items de Compra Internacional One: " + e);
        }
        return listArt;
    }

    //aprobar orden compra nacional
    public boolean modEstadoCompraNac(OrdenCompraNacional compra) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("UPDATE MAE_ORD_COM_NAC SET ESTADO = 'A' WHERE ANO_ORD_COM_NAC = ? AND PERIODO_EST_COM_NAC = ? AND NUM_ORD_COM_NAC = ? AND ESTADO = 'P';");
            query.setInt(1, compra.getAno_ord_com_nac());
            query.setInt(2, compra.getPeriodo_est_com_nac());
            query.setInt(3, compra.getNum_ord_com_nac());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de aprobar: " + e);
        }
        return confirma;
    }

    //aprobar orden compra internacional
    public boolean modEstadoCompraInt(OrdenCompraInter compra) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("UPDATE MAE_ORD_COM_INT SET ESTADO = 'A' WHERE ANO_ORD_COM_INT = ? AND PERIODO_EST_COM_INT = ? AND NUM_ORD_COM_INT = ? AND ESTADO = 'P';");
            query.setInt(1, compra.getAno_ord_com_int());
            query.setInt(2, compra.getPeriodo_est_com_int());
            query.setInt(3, compra.getNum_ord_com_int());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de aprobar: " + e);
        }
        return confirma;
    }
}

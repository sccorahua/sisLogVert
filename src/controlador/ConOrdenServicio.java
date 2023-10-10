package controlador;

// v1.0 SCN
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.OrdenServicio;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import modelo.ItemOrdenServicio;
import modelo.TipoCambio;

public class ConOrdenServicio {
    //obtener ultima orden nacional ingresada

    public int getUltOrdenServicio() {
        int ultCompraNacional = 0;
        Connection con = conexion.Conexion.conectar();
        ConOrdenCompra conOrden = new ConOrdenCompra();
        int anoActual = conOrden.getAnoActual("c");
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("select max(numero) as id from mae_ord_servicio where ano = " + anoActual + ";");
            if (rs.next()) {
                ultCompraNacional = rs.getInt("id");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de consultar getUltOrdenServicio(): " + e);
        }
        return ultCompraNacional;
    }

    //ingresar orden servicio
    public boolean insOrdServicio(OrdenServicio compra, String moneda) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            if (moneda.equals("Soles")) {
                //soles = 1
                PreparedStatement queryS = con.prepareStatement("INSERT INTO MAE_ORD_SERVICIO(NUMERO,ANO,PERIODO,PROVEEDOR,COTIZACION,ARE_SOL,FECHA,CONTACTO,TELEFONO,EMAIL,CTA_CTE_BANCO,OBSERVACIONES,CEN_COSTO,FEC_ENTREGA,ENT_LUGAR,MONEDA,FOR_PAGO,DIAS_PAGO,PER_SOL,IMP_BRUTO_SOL,DTO_SOL,SUB_TOT_SOL,TOTAL_SOL,IGV,IMP_BRUTO_DOL,DTO_DOL,SUB_TOT_DOL,TOTAL_DOL,ESTADO) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'1',?,?,?,?,?,?,?,?,?,?,?,?,'P');");
                queryS.setInt(1, compra.getNumero());
                queryS.setInt(2, compra.getAno());
                queryS.setInt(3, compra.getPeriodo());
                queryS.setInt(4, compra.getProveedor());
                queryS.setString(5, compra.getCotizacion());
                queryS.setString(6, compra.getAre_sol());
                queryS.setDate(7, compra.getFecha());
                queryS.setString(8, compra.getContacto());
                queryS.setString(9, compra.getTelefono());
                queryS.setString(10, compra.getEmail());
                queryS.setString(11, compra.getCta_cte_banco());
                queryS.setString(12, compra.getObservaciones());
                queryS.setString(13, compra.getCen_costo());
                queryS.setDate(14, compra.getFec_entrega());
                queryS.setString(15, compra.getEnt_lugar());
                queryS.setString(16, compra.getFor_pago());
                queryS.setInt(17, compra.getDias_pago());
                queryS.setString(18, compra.getPer_sol());

                BigDecimal ImpBrutoSol = compra.getImp_bruto_sol();
                BigDecimal DescuentoSol = compra.getDto_sol();
                BigDecimal SubTotalSol = compra.getSub_tot_sol();
                BigDecimal TotalSol = compra.getTotal_sol();

                queryS.setBigDecimal(19, ImpBrutoSol);
                queryS.setBigDecimal(20, DescuentoSol);
                queryS.setBigDecimal(21, SubTotalSol);
                queryS.setBigDecimal(22, TotalSol);
                queryS.setInt(23, compra.getIgv());

                ConTipoCambio metTipCambio = new ConTipoCambio();
                TipoCambio TipCambio = metTipCambio.conFecha(compra.getFecha());
                try {
                    BigDecimal compraDol = TipCambio.getTip_cambio_compra();

                    BigDecimal ImpBrutoDol = compra.getImp_bruto_sol().divide(compraDol, MathContext.DECIMAL128);
                    ImpBrutoDol = ImpBrutoDol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal DescuentoDol = compra.getDto_sol().divide(compraDol, MathContext.DECIMAL128);
                    DescuentoDol = DescuentoDol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal SubTotalDol = compra.getSub_tot_sol().divide(compraDol, MathContext.DECIMAL128);
                    SubTotalDol = SubTotalDol.setScale(2, RoundingMode.HALF_UP);

                    BigDecimal TotalDol = compra.getTotal_sol().divide(compraDol, MathContext.DECIMAL128);
                    TotalDol = TotalDol.setScale(2, RoundingMode.HALF_UP);

                    queryS.setBigDecimal(24, ImpBrutoDol);
                    queryS.setBigDecimal(25, DescuentoDol);
                    queryS.setBigDecimal(26, SubTotalDol);
                    queryS.setBigDecimal(27, TotalDol);
                } catch (SQLException e) {
                    System.out.println("Error al momento de guardar la cabecera de Orden de Servicio(Soles): " + e);
                }

                if (queryS.executeUpdate() > 0) {
                    confirma = true;
                }
            }
            if (moneda.equals("Dolares")) {
                //dolares = 2
                PreparedStatement queryD = con.prepareStatement("INSERT INTO MAE_ORD_SERVICIO(NUMERO,ANO,PERIODO,PROVEEDOR,COTIZACION,ARE_SOL,FECHA,CONTACTO,TELEFONO,EMAIL,CTA_CTE_BANCO,OBSERVACIONES,CEN_COSTO,FEC_ENTREGA,ENT_LUGAR,MONEDA,FOR_PAGO,DIAS_PAGO,PER_SOL,IMP_BRUTO_SOL,DTO_SOL,SUB_TOT_SOL,TOTAL_SOL,IGV,IMP_BRUTO_DOL,DTO_DOL,SUB_TOT_DOL,TOTAL_DOL,ESTADO) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'2',?,?,?,?,?,?,?,?,?,?,?,?,'P');");
                queryD.setInt(1, compra.getNumero());
                queryD.setInt(2, compra.getAno());
                queryD.setInt(3, compra.getPeriodo());
                queryD.setInt(4, compra.getProveedor());
                queryD.setString(5, compra.getCotizacion());
                queryD.setString(6, compra.getAre_sol());
                queryD.setDate(7, compra.getFecha());
                queryD.setString(8, compra.getContacto());
                queryD.setString(9, compra.getTelefono());
                queryD.setString(10, compra.getEmail());
                queryD.setString(11, compra.getCta_cte_banco());
                queryD.setString(12, compra.getObservaciones());
                queryD.setString(13, compra.getCen_costo());
                queryD.setDate(14, compra.getFec_entrega());
                queryD.setString(15, compra.getEnt_lugar());
                queryD.setString(16, compra.getFor_pago());
                queryD.setInt(17, compra.getDias_pago());
                queryD.setString(18, compra.getPer_sol());

                BigDecimal ImpBrutoDol = compra.getImp_bruto_dol();
                BigDecimal DescuentoDol = compra.getDto_dol();
                BigDecimal SubTotalDol = compra.getSub_tot_dol();
                BigDecimal TotalDol = compra.getTotal_dol();

                queryD.setBigDecimal(23, ImpBrutoDol);
                queryD.setBigDecimal(24, DescuentoDol);
                queryD.setBigDecimal(25, SubTotalDol);
                queryD.setBigDecimal(26, TotalDol);

                queryD.setInt(21, compra.getIgv());
                ConTipoCambio metTipCambio = new ConTipoCambio();
                TipoCambio TipCambio = metTipCambio.conFecha(compra.getFecha());
                try {
                    BigDecimal ventaDol = TipCambio.getTip_cambio_venta();

                    BigDecimal ImpBrutoSol = compra.getImp_bruto_dol().divide(ventaDol, MathContext.DECIMAL128);
                    BigDecimal DescuentoSol = compra.getDto_dol().divide(ventaDol, MathContext.DECIMAL128);
                    BigDecimal SubTotalSol = compra.getSub_tot_dol().divide(ventaDol, MathContext.DECIMAL128);
                    BigDecimal TotalSol = compra.getTotal_dol().divide(ventaDol, MathContext.DECIMAL128);

                    queryD.setBigDecimal(19, ImpBrutoSol);
                    queryD.setBigDecimal(20, DescuentoSol);
                    queryD.setBigDecimal(21, SubTotalSol);
                    queryD.setBigDecimal(22, TotalSol);
                } catch (SQLException e) {
                    System.out.println("Error al momento de guardar la cabecera de Orden de Servicio (Dolares): " + e);
                }

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

    //insertar item de orden de servicio
    public boolean itemOrdCompraNac(ItemOrdenServicio item) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO MAE_ITE_ORD_SERVICIO(REF_NUMERO,REF_ANO,REF_PERIODO,NRO_ITEM,DESCRIPCION,UNIDAD,CANTIDAD,PRE_UNITARIO,DESCUENTO,INPORTE) VALUE(?,?,?,?,?,?,?,?,?,?);");
            query.setInt(1, item.getRef_numero());
            query.setInt(2, item.getRef_ano());
            query.setInt(3, item.getRef_periodo());
            query.setInt(4, item.getNro_item());
            query.setString(5, item.getDescripcion());
            query.setString(6, item.getUnidad());
            query.setInt(7, item.getCantidad());
            query.setBigDecimal(8, item.getPre_unitario());
            query.setBigDecimal(9, item.getDescuento());
            query.setBigDecimal(10, item.getImporte());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar el item " + item.getNro_item() + " de Orden de Servicio: " + e);
        }

        return confirma;
    }

    //registrar item de servicio
    public boolean insItemOrdServicio(ItemOrdenServicio item) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO MAE_ITE_ORD_SERVICIO(REF_ANO,REF_NUMERO,REF_PERIODO,NRO_ITEM,DESCRIPCION,CANTIDAD,UNIDAD,PRE_UNITARIO,DESCUENTO,IMPORTE) VALUES (?,?,?,?,?,?,?,?,?,?);");
            query.setInt(1, item.getRef_ano());
            query.setInt(2, item.getRef_numero());
            query.setInt(3, item.getRef_periodo());
            query.setInt(4, item.getNro_item());
            query.setString(5, item.getDescripcion());
            query.setInt(6, item.getCantidad());
            query.setString(7, item.getUnidad());
            query.setBigDecimal(8, item.getPre_unitario());
            query.setBigDecimal(9, item.getDescuento());
            query.setBigDecimal(10, item.getImporte());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar el item " + item.getDescripcion() + " de Orden de Servicio: " + e);
        }

        return confirma;
    }

    //años que tienen orden de servicio
    public ArrayList<Integer> getAnosOrdServicio() {
        ArrayList<Integer> ListAno = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select ano from mae_ord_servicio group by ano order by ano;");
            while (rs.next()) {
                ListAno.add(rs.getInt("ano"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar año en getAnosOrdServicio(): " + e);
        }
        return ListAno;
    }

    //obtener periodos que tienen orden de servicio
    public ArrayList<Integer> getPersOrdServicio(String anoSel) {
        ArrayList<Integer> ListPer = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select PERIODO from mae_ord_servicio where ANO = " + anoSel + " group by PERIODO order by PERIODO;");
            while (rs.next()) {
                ListPer.add(rs.getInt("PERIODO"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de guardar el periodo en getPersOrdServicio(): " + e);
        }
        return ListPer;
    }

    //obtener lista de orden de servicio
    public ArrayList<OrdenServicio> getOrdServicio(int anoBus, int periodoBus, String estadoBus) {
        ArrayList<OrdenServicio> ListServicio = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("SELECT NUMERO,ANO,PERIODO,PROVEEDOR,COTIZACION,ARE_SOL,FECHA,CONTACTO,TELEFONO,EMAIL,CTA_CTE_BANCO,OBSERVACIONES,CEN_COSTO,FEC_ENTREGA,ENT_LUGAR,MONEDA,FOR_PAGO,DIAS_PAGO,PER_SOL,IMP_BRUTO_SOL,DTO_SOL,SUB_TOT_SOL,TOTAL_SOL,IGV,IMP_BRUTO_DOL,DTO_DOL,SUB_TOT_DOL,TOTAL_DOL,ESTADO FROM MAE_ORD_SERVICIO WHERE ANO = " + anoBus + " AND PERIODO = " + periodoBus + " AND ESTADO like ('" + estadoBus + "') ORDER BY NUMERO;");
            while (rs.next()) {
                OrdenServicio servicio = new OrdenServicio();
                servicio.setNumero(rs.getInt("NUMERO"));
                servicio.setAno(rs.getInt("ANO"));
                servicio.setPeriodo(rs.getInt("PERIODO"));
                servicio.setProveedor(rs.getInt("PROVEEDOR"));
                servicio.setCotizacion(rs.getString("COTIZACION"));
                servicio.setAre_sol(rs.getString("ARE_SOL"));
                servicio.setFecha(rs.getDate("FECHA"));
                servicio.setContacto(rs.getString("CONTACTO"));
                servicio.setTelefono(rs.getString("TELEFONO"));
                servicio.setEmail(rs.getString("EMAIL"));
                servicio.setCta_cte_banco(rs.getString("CTA_CTE_BANCO"));
                servicio.setObservaciones(rs.getString("OBSERVACIONES"));
                servicio.setCen_costo(rs.getString("CEN_COSTO"));
                servicio.setFec_entrega(rs.getDate("FEC_ENTREGA"));
                servicio.setEnt_lugar(rs.getString("ENT_LUGAR"));
                servicio.setMoneda(rs.getString("MONEDA"));
                servicio.setFor_pago(rs.getString("FOR_PAGO"));
                servicio.setDias_pago(rs.getInt("DIAS_PAGO"));
                servicio.setPer_sol(rs.getString("PER_SOL"));
                servicio.setImp_bruto_sol(rs.getBigDecimal("IMP_BRUTO_SOL"));
                servicio.setDto_sol(rs.getBigDecimal("DTO_SOL"));
                servicio.setSub_tot_sol(rs.getBigDecimal("SUB_TOT_SOL"));
                servicio.setTotal_sol(rs.getBigDecimal("TOTAL_SOL"));
                servicio.setIgv(rs.getInt("IGV"));
                servicio.setImp_bruto_dol(rs.getBigDecimal("IMP_BRUTO_DOL"));
                servicio.setImp_bruto_dol(rs.getBigDecimal("IMP_BRUTO_DOL"));
                servicio.setSub_tot_dol(rs.getBigDecimal("SUB_TOT_DOL"));
                servicio.setEstado(rs.getString("ESTADO"));

                ListServicio.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de obtener y listar Orden de Servicios: " + e);
        }
        return ListServicio;
    }

    //aprobar orden de servicio
    public boolean aprOrdenServicio(OrdenServicio servicio) {
        boolean confirma = false;
        Connection con = conexion.Conexion.conectar();
        try {
            PreparedStatement query = con.prepareStatement("UPDATE MAE_ORD_SERVICIO SET ESTADO = 'A' WHERE ANO = ? AND PERIODO = ? AND NUMERO = ? AND ESTADO = 'P';");
            query.setInt(1, servicio.getAno());
            query.setInt(2, servicio.getPeriodo());
            query.setInt(3, servicio.getNumero());

            if (query.executeUpdate() > 0) {
                confirma = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de aprobar la orden de servicio: " + e);
        }
        return confirma;
    }

    //obtener 1 orden de servicio
    public OrdenServicio getOneOrdServicio(int anoSer, int periodoSer, int numSer) {
        OrdenServicio servicio = new OrdenServicio();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            //ordenado por nombre de forma alfabetica
            ResultSet rs = st.executeQuery("SELECT NUMERO,ANO,PERIODO,PROVEEDOR,COTIZACION,ARE_SOL,FECHA,CONTACTO,TELEFONO,EMAIL,CTA_CTE_BANCO,OBSERVACIONES,CEN_COSTO,FEC_ENTREGA,ENT_LUGAR,MONEDA,FOR_PAGO,DIAS_PAGO,PER_SOL,IMP_BRUTO_SOL,DTO_SOL,SUB_TOT_SOL,TOTAL_SOL,IGV,IMP_BRUTO_DOL,DTO_DOL,SUB_TOT_DOL,TOTAL_DOL,ESTADO FROM MAE_ORD_SERVICIO WHERE ANO = " + anoSer + " AND PERIODO = " + periodoSer + " AND NUMERO = " + numSer + ";");
            if (rs.next()) {
                servicio.setNumero(rs.getInt("NUMERO"));
                servicio.setAno(rs.getInt("ANO"));
                servicio.setPeriodo(rs.getInt("PERIODO"));
                servicio.setProveedor(rs.getInt("PROVEEDOR"));
                servicio.setCotizacion(rs.getString("COTIZACION"));
                servicio.setAre_sol(rs.getString("ARE_SOL"));
                servicio.setFecha(rs.getDate("FECHA"));
                servicio.setContacto(rs.getString("CONTACTO"));
                servicio.setTelefono(rs.getString("TELEFONO"));
                servicio.setEmail(rs.getString("EMAIL"));
                servicio.setCta_cte_banco(rs.getString("CTA_CTE_BANCO"));
                servicio.setObservaciones(rs.getString("OBSERVACIONES"));
                servicio.setCen_costo(rs.getString("CEN_COSTO"));
                servicio.setFec_entrega(rs.getDate("FEC_ENTREGA"));
                servicio.setEnt_lugar(rs.getString("ENT_LUGAR"));
                servicio.setMoneda(rs.getString("MONEDA"));
                servicio.setFor_pago(rs.getString("FOR_PAGO"));
                servicio.setDias_pago(rs.getInt("DIAS_PAGO"));
                servicio.setPer_sol(rs.getString("PER_SOL"));
                servicio.setImp_bruto_sol(rs.getBigDecimal("IMP_BRUTO_SOL"));
                servicio.setDto_sol(rs.getBigDecimal("DTO_SOL"));
                servicio.setSub_tot_sol(rs.getBigDecimal("SUB_TOT_SOL"));
                servicio.setTotal_sol(rs.getBigDecimal("TOTAL_SOL"));
                servicio.setIgv(rs.getInt("IGV"));
                servicio.setImp_bruto_dol(rs.getBigDecimal("IMP_BRUTO_DOL"));
                servicio.setDto_dol(rs.getBigDecimal("DTO_DOL"));
                servicio.setSub_tot_dol(rs.getBigDecimal("SUB_TOT_DOL"));
                servicio.setTotal_dol(rs.getBigDecimal("TOTAL_DOL"));
                servicio.setEstado(rs.getString("ESTADO"));
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de recuperar Orden de Servicio One: " + e);
        }
        return servicio;
    }

    //obtener lista de articulos de orden servicio
    public ArrayList<ItemOrdenServicio> getListItemOfServicio(int anoCompra, int periodoCompra, int numCompra) {
        ArrayList<ItemOrdenServicio> listArt = new ArrayList<>();
        Connection con = conexion.Conexion.conectar();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT REF_ANO,REF_NUMERO,REF_PERIODO,NRO_ITEM,DESCRIPCION,UNIDAD,CANTIDAD,PRE_UNITARIO,DESCUENTO,IMPORTE FROM MAE_ITE_ORD_SERVICIO WHERE REF_ANO = " + anoCompra + " AND REF_PERIODO = " + periodoCompra + " AND REF_NUMERO = " + numCompra + " ORDER BY NRO_ITEM;");
            while (rs.next()) {
                ItemOrdenServicio servicio = new ItemOrdenServicio();
                servicio.setRef_ano(rs.getInt("REF_ANO"));
                servicio.setRef_numero(rs.getInt("REF_NUMERO"));
                servicio.setRef_periodo(rs.getInt("REF_PERIODO"));
                servicio.setNro_item(rs.getInt("NRO_ITEM"));
                servicio.setDescripcion(rs.getString("DESCRIPCION"));
                servicio.setCantidad(rs.getInt("CANTIDAD"));
                servicio.setUnidad(rs.getString("UNIDAD"));
                servicio.setPre_unitario(rs.getBigDecimal("PRE_UNITARIO"));
                servicio.setDescuento(rs.getBigDecimal("DESCUENTO"));
                servicio.setImporte(rs.getBigDecimal("IMPORTE"));
                listArt.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println("Error al momento de recuperar items de Orden de Servicio One: " + e);
        }
        return listArt;
    }
}

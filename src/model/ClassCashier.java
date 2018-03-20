
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

//~--- non-JDK imports --------------------------------------------------------
import action.Cashier;

//~--- JDK imports ------------------------------------------------------------
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class ClassCashier {

    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static volatile Cashier cashier = new Cashier();
    private static final NewXML newXML = new NewXML();

    /**
     * Inicia o caixa(turno)
     *
     * @param idCashier
     * @param userOpenCashier
     * @param valueCashierStart
     * @param turnCashier
     * @param terminalCashier
     * @return Integer
     */
    public static boolean newTurn(String idCashier, String userOpenCashier, Double valueCashierStart, Integer turnCashier, Integer terminalCashier) {

        try {

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_cashier VALUES(?,?,null,current_timestamp(),'0000-00-00 00:00:00',?,0,?,?)");
            ps.setString(1, idCashier);
            ps.setString(2, userOpenCashier);
            ps.setDouble(3, valueCashierStart);
            ps.setInt(4, turnCashier);
            ps.setInt(5, terminalCashier);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * Informa a tabela referente a abertura de caixa que o caixa foi fechado
     *
     * @param userCloseCashier
     * @param terminalCashier
     * @return boolean
     */
    public static boolean closeCashier(String userCloseCashier, String terminalCashier) {

        try {

            ps = Conn.connect().prepareStatement("UPDATE tbl_cashier SET user_end = ? , hour_close_cashier = current_timestamp(), isClosed = 1 WHERE isClosed = 0 AND idtbl_terminal = ? ;");
            ps.setString(1, userCloseCashier);
            ps.setString(2, terminalCashier);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * Recupera do DB os valores pertinentes ao controle de caixa
     *
     * @param terminalcashier
     * @return
     */
    public static Cashier valuesCashier(String terminalcashier) {

        try {

            Connection conn = Conn.connect();

            ps = conn.prepareStatement("SELECT `idtbl_cashier`,`idtbl_user`, `user_end`, `value_initial`, DATE_FORMAT(hour_opening_cashier,'%d/%m/%Y') AS date_open , TIME_FORMAT(hour_opening_cashier,'%H:%i:%s') AS hour_open, DATE_FORMAT(hour_close_cashier,'%d/%m/%Y') AS date_closed ,TIME_FORMAT(hour_close_cashier,'%H:%i:%s') AS hour_closed, `turn_operate`, `idtbl_terminal` FROM tbl_cashier  WHERE idtbl_terminal = ? AND isClosed = 0;");
            ps.setString(1, terminalcashier);
            rs = ps.executeQuery();

            while (rs.next()) {

                cashier.setIdCashier(rs.getString("idtbl_cashier"));
                cashier.setName_user_start_cashier(rs.getString("idtbl_user"));
                cashier.setValue_started_cashier(rs.getDouble("value_initial"));
                cashier.setDate_open_cashier(rs.getString("date_open"));
                cashier.setHour_open_cashier(rs.getString("hour_open"));
                cashier.setName_user_end_cashier(rs.getString("user_end"));
                cashier.setDate_close_cashier(rs.getString("date_closed"));
                cashier.setHour_close_cashier(rs.getString("hour_closed"));
                cashier.setTurn_cashier(rs.getInt("turn_operate"));
                cashier.setTerminal_cashier(rs.getString("idtbl_terminal"));

            }

            ps = conn.prepareStatement("SELECT SUM(value_used),type_opening FROM tbl_opening_cashier t  WHERE t.`idtbl_cashier` = (SELECT c.`idtbl_cashier` FROM tbl_cashier c WHERE idtbl_terminal = ? AND isClosed = 0)  GROUP BY type_opening;");
            ps.setString(1, terminalcashier);
            rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getInt(2) == 0) {

                    cashier.setValue_add_cashier(rs.getDouble(1));

                }

                if (rs.getInt(2) == 1) {

                    cashier.setValue_removed_cashier(rs.getDouble(1));

                }

            }

            ps = conn.prepareStatement("SELECT t.`description_type_payment_coupon` AS type_pay, (t.`value_type_payment_coupon` - t.`discount_type_pay`) AS value_total_pay, t.`discount_type_pay` FROM tbl_coupon p INNER JOIN tbl_type_payment_coupon t ON p.`idtbl_coupon` = t.`idtbl_coupon` WHERE date_hour_coupon >=(SELECT hour_opening_cashier FROM tbl_cashier WHERE idtbl_terminal = ? AND isClosed = 0) AND date_hour_coupon <= CURRENT_TIMESTAMP() AND terminal_coupon = ?  AND  t.`isCanceled` = 0;");
            ps.setString(1, terminalcashier);
            ps.setString(2, terminalcashier);
            rs = ps.executeQuery();

            double valueCash = 0;
            int qtdCash = 0;
            double valueCard = 0;
            int qtdCard = 0;
            double value_discount_card = 0;
            int qtd_discount_card = 0;
            double value_discount_cash = 0;
            int qtd_discount_cash = 0;

            while (rs.next()) {

                if (!rs.getString("type_pay").equals("DINHEIRO")) {

                    valueCard += (rs.getDouble("value_total_pay"));
                    qtdCard++;
                    if (rs.getDouble("discount_type_pay") > 0) {
                        qtd_discount_card++;
                        value_discount_card += (rs.getDouble("discount_type_pay"));
                    }

                } else if (rs.getString("type_pay").equals("DINHEIRO")) {

                    valueCash += (rs.getDouble("value_total_pay"));
                    qtdCash++;
                    if (rs.getDouble("discount_type_pay") > 0) {
                        qtd_discount_cash++;
                        value_discount_cash += (rs.getDouble("discount_type_pay"));
                    }

                }

            }
 
            cashier.setValue_discount_cash(value_discount_cash);
            cashier.setQuantyti_discount_cash(qtd_discount_cash);
            cashier.setValue_discount_card(value_discount_card);
            cashier.setQuantyti_discount_card(qtd_discount_card);
            cashier.setValue_sales_card(valueCard);
            cashier.setQuantyti_sales_card(qtdCard);
            cashier.setValue_sales_cash(valueCash);
            cashier.setQuantyti_sales_cash(qtdCash);
            cashier.setValue_remainder_cashier(((cashier.getValue_sales_cash() + cashier.getValue_started_cashier()) + (cashier.getValue_add_cashier() - cashier.getValue_removed_cashier())));

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);

        }

        return cashier;
    }

    public static Cashier valuesOldCashier(String arg) {

        try {

            Connection conn = Conn.connect();

            ps = conn.prepareStatement("SELECT `idtbl_cashier`, `idtbl_user`, `user_end`, `value_initial`, DATE_FORMAT(hour_opening_cashier,'%d/%m/%Y') AS date_open , TIME_FORMAT(hour_opening_cashier,'%H:%i:%s') AS hour_open, DATE_FORMAT(hour_close_cashier,'%d/%m/%Y') AS date_closed ,TIME_FORMAT(hour_close_cashier,'%H:%i:%s') AS hour_closed, `turn_operate`, `idtbl_terminal` FROM tbl_cashier  WHERE idtbl_cashier = ?;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                cashier.setIdCashier(rs.getString("idtbl_cashier"));
                cashier.setName_user_start_cashier(rs.getString("idtbl_user"));
                cashier.setValue_started_cashier(rs.getDouble("value_initial"));
                cashier.setDate_open_cashier(rs.getString("date_open"));
                cashier.setHour_open_cashier(rs.getString("hour_open"));
                cashier.setName_user_end_cashier(rs.getString("user_end"));
                cashier.setDate_close_cashier(rs.getString("date_closed"));
                cashier.setHour_close_cashier(rs.getString("hour_closed"));
                cashier.setTurn_cashier(rs.getInt("turn_operate"));
                cashier.setTerminal_cashier(rs.getString("idtbl_terminal"));

            }

            ps = conn.prepareStatement("SELECT SUM(value_used),type_opening FROM tbl_opening_cashier t  WHERE t.`idtbl_cashier` = (SELECT c.`idtbl_cashier` FROM tbl_cashier c WHERE idtbl_cashier = ? )  GROUP BY type_opening;");
            ps.setString(1, arg);
            rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getInt(2) == 0) {

                    cashier.setValue_add_cashier(rs.getDouble(1));

                }

                if (rs.getInt(2) == 1) {

                    cashier.setValue_removed_cashier(rs.getDouble(1));

                }

            }

            ps = conn.prepareStatement("SELECT t.`description_type_payment_coupon` AS type_pay, SUM(t.`value_type_payment_coupon` - t.`discount_type_pay`) AS value_total_pay ,COUNT(t.`value_type_payment_coupon`) AS quantity_total_pay, SUM(t.`discount_type_pay`) AS discount_type_pay FROM tbl_coupon p INNER JOIN tbl_type_payment_coupon t ON p.`idtbl_coupon` = t.`idtbl_coupon` WHERE date_hour_coupon >=(SELECT hour_opening_cashier FROM tbl_cashier WHERE idtbl_cashier = ? ) AND date_hour_coupon <= (SELECT hour_close_cashier FROM tbl_cashier WHERE idtbl_cashier = ? ) AND t.`isCanceled` = 0   GROUP BY t.`description_type_payment_coupon`;");
            ps.setString(1, arg);
            ps.setString(2, arg);
            rs = ps.executeQuery();
        
            double valueCash = 0;
            int qtdCash = 0;
            double valueCard = 0;
            int qtdCard = 0;
            double value_discount_card = 0;
            int qtd_discount_card = 0;
            double value_discount_cash = 0;
            int qtd_discount_cash = 0;

            while (rs.next()) {

                if (!rs.getString("type_pay").equals("DINHEIRO")) {

                    valueCard += (rs.getDouble("value_total_pay"));
                    qtdCard++;
                    if (rs.getDouble("discount_type_pay") > 0) {
                        qtd_discount_card++;
                        value_discount_card += (rs.getDouble("discount_type_pay"));
                    }

                } else if (rs.getString("type_pay").equals("DINHEIRO")) {

                    valueCash += (rs.getDouble("value_total_pay"));
                    qtdCash++;
                    if (rs.getDouble("discount_type_pay") > 0) {
                        qtd_discount_cash++;
                        value_discount_cash += (rs.getDouble("discount_type_pay"));
                    }

                }

            }
            System.err.println("DISCOUNT::"+value_discount_card);
            cashier.setValue_discount_cash(value_discount_cash);
            cashier.setQuantyti_discount_cash(qtd_discount_cash);
            cashier.setValue_discount_card(value_discount_card);
            cashier.setQuantyti_discount_card(qtd_discount_card);
            cashier.setValue_sales_card(valueCard);
            cashier.setQuantyti_sales_card(qtdCard);
            cashier.setValue_sales_cash(valueCash);
            cashier.setQuantyti_sales_cash(qtdCash);
            cashier.setValue_remainder_cashier(((cashier.getValue_sales_cash() + cashier.getValue_started_cashier()) + (cashier.getValue_add_cashier() - cashier.getValue_removed_cashier())));

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);

        }

        return cashier;
    }

    /**
     * Verifica se o caixa esta iniciado e carrega bean Caixa com seus
     * respectivos valores (incompleto)
     *
     * @param terminalCashier
     * @return boolean
     */
    public static String isOpened(String terminalCashier) {

        try {

            ps = Conn.connect().prepareStatement("SELECT idtbl_cashier FROM tbl_cashier WHERE  idtbl_terminal = ? AND isClosed = 0;");
            ps.setString(1, terminalCashier);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("idtbl_cashier");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Insere dados na tabela abertura de caixa valores pertinentes ao uso do
     * caixa(sangria,suprimento,etc...)
     *
     * @param valueUsed
     * @param description
     * @param typeOpeningCashier
     * @param turnCashier
     * @param terminalCashier
     * @return boolean
     */
    public static boolean newOpening(double valueUsed, String description, int typeOpeningCashier, int turnCashier, int terminalCashier) {

        String idTbl_caixa = null;

        try {

            ps = Conn.connect().prepareStatement("SELECT idtbl_cashier FROM tbl_cashier t WHERE idtbl_terminal = ? AND isClosed = 0;");
            ps.setInt(1, terminalCashier);
            rs = ps.executeQuery();

            if (rs.next()) {

                idTbl_caixa = rs.getString("idtbl_cashier");

            }

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_opening_cashier VALUES(0,?,current_timestamp(),?,?,?,?,?)");
            ps.setString(1, idTbl_caixa);
            ps.setDouble(2, valueUsed);
            ps.setInt(3, typeOpeningCashier);
            ps.setInt(4, turnCashier);
            ps.setInt(5, terminalCashier);
            ps.setString(6, description);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * Consulta o turno que foi aberto o caixa atual em uso
     *
     * @param terminal
     * @return String
     */
    public static String turnTerminal(String terminal) {

        try {

            ps = Conn.connect().prepareStatement("SELECT turn_operate FROM tbl_cashier t WHERE idtbl_terminal = ? AND isClosed = 0;");
            ps.setString(1, terminal);
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString("turn_operate");

            } else {

                return "__";
            }

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            return null;

        }

    }

    public static void clearBean() {

        cashier.setName_user_start_cashier(null);
        cashier.setValue_started_cashier(0);
        cashier.setDate_open_cashier(null);
        cashier.setHour_open_cashier(null);
        cashier.setName_user_end_cashier(null);
        cashier.setDate_close_cashier(null);
        cashier.setHour_close_cashier(null);
        cashier.setTurn_cashier(0);
        cashier.setTerminal_cashier("00");
        cashier.setValue_add_cashier(0);
        cashier.setValue_removed_cashier(0);
        cashier.setValue_sales_card(0);
        cashier.setQuantyti_sales_card(0);
        cashier.setValue_sales_cash(0);
        cashier.setQuantyti_sales_cash(0);

    }
}

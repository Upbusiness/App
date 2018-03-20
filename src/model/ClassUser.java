/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.BeanLogin;
import action.BeanUser;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class ClassUser {

    private static ResultSet rs;
    private static PreparedStatement ps;
    private static final NewXML newXML = new NewXML();
    private static Statement stmt;

    public static boolean loginUser(String user_login, String password_login) {

        String sql = "SELECT"
                + " t.`idtbl_user`,"
                + " t.`user_password`,"
                + " t.`isReportAccess`,"
                + " t.`isCoastOperationAccess`,"
                + " t.`isCancelAccess`,"
                + " t.`isCashierAccess`,"
                + " t.`isSaleAccess`,"
                + " t.`isRegisterProductsAccess`,"
                + " t.`isControlReserveAccess`,"
                + " t.`isRegisterCategoryAccess`,"
                + " t.`isRegisterUserAccess`,"
                + " t.`isConfigRates`,"
                + " t.`isAccessRestrict`,"
                + " t.`isRegisterCardAccess` FROM tbl_user t  WHERE  t.`idtbl_user` = ? AND  t.`user_password` = ?;";

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, user_login);
            ps.setString(2, password_login);
            rs = ps.executeQuery();
            if (rs.next()) {
                BeanLogin.setUser(rs.getString("idtbl_user"));
                BeanLogin.setIsCoastOperationAccess(rs.getBoolean("isCoastOperationAccess"));
                BeanLogin.setIsCashierAccess(rs.getBoolean("isCashierAccess"));
                BeanLogin.setIsCancelAccess(rs.getBoolean("isCancelAccess"));
                BeanLogin.setIsReportAccess(rs.getBoolean("isReportAccess"));
                BeanLogin.setIsSaleAccess(rs.getBoolean("isSaleAccess"));
                BeanLogin.setIsRegisterProductsAccess(rs.getBoolean("isRegisterProductsAccess"));
                BeanLogin.setIsControlReserveAccess(rs.getBoolean("isControlReserveAccess"));
                BeanLogin.setIsRegisterCategoryAccess(rs.getBoolean("isRegisterCategoryAccess"));
                BeanLogin.setIsRegisterUserAccess(rs.getBoolean("isRegisterUserAccess"));
                BeanLogin.setIsRegisterCardAccess(rs.getBoolean("isRegisterCardAccess"));
                BeanLogin.setIsConfigRates(rs.getBoolean("isConfigRates"));
                BeanLogin.setIsAccessRestrict(rs.getBoolean("isAccessRestrict"));

                CallableStatement call_stmt = Conn.connect().prepareCall("{CALL SP_REGISTER_LOGIN(?, ?)}");
                call_stmt.setString(1, user_login);
                call_stmt.setString(2, password_login);
                call_stmt.execute();

                return true;
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    public static boolean validatorCode(String codigo) {

        try {

            ps = Conn.connect().prepareStatement("SELECT * FROM tbl_code_main WHERE code_main = ? ;");
            ps.setString(1, codigo);

            rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean validTerminal() {

        try {

            stmt = Conn.connect().createStatement();

            rs = stmt.executeQuery("SELECT t.`changes_number` FROM tbl_active t;");
            rs.next();
            return rs.getInt("changes_number") <= 0;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean newUser(List<Object> arg) {

        try {

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_user ( "
                    + " `isSaleAccess`,"
                    + " `isRegisterProductsAccess`,"
                    + " `isCashierAccess`,"
                    + " `isCancelAccess`,"
                    + " `isCoastOperationAccess`,"
                    + " `isAccessRestrict`,"
                    + " `isConfigRates`,"
                    + " `isRegisterCategoryAccess`,"
                    + " `isRegisterUserAccess`,"
                    + " `isRegisterCardAccess`,"
                    + " `isControlReserveAccess`,"
                    + " `isReportAccess`,"                    
                    + " `user_password`,"
                    + " `idtbl_user`)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

            ps.setObject(1, arg.get(0));
            ps.setObject(2, arg.get(1));
            ps.setObject(3, arg.get(2));
            ps.setObject(4, arg.get(3));
            ps.setObject(5, arg.get(4));
            ps.setObject(6, arg.get(5));
            ps.setObject(7, arg.get(6));
            ps.setObject(8, arg.get(7));
            ps.setObject(9, arg.get(8));
            ps.setObject(10, arg.get(9));
            ps.setObject(11, arg.get(10));
            ps.setObject(12, arg.get(11));
            ps.setObject(13, arg.get(12));
            ps.setObject(14, arg.get(13));

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {                      
            return false;
        }
    }

    public static List<Object> searchUser(String login) {

        String sql = "SELECT"
                + " t.`idtbl_user`,"
                + " t.`user_password`,"
                + " t.`isReportAccess`,"
                + " t.`isCoastOperationAccess`,"
                + " t.`isCancelAccess`,"
                + " t.`isCashierAccess`,"
                + " t.`isSaleAccess`,"
                + " t.`isRegisterProductsAccess`,"
                + " t.`isControlReserveAccess`,"
                + " t.`isRegisterCategoryAccess`,"
                + " t.`isRegisterUserAccess`,"
                + " t.`isConfigRates`,"
                + " t.`isAccessRestrict`,"
                + " t.`isRegisterCardAccess` FROM tbl_user t  WHERE  t.`idtbl_user` = ? ;";

        try {
            List<Object> list = new ArrayList<>();
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, login);

            rs = ps.executeQuery();
            if (rs.next()) {

                list.add(rs.getBoolean("isSaleAccess"));
                list.add(rs.getBoolean("isRegisterProductsAccess"));
                list.add(rs.getBoolean("isCashierAccess"));
                list.add(rs.getBoolean("isCancelAccess"));
                list.add(rs.getBoolean("isCoastOperationAccess"));
                list.add(rs.getBoolean("isAccessRestrict"));
                list.add(rs.getBoolean("isConfigRates"));
                list.add(rs.getBoolean("isRegisterCategoryAccess"));
                list.add(rs.getBoolean("isRegisterUserAccess"));
                list.add(rs.getBoolean("isRegisterCardAccess"));
                list.add(rs.getBoolean("isControlReserveAccess"));
                list.add(rs.getBoolean("isReportAccess"));
                list.add(rs.getString("idtbl_user"));
                list.add(rs.getString("user_password"));

                return list;
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);
            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public static boolean editUser(List<Object> arg) {

        try {

            ps = Conn.connect().prepareStatement("UPDATE tbl_user SET  "
                    + " isSaleAccess = ?,"
                    + " isRegisterProductsAccess = ?,"
                    + " isCashierAccess = ?,"
                    + " isCancelAccess = ?,"
                    + " isCoastOperationAccess = ?,"
                    + " isAccessRestrict = ?,"
                    + " isConfigRates = ?,"
                    + " isRegisterCategoryAccess = ?,"
                    + " isRegisterUserAccess = ?,"
                    + " isRegisterCardAccess = ?,"
                    + " isControlReserveAccess = ?,"
                    + " isReportAccess = ?,"
                    + " user_password = ?"
                    + "  WHERE  idtbl_user = ?");

            ps.setObject(1, arg.get(0));
            ps.setObject(2, arg.get(1));
            ps.setObject(3, arg.get(2));
            ps.setObject(4, arg.get(3));
            ps.setObject(5, arg.get(4));
            ps.setObject(6, arg.get(5));
            ps.setObject(7, arg.get(6));
            ps.setObject(8, arg.get(7));
            ps.setObject(9, arg.get(8));
            ps.setObject(10, arg.get(9));
            ps.setObject(11, arg.get(10));
            ps.setObject(12, arg.get(11));
            ps.setObject(13, arg.get(12));
            ps.setObject(14, arg.get(13));

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

            Logger.getLogger(ClassUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static boolean deleteUser(String arg) {

        try {
            ps = Conn.connect().prepareStatement("DELETE FROM tbl_user WHERE  idtbl_user = ?");
            ps.setString(1, arg);
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.println("ERROR::" + ex);
            Logger.getLogger(ClassUser.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}

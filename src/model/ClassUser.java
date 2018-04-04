/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Rafael Recalcatti
 */
public class ClassUser {

    private static ResultSet rs;
    private static PreparedStatement ps;   
    private static Statement stmt;

    public static void loginUser(String userLogin, String passwordLogin) {

        String sql = "SELECT "
                + "t.`idtbl_user`, t.`user_name` "               
                +" FROM tbl_user t  WHERE  t.`user_name` = ? AND  t.`user_password` = ?;";

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, userLogin);
            ps.setString(2, passwordLogin);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                
               Login.setIdLogin(rs.getInt("idtbl_user"));
               Login.setNameUser(rs.getString("user_name"));
               
                //CallableStatement call_stmt = Conn.connect().prepareCall("{CALL SP_REGISTER_LOGIN(?, ?)}");
                //call_stmt.setString(1, user_login);
                //call_stmt.setString(2, password_login);
                //call_stmt.execute();             
            }else{
                
               Login.setIdLogin(0);
               Login.setNameUser("Dont Loged");
                
            }
        } catch (SQLException ex) {
           
            Login.setIdLogin(0);
            Login.setNameUser("Dont Loged");
            System.err.println("ERROR::" + ex);
            Logger.getLogger(ClassCashier.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }

    public static boolean validUser(int idLogin, int typeAccess) {

        String sql = "SELECT * FROM tbl_access_to_user ac "
                + "INNER JOIN tbl_user us ON ac.idtbl_user = us.idtbl_user "
                + "WHERE us.idtbl_user = ? AND ac.idtbl_access = ?;";

        try {
            ps = Conn.connect().prepareStatement(sql);
            ps.setInt(1, idLogin);
            ps.setInt(2, typeAccess);
            rs = ps.executeQuery();
            
            return rs.next();
                                             
                //CallableStatement call_stmt = Conn.connect().prepareCall("{CALL SP_REGISTER_LOGIN(?, ?)}");
                //call_stmt.setString(1, user_login);
                //call_stmt.setString(2, password_login);
                //call_stmt.execute();
    
        } catch (SQLException ex) {
           
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

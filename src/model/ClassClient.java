/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import action.AccountClient;
import action.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import view.ClassPrintCoupon;
import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class ClassClient {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final Connection conn = Conn.connect();
    private static final List<String> list_type_pay_coupon = new ArrayList<>();
    private static final List<Double> list_value_pay_coupon = new ArrayList<>();
    private static final List<Double> list_value_cash_pay_coupon = new ArrayList<>();
    private static final NewXML newXML = new NewXML();
    private static boolean isCigarreteAddPrice;
    private static ClassPrintCoupon cpc;

    public static Client consultClient(String arg) {

        try {

            Client client = new Client();

            ps = Conn.connect().prepareStatement("SELECT "
                    + " t.`idtbl_client`,"
                    + " t.`cpf_client`,"
                    + " t.`name_client`,"
                    + " t.`phone_client`,"
                    + " t.`address_client`,"
                    + " t.`district_client`,"
                    + " t.`city_client`"
                    + " FROM tbl_client t WHERE t.`cpf_client` = ? OR t.`idtbl_client` = ? ;");

            ps.setString(1, arg);
            ps.setString(2, arg);
            rs = ps.executeQuery();

            if (rs.next()) {

                client.setIdtbl_client(new DecimalFormat("0000").format(rs.getInt("idtbl_client")));
                client.setCpf_client(rs.getString("cpf_client"));
                client.setName_client(rs.getString("name_client"));
                client.setAddress_client(rs.getString("address_client"));
                client.setPhone_client(rs.getString("phone_client"));
                client.setDistrict_client(rs.getString("district_client"));
                client.setCity_client(rs.getString("city_client"));

                return client;

            } else {

                client.setIdtbl_client(null);
                return client;

            }

        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);

            return null;

        }
    }
    
     public static AccountClient consultAccountClient(String arg) {

        try {

            AccountClient aClient = new AccountClient();

            ps = Conn.connect().prepareStatement("SELECT t.`idtbl_client`,"
                    + " t.`idtbl_account`,"
                    + " tp.`description_type_payment_coupon`,"
                    + " DATE_FORMAT(t.`date_account`,'%d/%m/%Y %H:%i') AS `_date_account`,"
                    + " t.`value_account`,"
                    + " t.`status_acount`,"
                    + " c.`cpf_client`,"
                    + " c.`name_client`,"
                    + " c.`phone_client`"
                    + " FROM tbl_account t INNER JOIN tbl_type_payment_coupon tp ON t.`idtbl_coupon` = tp.`idtbl_coupon` "
                    + "                    INNER JOIN tbl_client c ON c.`idtbl_client` = t.`idtbl_client` "
                    + "WHERE t.`idtbl_account` = ? ORDER BY t.`date_account` DESC;");

            ps.setString(1, arg);            
            rs = ps.executeQuery();

            if (rs.next()) {

                aClient.setIdtbl_client(new DecimalFormat("0000").format(rs.getInt("idtbl_client")));
                aClient.setCpf_client(rs.getString("cpf_client"));
                aClient.setName_client(rs.getString("name_client"));
                aClient.setPhone_client(rs.getString("phone_client"));
                aClient.setDescription_account(rs.getString("description_type_payment_coupon"));
                aClient.setDate_account(rs.getString("_date_account"));
                aClient.setValue_acount(rs.getDouble("value_account"));
                aClient.setStatus_acount(rs.getString("status_acount"));
                aClient.setId_account(new DecimalFormat("0000").format(rs.getInt("idtbl_account")));
                System.err.println("ID ACCOUNT"+aClient.getId_account());
                return aClient;

            } else {

                aClient.setIdtbl_client(null);
                return aClient;

            }

        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);

            return null;

        }
    }

    public static boolean newClient(Client client) {

        try {

            String sql = "INSERT INTO tbl_client VALUES(0,?,?,?,?,?,?);";

            ps = Conn.connect().prepareStatement(sql);

            ps.setString(1, client.getCpf_client());
            ps.setString(2, client.getName_client());
            ps.setString(3, client.getPhone_client());
            ps.setString(4, client.getAddress_client());
            ps.setString(5, client.getDistrict_client());
            ps.setString(6, client.getCity_client());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean refreshClient(Client client) {

        try {

            String sql = "UPDATE tbl_client SET "
                    + " `cpf_client` = ? ,"
                    + " `name_client` = ? ,"
                    + " `phone_client` = ? ,"
                    + " `address_client` = ? ,"
                    + " `district_client` = ? ,"
                    + " `city_client` = ?"
                    + " WHERE `idtbl_client` = ?";

            ps = Conn.connect().prepareStatement(sql);

            ps.setString(1, client.getCpf_client());
            ps.setString(2, client.getName_client());
            ps.setString(3, client.getPhone_client());
            ps.setString(4, client.getAddress_client());
            ps.setString(5, client.getDistrict_client());
            ps.setString(6, client.getCity_client());
            ps.setString(7, client.getIdtbl_client());

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);

            return false;
        }

    }

    public static boolean deleteClient(String arg) {

        try {

            String sql = "DELETE FROM tbl_client WHERE idtbl_client = ? ;";

            ps = Conn.connect().prepareStatement(sql);
            ps.setString(1, arg);
            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);
            return false;
        }

    }

    public static boolean consultCPF(String arg) {
        
        try {
            ps = Conn.connect().prepareStatement("SELECT COUNT(*)AS total FROM  tbl_client WHERE cpf_client = ?");

            ps.setString(1, arg);
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("total") > 0;
            } else {
                return false;
            }
        } catch (SQLException ex) {

            System.err.println("ERROR::" + ex);

            return false;

        }

    }

}

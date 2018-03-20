/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import xml.NewXML;

/**
 *
 * @author CPU
 */
public class ClassAccess {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static Connection conn; //= Conn.connect();
    private static final NewXML newXML = new NewXML();

    private static String getHDSerial() throws IOException {
        String os = System.getProperty("os.name");

        try {
            if (os.startsWith("Windows")) {
                return getHDSerialWindows("C");
                // } else if(os.startsWith("Linux")) {  
                //    return getHDSerialLinux("D");  
            } else {
                throw new IOException("unknown operating system: " + os);
            }
        } catch (Exception ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);
            ;
            throw new IOException(ex.getMessage());
        }
    }

    public static String getHDSerialWindows(String drive) {
        String result = "";
        try {
            //File file = File.createTempFile("tmp",".vbs");  
            File file = File.createTempFile("tmp", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n" + "Set colDrives = objFSO.Drives\n"
                    + "Set objDrive = colDrives.item(\"" + drive + "\")\n" + "Wscript.Echo objDrive.SerialNumber";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (IOException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }
        if (result.trim().length() < 1 || result == null) {
            result = "NO_DISK_ID";

        }

        return result.trim();
    }

    public static boolean registerSerial(String access) throws IOException {

        try {

            ps = conn.prepareStatement("INSERT INTO tbl_active(code_active,changes_number) VALUES(AES_ENCRYPT(?,?),30);");
            ps.setString(1, getHDSerial());
            ps.setString(2, access);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);
            Logger.getLogger(ClassAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void keyCript(String key) {

        try {

            ps = conn.prepareStatement("SELECT @CHAVE_CRIPTOGRAFIA : = ?;");
            ps.setString(1, key);
            ps.executeQuery();

        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

        }

    }

    public static boolean consultSerial(String access) {

        try {

            ps = conn.prepareStatement("SELECT AES_DECRYPT(code_active, ?) AS serial_code FROM tbl_active;");
            ps.setString(1, access);
            rs = ps.executeQuery();
            rs.next();
            System.err.println("SERIAL DB::" + rs.getString("serial_code"));
            System.err.println("SERIAL HD::" + getHDSerial());
            return rs.getString("serial_code").equals(getHDSerial());

        } catch (SQLException | IOException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);
            return false;
        }

    }

    public static void main(String[] args) throws IOException {
      // TODO Auto-generated catch block

        registerSerial("1820218110");
        System.out.println(getHDSerial());

    }

}

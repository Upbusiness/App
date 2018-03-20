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
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClassCard;
import model.Conn;
import xml.NewXML;

/**
 *
 * @author User
 */
public class ClassSerialHD {

    private static PreparedStatement ps;
    private static Statement stmt;
    private static ResultSet rs;
    private static final NewXML newXML = new NewXML();
    

    public static String getHDSerial() throws IOException {
        String os = System.getProperty("os.name");

        try {
            if (os.startsWith("Windows")) {
                return getHDSerialWindows("C");
                // } else if(os.startsWith("Linux")) {  
                //    return getHDSerialLinux("D");  
            } else {
                throw new IOException("unknown operating system: " + os);
            }
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            ;
            throw new IOException(ex.getMessage());
        }
    }

    public static String getHDSerialWindows(String drive) {
        String result = "";
        try {
            
            File file = File.createTempFile("tmp", ".vbs");
            file.deleteOnExit();
            
            try (FileWriter fw = new java.io.FileWriter(file)) {
                String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n" + "Set colDrives = objFSO.Drives\n"
                        + "Set objDrive = colDrives.item(\"" + drive + "\")\n" + "Wscript.Echo objDrive.SerialNumber";
                fw.write(vbs);
            }
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());

        }
        if (result.trim().length() < 1 || result == null) {
            result = "NO_DISK_ID";

        }

        return result.trim();
    }

    public static boolean registerSerial(String access) throws IOException {

        try {

            ps = Conn.connect().prepareStatement("INSERT INTO tbl_active(code_active,changes_number) VALUES(AES_ENCRYPT(?,?),30);");

            ps.setString(1, getHDSerial());
            ps.setString(2, access);

            return ps.executeUpdate() == 1;

        } catch (SQLException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            Logger.getLogger(ClassCard.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static void main(String[] args) {
        try {

            FileWriter arquivo = new FileWriter("F:\\serialHD.txt");            
            PrintWriter gravarArq = new PrintWriter(arquivo);

            gravarArq.printf(getHDSerial());
         

            arquivo.close();
           
           
            System.out.println("Serial HD: " + getHDSerial());
            //registerSerial("123456");
        } catch (IOException ex) {
            // TODO Auto-generated catch block
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            
        }

    }

}

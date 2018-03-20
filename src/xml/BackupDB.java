/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Rafiusks
 */
public class BackupDB {

    private static final NewXML newXML = new NewXML();

    public static void main(String args[]) {

        BackupDB bc = new BackupDB();
        bc.deleteXMLFile();

    }

    public void deleteXMLFile() {

        File origem = new File("lots_products_1.xml");

        try {

            origem.delete();
            origem.createNewFile();
            System.out.println(origem.exists());

        } catch (IOException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        } finally {
            System.out.println("Finalizando");
        }

    }
}

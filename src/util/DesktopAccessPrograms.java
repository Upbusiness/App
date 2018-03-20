/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 *
 * @author Rafael Recalcatti
 */
public class DesktopAccessPrograms {
    
    
public static void fnOpenArquive(String arg) {
        if (Desktop.isDesktopSupported()) {

            Desktop desktop = Desktop.getDesktop();
            try {
                
                File f = new File(arg);
                desktop.open(f);

            } catch (IOException ex) {
                System.err.println("ERROR::" + ex);
                //newXML.generateLog(ex.toString());
            }
        } else {
            System.err.println("Erro de compatibilidade.");
        }
}

public void fnOpenURL(URI uri) {
        if (Desktop.isDesktopSupported()) {

            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(uri);

            } catch (IOException ex) {
                System.err.println("ERROR::" + ex);
                //newXML.generateLog(ex.toString());
            }
        } else {
            System.err.println("Erro de compatibilidade.");
        }

    }

}
    


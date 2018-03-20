/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import static view.JFrameSale_1.jLabelDateandHour;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
public class Refresh extends Thread {

    protected final int flag = 20;
    private static int count = 0;
    private static final NewXML newXML = new NewXML();
    private static URI uri;
    protected final static boolean isDemo = false;
    
    private void fnOpenURL(URI uri) {
        
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

    @Override
    public void run() {

        try {

            for (int i = 1; i != 0; i++) {

                jLabelDateandHour.setText(DateActual.setDate(new Date(), "EEE dd/MM/yyyy HH:mm:ss"));
                sleep(1000);
                /*
                System.err.println("VALUE COUNT::" + count);
                count++;
                
                if ( count == flag ) {
                    System.err.println("BEAN DETAIAL SALE::" + BeanDetailSale.getCodeSale());
                    if (BeanDetailSale.getCodeSale() != null) {

                        if ( isDemo ) {
                            if (JOptionPane.showConfirmDialog(null, "Você esta usando uma vesão Demo, Deseja registrar seu Systema de frente de caixa (PDV)? ", "Mensagem", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                                
                                 try {
                                 uri = new URI("http://www.google.com.br/");
                                 fnOpenURL(uri);
                                 } catch (URISyntaxException ex) {
                                 System.err.println("ERROR::" + ex);
                                 //newXML.generateLog(ex.toString());
                                 }
                                 
                                new JDialogRegisterSoftware(null, true).setVisible(true);

                            } else {

                                System.exit(0);

                            }
                        } else {
                            System.exit(0);
                        }
                    } else {
                        count--;
                    }
                    
                }
                        */
            }

        } catch (InterruptedException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

    }
}

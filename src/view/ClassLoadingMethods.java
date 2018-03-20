/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class ClassLoadingMethods {

    
    private static final NewXML newXML = new NewXML();

    public static void invokeMethod(Method method, JDialog jd) {
        try {
            System.err.println("RETURN ON INVOKE::::" + method.invoke(jd, new Object[0])); // perceba que eu passo this !  
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.err.println("ERROR METHOD INVOKE::" + ex);
            ////newXML.generateLog(ex.toString());
            Logger.getLogger(ClassLoadingMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void loading(final Method method, final JDialog jd) {

        
        final Thread t1 = new Thread(new Runnable() {//cria uma thread pra gravar o seu arquivo

            @Override
            public void run() {

                try {
                    //AQUI VAI A FUNCÃO A SER EXECUTADA

                    invokeMethod(method, jd);

                } catch (IllegalArgumentException ex) {
                    System.err.println("ERROR CLASS LOADING:::" + ex);
                    ////newXML.generateLog(ex.toString());
                } catch (Exception ex) {
                   //System.err.println("ERROR CLASS LOADING:::" + ex);
                    //newXML.generateLog(ex.toString());

                }
            }
        });
        t1.start();
        new Thread(new Runnable() {//cria outra thread pra sua tela de espera

            @Override
            public void run() {
                //cria a tela de espera e mostra ela
                JDialogLoading jd = new JDialogLoading(null, false);
                jd.setVisible(true);

                try {
                    t1.join();//fica esperando a primeira thread acabar
                } catch (InterruptedException ex) {
                    System.err.println("ERROR ON RUN CLASS LOADING METHODS::" + ex);
                    ////newXML.generateLog(ex.toString());
                }
                // quando acabar fecha a janela de espera, podes fazer outras coisas aqui
                jd.dispose();

            }
        }).start();

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import xml.NewXML;

/**
 *
 * @author Rafael Recalcatti
 */
public class Wait extends Thread {

    private static final NewXML newXML = new NewXML();

    @Override
    public void run() {

        try {

            for (int i = 0; i < 3; i++) {
                System.err.println("RODANDO...");
                sleep(1000);
            }
            System.err.println(">>>FIM<<<");
        } catch (InterruptedException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

    }

}

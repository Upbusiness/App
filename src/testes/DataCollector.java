/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

/**
 *
 * @author Rafael
 */
import xml.NewXML;

public class DataCollector implements Runnable {

    private volatile boolean rodando = true;
    private static final NewXML newXML = new NewXML();

    public synchronized void pause() throws InterruptedException {
        this.wait(1000);
    }

    public void run() {
        try {
            while (rodando) {
                pause();
                System.out.println("Rodando....");
            }
        } catch (InterruptedException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
            throw new RuntimeException("Leitor de dados interrompido!", ex);
        }
    }

    public synchronized void parar() {
        rodando = false;
        this.notifyAll();
    }

    public static void main(String a[]) throws Exception {
        DataCollector d = new DataCollector();
        d.run();
        d.pause();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.net.MalformedURLException;
import java.io.File;
import java.applet.*;
import xml.NewXML;

/**
 *
 * @author Rafiusk
 */
        //sons
public class Sons {

    private static AudioClip somClicou; //quando morre
    private static AudioClip somPassou; //quando passa de fase
    private static AudioClip somNovo;   //quando ganha vida
    private static AudioClip somFim;    //quando acaba o jogo
    private static AudioClip somDelete;
    private static AudioClip somErro;
    private static AudioClip somDuploClique;
    private static final NewXML newXML = new NewXML();

    public Sons() {

       //Arquivos de som
        try {
            somDelete = Applet.newAudioClip(new File("sounds/recycle.wav").toURL());
            somClicou = Applet.newAudioClip(new File("sounds/click2.wav").toURL());
            somPassou = Applet.newAudioClip(new File("sounds/notify.wav").toURL());
            somNovo = Applet.newAudioClip(new File("sounds/abrir.wav").toURL());
            somFim = Applet.newAudioClip(new File("sounds/som_caixa.wav").toURL());
            somErro = Applet.newAudioClip(new File("sounds/erro.wav").toURL());
            somDuploClique = Applet.newAudioClip(new File("sounds/duploClique.wav").toURL());
        } catch (MalformedURLException ex) {

            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
    }

    public void tocarClicou() {

        somClicou.play();
    }

    public void tocarPassou() {

        somPassou.play();
    }

    public void tocarNovo() {

        somNovo.play();
    }

    public void tocarFim() {

        somFim.play();
    }

    public void tocarDelete() {

        somDelete.play();
    }

    public void tocarErro() {

        somErro.play();
    }

    public void tocarDuploClique() {

        somDuploClique.play();
    }
}
/**
 * @param args the command line arguments
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import xml.NewXML;

/**
 *
 * @author Rafael
 */
public class Mascaras {

    private static final NewXML newXML = new NewXML();

    public static MaskFormatter maskDate() {
        MaskFormatter maskData = null;
        try {
            maskData = new MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');

        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskData;
    }

    public static MaskFormatter maskCel() {
        MaskFormatter maskData = null;
        try {
            maskData = new MaskFormatter("(##)#####-####");
            maskData.setPlaceholderCharacter('_');

        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskData;
    }

    public static MaskFormatter maskHour() {
        MaskFormatter maskFone = null;
        try {
            maskFone = new MaskFormatter("##:##");
            maskFone.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        return maskFone;
    }

    public static MaskFormatter maskFone() {
        MaskFormatter maskFone = null;
        try {
            maskFone = new MaskFormatter("(##)####-####");
            maskFone.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskFone;
    }

    public static MaskFormatter maskCPF() {
        MaskFormatter maskCPF = null;
        try {
            maskCPF = new MaskFormatter("###.###.###/##");
            maskCPF.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskCPF;
    }

    public static MaskFormatter maskCNPJ() {
        MaskFormatter maskCPF = null;
        try {
            maskCPF = new MaskFormatter("##.###.###/####-##");
            maskCPF.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskCPF;
    }

    public static MaskFormatter maskIE() {
        MaskFormatter maskCPF = null;
        try {
            maskCPF = new MaskFormatter("###/#######");
            maskCPF.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskCPF;
    }

    public static MaskFormatter maskNumber() {
        MaskFormatter maskFone = null;
        try {
            maskFone = new MaskFormatter("##########");
//maskFone.setPlaceholderCharacter('_');
        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }

        return maskFone;
    }

}

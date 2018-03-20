
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package action;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.JTable;

/**
 *
 * @author Rafiusk
 */
public class BeanTbl {
    private static JTable   tbl;
    private static String[] head;
    private static String   sql;
    private static String par;

    /**
     * @return the tbl
     */
    public static JTable getTbl() {
        return tbl;
    }

    /**
     * @param aTbl the tbl to set
     */
    public static void setTbl(JTable aTbl) {
        tbl = aTbl;
    }

    /**
     * @return the head
     */
    public static String[] getHead() {
        return head;
    }

    /**
     * @param aHead the head to set
     */
    public static void setHead(String[] aHead) {
        head = aHead;
    }

    /**
     * @return the sql
     */
    public static String getSql() {
        return sql;
    }

    /**
     * @param aSql the sql to set
     */
    public static void setSql(String aSql) {
        sql = aSql;
    }

    /**
     * @return the par
     */
    public static String getPar() {
        return par;
    }

    /**
     * @param aPar the par to set
     */
    public static void setPar(String aPar) {
        par = aPar;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

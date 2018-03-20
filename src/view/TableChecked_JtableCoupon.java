package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import util.Moeda;
import xml.NewXML;

class MyModelJtableCoupon extends AbstractTableModel {

    String[] colNames = {"", "CÓDIGO", "DATA/HORA", "CANCELADO", "FECHADO", "TERMINAL", "TOTAL"};
    ;
        PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableCoupon(boolean selected, String arg) {

        try {

            String SQL = ("SELECT t.`idtbl_coupon`,DATE_FORMAT(t.`date_hour_coupon`,'%d/%m/%Y %H:%i:%s' ) AS date_hour,t.`isCanceled`,t.`isClosed`,  t.`terminal_coupon`, (t.`total_coupon` - t.`discount_coupon`) AS total_coupon FROM tbl_coupon t  WHERE date_hour_coupon >=(SELECT hour_opening_cashier FROM tbl_cashier WHERE idtbl_terminal = ? AND isClosed = 0) AND date_hour_coupon <= CURRENT_TIMESTAMP() AND t.`terminal_coupon` = ?  ORDER BY t.`date_hour_coupon` DESC;");
            ps = Conn.connect().prepareStatement(SQL);
            ps.setString(1, arg);
            ps.setString(2, arg);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = selected;
                data[i][1] = rs.getString("idtbl_coupon");
                data[i][2] = rs.getString("date_hour");
                if (rs.getBoolean("isCanceled")) {
                    data[i][3] = ("SIM");
                } else {
                    data[i][3] = ("NÃO");
                }
                if (rs.getBoolean("isClosed")) {
                    data[i][4] = ("SIM");
                } else {
                    data[i][4] = ("NÃO");
                }
                data[i][5] = rs.getString("terminal_coupon");
                data[i][6] = Moeda.mascaraDinheiro(rs.getDouble("total_coupon"), Moeda.DINHEIRO_REAL);
                i++;
            }
        } catch (SQLException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
    }

    @Override
    public String getColumnName(int param) {
        return colNames[param];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 0;
    }

    @Override
    public Class getColumnClass(int column) {
        Class klass = String.class;

        if (column == 0) {
            klass = Boolean.class;
        }

        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            data[row][col] = (Boolean) value;
        }
    }
}

public class TableChecked_JtableCoupon {
}





//~ Formatted by Jindent --- http://www.jindent.com

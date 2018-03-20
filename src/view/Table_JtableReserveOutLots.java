package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableReserveOUTLots extends AbstractTableModel {

    String[] colNames = {"LOTE", "DATA VALID.", "DATA REG.", "EM USO", "FECHADO", "QTD LANÇ.", "QTD USADA", "SALDO"};
    DecimalFormat v2 = new DecimalFormat("0.000");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableReserveOUTLots(String arg) {

        try {

            ps = Conn.connect().prepareStatement("SELECT "
                    + " t.`inv_lot`,"
                    + " t.`inv_inUse`,"
                    + " t.`inv_isClosed`,"
                    + " t.`inv_value_used`,"
                    + " t.`inv_date_expiring`,"
                    + " t.`inv_date_register`,"
                    + " t.`inv_quantity_insert` FROM tbl_reserve_in t WHERE t.`prod_bar_code_product` = ?;");

            ps.setString(1, arg);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("inv_lot");
                data[i][1] = rs.getString("inv_date_expiring");
                data[i][2] = rs.getString("inv_date_register");
                if (rs.getBoolean("inv_inUse")) {
                    data[i][3] = "SIM";
                } else {
                    data[i][3] = "NÃO";
                }
                if (rs.getBoolean("inv_isClosed")) {
                    data[i][4] = "SIM";
                } else {
                    data[i][4] = "NÃO";
                }
                data[i][5] = v2.format(rs.getDouble("inv_quantity_insert")).replaceAll(",", ".");
                data[i][6] = v2.format(rs.getDouble("inv_value_used")).replaceAll(",", ".");
                data[i][7] = v2.format(rs.getDouble("inv_quantity_insert") - rs.getDouble("inv_value_used")).replaceAll(",", ".");

                i++;
            }
        } catch (SQLException ex) {
            //newXML.generateLog(ex.toString());
            System.err.println("ERROR::" + ex);

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

        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            data[row][col] = value;
        }
    }
}

public class Table_JtableReserveOutLots {
}

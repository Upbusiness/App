package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import util.FormatDate;
import xml.NewXML;

class MyModelJtableReserveOUT extends AbstractTableModel {

    String[] colNames = {"CÓDIGO", "DATA LANÇAMENTO", "LOTE", "DESCRIÇÃO", "QTD LANÇADA"};
    DecimalFormat v2 = new DecimalFormat("0.000");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableReserveOUT(String arg) {

        try {

            ps = Conn.connect().prepareStatement("SELECT t.`idtbl_reserve_out`,"
                    + " t.`data_register_output`,"
                    + " t.`lot_product_output`,"
                    + " t.`description_output`,"
                    + " t.`quantity_output`"
                    + "  FROM tbl_reserve_out t WHERE t.`prod_bar_code_product` = ? ;");

            ps.setString(1, arg);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_reserve_out");
                data[i][1] = FormatDate.formatDateSQL(rs.getString("data_register_output"));
                data[i][2] = rs.getString("lot_product_output");
                data[i][3] = rs.getString("description_output");
                data[i][4] = v2.format(rs.getDouble("quantity_output")).replaceAll(",", ".");

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

        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            data[row][col] = value;
        }
    }
}

public class Table_JtableReserveOut {
}

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

class MyModelJtableReserveIN extends AbstractTableModel {

    String[] colNames = {"CÓDIGO", "DESCRIÇÃO", "CUSTO R$", "QTD LANÇADA", "QTD USADA", "DATA LANÇ.", "DATA VENC.", "LOTE",
        "EM USO", "FECHADO"};
    ;
        PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    DecimalFormat v = new DecimalFormat("0.00");
    DecimalFormat v2 = new DecimalFormat("0.000");
    private static final NewXML newXML = new NewXML();

    public MyModelJtableReserveIN(String arg) {

        try {

            ps = Conn.connect().prepareStatement("SELECT t.`idtbl_reserve_in`,"
                    + " t.`prod_bar_code_product`,"
                    + " t.`inv_date_register`,"
                    + " t.`inv_quantity_insert`,"
                    + " t.`inv_remainder_reserve`,"
                    + " t.`inv_value_cost`,"
                    + " t.`inv_lot`,"
                    + " t.`inv_date_production`,"
                    + " t.`inv_date_expiring`,"
                    + " t.`inv_month_for_expiring`,"
                    + " p.`prod_description_product`,"
                    + " t.`inv_value_used`,"
                    + " t.`inv_inUse`,"
                    + " p.`idtbl_unity_measure`,"
                    + " t.`inv_isClosed`"
                    + " FROM tbl_reserve_in t INNER JOIN tbl_product p ON t.`prod_bar_code_product` = p.`prod_bar_code_product` WHERE t.`prod_bar_code_product` = ? ORDER BY t.`inv_date_expiring`;");

            ps.setString(1, arg);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_reserve_in");
                data[i][1] = rs.getString("prod_description_product");
                data[i][2] = "R$ " + v.format(rs.getDouble("inv_value_cost"));
                data[i][3] = v2.format(rs.getDouble("inv_quantity_insert")).replaceAll(",", ".") + " " + rs.getString("idtbl_unity_measure");
                data[i][4] = v2.format(rs.getDouble("inv_value_used")).replaceAll(",", ".") + " " + rs.getString("idtbl_unity_measure");
                data[i][5] = FormatDate.formatDateSQL(rs.getString("inv_date_register"));
                data[i][6] = FormatDate.formatDateSQL(rs.getString("inv_date_expiring"));
                data[i][7] = rs.getString("inv_lot");
                if (rs.getBoolean("inv_inUse")) {
                    data[i][8] = ("SIM");
                } else {
                    data[i][8] = ("NÃO");
                }
                if (rs.getBoolean("inv_isClosed")) {
                    data[i][9] = ("SIM");
                } else {
                    data[i][9] = ("NÃO");
                }
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

public class Table_JtableReserveIn {
}

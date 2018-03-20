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

class MyModelJtableDetaialSale extends AbstractTableModel {

    String[] colNames = {"ITEM", "CÓDIGO", "DESCRIÇÃO", "QTD", "UN", "VLR UN", "VLR TOTAL","CANCELADO"};
   
        PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    DecimalFormat v = new DecimalFormat("0.00");
    DecimalFormat v2 = new DecimalFormat("0.000");
    private static final NewXML newXML = new NewXML();

    public MyModelJtableDetaialSale(String arg) {

        try {

            String sql = "SELECT"
                    + " p.`prod_bar_code_product`,"
                    + " p.`idtbl_unity_measure`,"
                    + " p.`prod_abbreviature`,"
                    + " pc.`product_cost`,"
                    + " pc.`product_price`,"
                    + " SUM(pc.`product_price` * pc.`product_quantity`) AS total_sale,"
                    + " CASE WHEN pc.`isToCancel` THEN pc.`product_quantity` * -1 ELSE pc.`product_quantity` END AS product_quantity,"
                    + " pc.`isToCancel`,"
                    + " pc.`number_iten` FROM tbl_coupon c INNER JOIN tbl_product_coupon pc ON c.`idtbl_coupon` = pc.`idtbl_coupon` INNER JOIN tbl_product p ON pc.`prod_bar_code_product` = p.`prod_bar_code_product` WHERE c.`idtbl_coupon` = ? GROUP BY pc.`idtbl_product_coupon` ORDER BY pc.`number_iten`;";

            ps = Conn.connect().prepareStatement(sql);
            System.err.println("SQL MYMODEL:::" + sql);
            ps.setString(1, arg);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("number_iten");
                data[i][1] = rs.getString("prod_bar_code_product");
                data[i][2] = rs.getString("prod_abbreviature");
                data[i][3] = v2.format(rs.getDouble("product_quantity"));
                data[i][4] = rs.getString("idtbl_unity_measure");
                data[i][5] = "R$" + v.format(rs.getDouble("product_price"));
                data[i][6] = "R$" + v.format(rs.getDouble("total_sale"));
                data[i][7] = (rs.getBoolean("isToCancel") ? "SIM" : "NÃO");
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

public class Table_JtableDetaialSale {
}

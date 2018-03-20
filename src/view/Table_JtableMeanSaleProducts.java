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

class MyModelJtableMeanSaleProducts extends AbstractTableModel {

    String[] colNames = {"MÊS/ANO", "VENDAS UN", "QTD VENDAS"};
    ;
        PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableMeanSaleProducts(String arg) {

        try {

            ps = Conn.connect().prepareStatement("SELECT  SUM(pc.`product_quantity`) AS sum_qtd, p.`idtbl_unity_measure` AS un_measure, SUM(pc.`quantity_iten`) AS sum_sales, DATE_FORMAT(c.`date_hour_coupon`,'%m/%Y') AS mouth_year  FROM tbl_product_coupon pc INNER JOIN tbl_coupon c ON pc.`idtbl_coupon` = c.`idtbl_coupon` JOIN tbl_product p ON pc.`prod_bar_code_product` = p.`prod_bar_code_product`  WHERE pc.`prod_bar_code_product` = ?  GROUP BY DATE_FORMAT(c.`date_hour_coupon`,'%M/%Y') ORDER BY c.`date_hour_coupon` DESC;");
            ps.setString(1, arg);

            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;
            DecimalFormat v;

            while (rs.next()) {

                if (rs.getString("un_measure").equals("UN")) {
                    v = new DecimalFormat("0");
                } else {
                    v = new DecimalFormat("0.000");
                }
                data[i][0] = rs.getString("mouth_year");
                data[i][1] = v.format(rs.getDouble("sum_qtd")) + " " + rs.getString("un_measure");
                data[i][2] = rs.getString("sum_sales");

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
        return col == 10;
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

public class Table_JtableMeanSaleProducts {
}

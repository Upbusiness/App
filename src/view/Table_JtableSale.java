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

class MyModelJtableSale extends AbstractTableModel {

    String[] colNames ={"Item", "Descrição", "UN", "Qtd", "Preço R$", "Total R$"};
  
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();
    private static final DecimalFormat v = new DecimalFormat("0.00");

    public  MyModelJtableSale(String arg) {

        try {

            String sql = "SELECT t.`number_iten`, p.`prod_description_product`, p.`idtbl_unity_measure`, t.`product_quantity`,t.`product_price`, ROUND((t.`product_quantity` * t.`product_price`),2) AS valor_total FROM tbl_product_coupon t INNER JOIN tbl_product p ON t.prod_bar_code_product = p.prod_bar_code_product WHERE t.`idtbl_coupon` = ? AND t.`product_quantity` > 0 AND t.`isToCancel` = 0 ORDER BY t.`number_iten`;";
            ps = Conn.connect().prepareStatement(sql);            
            ps.setString(1, arg);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;
            
            while (rs.next()) {

                data[i][0] = rs.getString("number_iten");
                data[i][1] = rs.getString("prod_description_product");
                data[i][2] = rs.getString("idtbl_unity_measure");
                data[i][3] = rs.getString("product_quantity");
                data[i][4] = v.format(rs.getDouble("product_price"));
                data[i][5] = v.format(rs.getDouble("valor_total"));
                i++;
            }
            
        } catch (SQLException | java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException ex) {
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

public class Table_JtableSale {
    
}

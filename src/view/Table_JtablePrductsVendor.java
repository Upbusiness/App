package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableProductsVendor extends AbstractTableModel {

    String[] colNames = {"","CÓDIGO BARRA",
        "DESCRIÇÃO", 
        "VALOR VENDA",
        "VL. MÉDIO COMPRA",
        "ESTOQUE ATUAL",
        "ESTOQUE MIN.",
        "ABAIXO MIN."};
    
        PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableProductsVendor(String arg) {

        try {
            String SQL = "SELECT t.`prod_bar_code_product`,t.`prod_description_product`, t.`prod_price_sale_actual_product`, t.`prod_price_mean_purchase_product`, t.`prod_reserve_actual_product`, t.`prod_reserve_minimum_product`,CASE WHEN (t.`prod_reserve_actual_product` <= t.`prod_reserve_minimum_product`) THEN 'SIM' WHEN (t.`prod_reserve_actual_product` > t.`prod_reserve_minimum_product`) THEN 'NÃO' END AS 'isDownMin' FROM tbl_product t INNER JOIN tbl_product_vendor pv ON  t.`prod_bar_code_product` =  pv.`prod_bar_code_product` WHERE  pv.`idtbl_vendor` = '"+arg+"';";
           
            System.err.println("SQL:::" + SQL);
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);
            int i = 0;

            while (rs.next()) {
                
                data[i][0] = false;
                data[i][1] = rs.getString("prod_bar_code_product");
                data[i][2] = rs.getString("prod_description_product");
                data[i][3] = rs.getDouble("prod_price_sale_actual_product");
                data[i][4] = rs.getDouble("prod_price_mean_purchase_product");
                data[i][5] = rs.getDouble("prod_reserve_actual_product");
                data[i][6] = rs.getDouble("prod_reserve_minimum_product");
                data[i][7] = rs.getString("isDownMin");

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
            data[row][col] = value;
        }
    }
}

public class Table_JtablePrductsVendor {
}





//~ Formatted by Jindent --- http://www.jindent.com

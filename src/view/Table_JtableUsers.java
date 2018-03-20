package view;

//~--- non-JDK imports --------------------------------------------------------
import action.AccountClient;
import action.Bean;
import action.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableUser extends AbstractTableModel {

    String[] colNames = {"USUÁRIO","ACESSO VENDA","ACESSO RESTRITO","ACESSO PRODUTO","ACESSO CAIXA",};
    DecimalFormat v = new DecimalFormat("0.00");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableUser() {

        try {
                        
            String sql = "SELECT t.`idtbl_user`,"
                    + " t.`isSaleAccess`,"
                    + " t.`isAccessRestrict`,"
                    + " t.`isRegisterProductsAccess`,"
                    + " t.`isCashierAccess` FROM tbl_user t;";
                        
            stmt = Conn.connect().createStatement();                      
            rs = stmt.executeQuery(sql);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(sql);
            int i = 0;

            while (rs.next()) {
                
                data[i][0] = rs.getString("idtbl_user");
                data[i][1] = (rs.getString("isSaleAccess").equals("1") ? "SIM" : "NÃO");
                data[i][2] = (rs.getString("isAccessRestrict").equals("1") ? "SIM" : "NÃO");
                data[i][3] = (rs.getString("isRegisterProductsAccess").equals("1") ? "SIM" : "NÃO");
                data[i][4] = (rs.getString("isCashierAccess").equals("1") ? "SIM" : "NÃO");                                   
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
        
        return (Arrays.toString(data).replace("[", "").replace("]", "").isEmpty() ? 0 : data[0].length);
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
            data[row][col] = (Boolean) value;
        }
    }
}

public class Table_JtableUsers {
    
}

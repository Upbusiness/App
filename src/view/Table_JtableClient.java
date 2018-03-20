package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableClient extends AbstractTableModel {

    String[] colNames = {"CPF","NOME"};
    DecimalFormat v = new DecimalFormat("0.00");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableClient() {

        try {

            String sql = "SELECT `cpf_client`, `name_client` FROM tbl_client;";
            stmt = Conn.connect().createStatement();            
            rs = stmt.executeQuery(sql);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(sql);
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("cpf_client");
                data[i][1] = rs.getString("name_client");           
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

public class Table_JtableClient {
}

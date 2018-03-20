package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableCategoryCostOperate extends AbstractTableModel {

    String[] colNames = {"Cod.", "Descrição"};;  
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableCategoryCostOperate() {

        try {

            String sql = "SELECT t.`idtbl_type_cost_operate`, t.`description_type_cost_operate` FROM tbl_type_cost_operate t ORDER BY t.`description_type_cost_operate`;";
            stmt = Conn.connect().createStatement();            
            rs = stmt.executeQuery(sql);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(sql);
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_type_cost_operate");
                data[i][1] = rs.getString("description_type_cost_operate");            
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

public class Table_JtableCategoryCostOperate {
}

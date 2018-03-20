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

class MyModelJtableCostOperate extends AbstractTableModel {

    String[] colNames = {"Cod.", "Data", "Descrição", "Valor", "Núm. Doc."};
    DecimalFormat v = new DecimalFormat("0.00");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableCostOperate() {

        try {

            String sql = "SELECT t.`idtbl_cost_operate`, DATE_FORMAT(t.`date_cost`, '%d/%m/%Y') AS date_cost, tc.`description_type_cost_operate`, t.`value_cost`, t.`number_document` FROM tbl_cost_operate t INNER JOIN tbl_type_cost_operate tc ON t.`idtbl_type_cost_operate` = tc.`idtbl_type_cost_operate` ORDER BY  t.`date_cost` DESC;";
            stmt = Conn.connect().createStatement();            
            rs = stmt.executeQuery(sql);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(sql);
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_cost_operate");
                data[i][1] = rs.getString("date_cost");
                data[i][2] = rs.getString("description_type_cost_operate");
                data[i][3] = "R$ "+v.format(rs.getDouble("value_cost"));
                data[i][4] = rs.getString("number_document");             
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

public class Table_JtableCostOperate {
}

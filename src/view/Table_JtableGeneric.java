package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableGeneric extends AbstractTableModel {

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();
    private static final DecimalFormat v = new DecimalFormat("0.00");
    private static String[] colNames;
    private static ResultSetMetaData rsmd;
    private boolean isChecked;

    public MyModelJtableGeneric(String sql, String[] heads, List<Object> arg, boolean isChecked) {

        try {

            colNames = heads;
            this.isChecked = isChecked;

            if (arg.isEmpty() || arg == null) {

                System.err.println("Caiu no IF");
                stmt = Conn.connect().createStatement();
                rs = stmt.executeQuery(sql);

            } else {

                System.err.println("Caiu no ELSE");
                ps = Conn.connect().prepareStatement(sql);
                for (int i = 0; i < arg.size(); i++) {

                    System.err.println("SETED:::" + arg.get(i));
                    ps.setObject(i + 1, arg.get(i));

                }
                rs = ps.executeQuery();
            }

            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ((arg.isEmpty() || arg.toString() == null) ? (stmt.executeQuery(sql)) : (ps.executeQuery()));
            rsmd = rs.getMetaData();

            int i = 0;

            while (rs.next()) {

                for (int y = 0; y < colNames.length; y++) {

                    data[i][y] = (rsmd.getColumnType(y + 1) == Types.BIGINT ? (rs.getBoolean(y + 1)) : rsmd.getColumnType(y + 1) == Types.DOUBLE ? (v.format(rs.getDouble(y + 1))) : (rs.getObject(y + 1)));

                }

                i++;
            }

        } catch (SQLException | java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());

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
        
        return  data[0].length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        if (isChecked) {
            return col == 0;
        } else {
            return col == 30;
        }
    }

    @Override
    public Class getColumnClass(int column) {
        Class klass = String.class;

        if (isChecked) {

            if (column == 0) {
                klass = Boolean.class;
            }
        }
        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {

            data[row][col] = ((isChecked) ? (Boolean) value : value);
        }
    }
}

public class Table_JtableGeneric {

}

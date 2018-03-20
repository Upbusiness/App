package view;

//~--- non-JDK imports --------------------------------------------------------
import model.Conn;

//~--- JDK imports ------------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;
import xml.NewXML;

class MyModelUnity extends AbstractTableModel {

    String[] colNames = {"UN", "VALOR"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelUnity() {
        String SQL = "SELECT idtbl_unity_measure, unity_measure FROM tbl_unity_measure;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);

            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_unity_measure");
                data[i][1] = rs.getString("unity_measure");

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
            klass = String.class;
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

public class TableModel_UnityMeasure {
}



//~ Formatted by Jindent --- http://www.jindent.com

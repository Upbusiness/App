/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafiusk
 */
public final class FillTableUnityMeasure extends AbstractTableModel{

    private int rownum;

    private static final String[] colNames = {"Sigla","Unidade"};
    private ArrayList<String[]> ResultSets;
    private ResultSetMetaData metaData;

  

    public FillTableUnityMeasure(ResultSet results) throws Exception {
       setResult(results);
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        String[] row = ResultSets.get(rowIndex);

        return row[columnIndex];

    }
    @Override
public String getColumnName(int param){

    return colNames[param];
}

public void setResult(ResultSet rs)throws SQLException{

    ResultSets=new ArrayList<String[]>();

    while(rs.next()){

        String[] row={

            rs.getString("idtbl_unity_measure"),
            rs.getString("unity_measure")
            

        };
        ResultSets.add(row);
        }
    fireTableStructureChanged();
    }
    public void deleteRow(int row){

        ResultSets.remove(row);
        fireTableRowsDeleted(row, row);
}
}

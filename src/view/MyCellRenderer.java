package view;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

class MyCellRenderer extends DefaultTableCellRenderer {
    private Color whiteColor     = Color.white;                 // new Color(254, 254, 254);
    private Color alternateColor = new Color(204, 204, 255);    // Color.lightGray;//new Color(204, 204, 204);
    private Color selectedColor  = Color.yellow;

    public MyCellRenderer() {}

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        Color bg;

        if (!selected) {
            bg = ((row % 2 == 0)
                  ? alternateColor
                  : whiteColor);
        } else {
            bg = selectedColor;
        }
/*
        if (NewJFrame.jTableItensPedido.getRowCount() > 0) {
            NewJFrame.jTableItensPedido.getColumnModel().getColumn(0).setPreferredWidth(50);    // define a largura da coluna
            NewJFrame.jTableItensPedido.getColumnModel().getColumn(1).setPreferredWidth(50);
            NewJFrame.jTableItensPedido.getColumnModel().getColumn(2).setPreferredWidth(150);
            NewJFrame.jTableItensPedido.getColumnModel().getColumn(3).setPreferredWidth(400);
        }

        if (NewJFrame.jTablePedidosFilaPreparo.getRowCount() >= 1) {
            NewJFrame.jTablePedidosFilaPreparo.getColumnModel().getColumn(0).setPreferredWidth(115);    // define a largura da coluna
            NewJFrame.jTablePedidosFilaPreparo.getColumnModel().getColumn(1).setPreferredWidth(250);
            NewJFrame.jTablePedidosFilaPreparo.getColumnModel().getColumn(2).setPreferredWidth(85);
        }

        if (NewJFrame.jTableClientes.getRowCount() >= 1) {
            NewJFrame.jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(60);    // define a largura da coluna
            NewJFrame.jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(230);
            NewJFrame.jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(249);
        }
*/
        setBackground(bg);
        setForeground(selected
                      ? Color.black
                      : new java.awt.Color(102, 102, 102));
        setHorizontalAlignment(SwingConstants.CENTER);

        /*
         *  if (value instanceof ImageIcon) {
         * setIcon((ImageIcon) value);
         * setText("");
         * } else
         * setIcon(null);
         */
        return this;
    }

    /**
     * @return the outer
     */
}


//~ Formatted by Jindent --- http://www.jindent.com

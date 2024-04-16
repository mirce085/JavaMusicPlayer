import javax.swing.*;
import java.awt.*;

/**
 * CustomCellRenderer class provides a custom cell renderer for a JList.
 */
public class CustomCellRenderer extends DefaultListCellRenderer
{
    /**
     * Returns a component that implements the rendering of cells in a JList.
     *
     * @param list the JList being rendered
     * @param value the value to assign to the cell being rendered
     * @param index the index of the cell being rendered
     * @param isSelected true if the specified cell is currently selected
     * @param cellHasFocus true if the cell has focus
     * @return a component for rendering the cell
     */
    public Component getListCellRendererComponent(JList<?> list,
                                                  Object value,
                                                  int index,
                                                  boolean isSelected,
                                                  boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Song) {
            Song ingredient = (Song)value;
            setText(ingredient.GetTitle());
        }
        return this;
    }
}

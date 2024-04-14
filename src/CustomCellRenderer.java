import javax.swing.*;
import java.awt.*;

public class CustomCellRenderer extends DefaultListCellRenderer
{
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

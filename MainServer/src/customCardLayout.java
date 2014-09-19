
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

public class customCardLayout extends CardLayout {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Dimension preferredLayoutSize(Container parent) {

        Component current = findCurrentComponent(parent);
        if (current != null) {
            Insets insets = parent.getInsets();
            Dimension pref = current.getPreferredSize();
            pref.width += insets.left-5 + insets.right-5;
            pref.height += insets.top-5 + insets.bottom;
            return pref;
        }
        return super.preferredLayoutSize(parent);
    }

    public Component findCurrentComponent(Container parent) {
        for (Component comp : parent.getComponents()) {
            if (comp.isVisible()) {
                return comp;
            }
        }
        return null;
    }

}
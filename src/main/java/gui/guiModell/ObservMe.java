package gui.guiModell;

import javax.swing.event.ChangeListener;
import java.beans.PropertyChangeListener;

public interface ObservMe {
    void addListener(PropertyChangeListener changeListener);
    void removeListener(PropertyChangeListener changeListener);
}

// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * An extension of JToolBar that has a built in ButtonGroup 
 * and methods for creating a new Button or ToggleButton.
 * @author Joshua Moore
 * @version 11/9/13
 *
 */
@SuppressWarnings("serial")
public class ToolBar extends JToolBar {
    
    /**
     * A grouped set of buttons that is part of the tool bar.
     */
    private ButtonGroup myToolGroup;
    
    /**
     * Calls the parent constructor and then initializes the ButtonGroup.
     */
    public ToolBar() {
        super();
        myToolGroup = new ButtonGroup();
    }
    
    /**
     * Creates a ToggleButton that's added to a group and the ToolBar.
     * @param theName The Name of the Button.
     * @param theAction The Action that is attached to the button.
     * @throw If theName is null.
     */
    public void addToggleButton(final String theName, final Action theAction) {
        if (theName == null) {
            throw new IllegalArgumentException("addToggleButton passed a null String Name!");
        }
        
        final JToggleButton button = new JToggleButton(theName);
       
        button.setAction(theAction);
        myToolGroup.add(button);
        add(button);
    }
    
    
    /**
     * Creates a Button that's added to a group and the ToolBar.
     * @param theName The Name of the Button.
     * @param theAction The Action that is attached to the button.
     * @throw If theName is null.
     */
    public void addButton(final String theName, final Action theAction) {
        if (theName == null) {
            throw new IllegalArgumentException("addButton passed a null !");
        }
        
        final JButton button = new JButton(theName);
        button.setAction(theAction);
        add(button);
    }
    
    /**
     * Creates a Button that's added to a group and the ToolBar.
     * @param theName The Name of the Button.
     * @param theAction The Action that is attached to the button.
     * @param theBackground The background color of the button.
     * @throw If theName is null.
     */
    public void addButton(final String theName, final Action theAction,
                             final Color theBackground) {
        if (theName == null) {
            throw new IllegalArgumentException("addButton passed a null String Name!");
        }
        
        final JButton button = new JButton(theName);
        button.setAction(theAction);
        button.setBackground(ColorAction.getColor());
        add(button);
    }
}

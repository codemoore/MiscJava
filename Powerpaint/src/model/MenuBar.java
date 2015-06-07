// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * An extension of JMenu that has a built in ButtonGroup 
 * and methods for creating a new Menu, MenuItem, RadioItems, and CheckItems.
 * 
 * Pretty sure there's some redundancy in here.
 * 
 *  @author Joshua Moore
 *  @version 11/14/13
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
    
    
    /**
     * Creates a new JMenuBar with an Array of Main Menu Buttons from theMenuNames.
     */
    public MenuBar() {
        super();
    }
    
    /**
     * Makes a new JMenu.
     * @param theName the name of the JMenu.
     * @param theCode the KeyEvent mnemonic associated with the Menu.
     * @return the created JMenu.
     */
    public JMenu createMenu(final String theName, final int theCode) {
        final JMenu menu = new JMenu(theName);
        menu.setMnemonic(theCode);
        return menu;
    }
    
    /**
     * Creates and returns a new JMenuItem.
     * @param theName the name of the item.
     * @param theAction the action listener for the object.
     * @return the created JMenuItem.
     */
    public JMenuItem createMenuItem(final String theName, final Action theAction) {
        final JMenuItem item = new JMenuItem(theName);
        item.setAction(theAction);
        return item;
    }
    
    /**
     * Creates and returns a new JMenuItem.
     * @param theName the name of the item.
     * @param theAction the action listener for the object.
     * @param theCode the KeyEvent mnemonic associated with the Menu.
     * @return the created JMenuItem.
     */
    public JMenuItem createMenuItem(final String theName, final int theCode,
                                    final ActionListener theAction) {
        final JMenuItem item = new JMenuItem(theName);
        item.setMnemonic(theCode);
        item.addActionListener(theAction);
        return item;
    }
    
    /**
     * Creates and returns a radio item.
     * @param theName the name of the item.
     * @param theAction the Action attached to it.
     * @return the JRadioButtonMenuItem that was made.
     */
    public JRadioButtonMenuItem createRadioItem(final String theName, 
                                                 final Action theAction) {
        final JRadioButtonMenuItem radio = new JRadioButtonMenuItem(theName);
        radio.setAction(theAction);
        return radio;
    }
    
    /**
     * Makes a radio item.
     * @param theName theName of the RadioItem.
     * @return the create radio item.
     */
    public JRadioButtonMenuItem createRadioItem(final String theName) {
        final JRadioButtonMenuItem radio = new JRadioButtonMenuItem(theName);
        return radio;
    }
    
    /**
     * Makes a check box.
     * @param theName the Name of the CheckBox
     * @param theAction the ActionListener attached to it.
     * @param theCode the Mnemonic key code for the item.
     * @return the create checkBox.
     */
    public JCheckBoxMenuItem createCheckItem(final String theName, final int theCode,
                                              final ActionListener theAction) {
        final JCheckBoxMenuItem check = new JCheckBoxMenuItem(theName);
        check.addActionListener(theAction);
        check.setMnemonic(theCode);
        return check;
    }
    
    /**
     * Creates a JMenuItem.
     * @param theName the Name of the Item
     * @param theAction the Action attached to the item.
     * @param theColor the color of the Background.
     * @return a JMenu Item.
     */
    public JMenuItem createMenuItem(final String theName, final Action theAction,
                                    final Color theColor) {
        final JMenuItem item = new JMenuItem(theName);
        item.setAction(theAction);
        item.setBackground(ColorAction.getColor());
        return item;
    }
    
}

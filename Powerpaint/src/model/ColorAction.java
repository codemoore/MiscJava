// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;

import javax.swing.JColorChooser;

/**
 * Performs an action when the Color tool is being used.
 * @author Joshua Moore
 * @version 11/13/13
 *
 */
@SuppressWarnings("serial")
public final class ColorAction extends AbstractPaintAction {
    
    /**
     * The Color the tools start as by default.
     */
    private static final Color DEFAULT_COLOR = Color.BLACK;
    
    /**
     * Stores a Color and allows a uses to choose a new Color.
     */
    private static final JColorChooser CHOOSER = new JColorChooser();
    
    /**
     * Creates a new Color Action.
     * @param theName the Name of the Action.
     * @param theCode the KeyEvent code for the mnemonic.
     */
    public ColorAction(final String theName, final int theCode) {
        super(theName, theCode);
        //putValue(Action.SMALL_ICON, theName);
        CHOOSER.setColor(DEFAULT_COLOR);
        
    }
    
    /**
     * Shows the color chooser and gets the new color.
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color newColor = JColorChooser.showDialog(CHOOSER, "Color...",
                                                        CHOOSER.getColor());
        if (newColor != null) {
            CHOOSER.setColor(newColor);
        }       
        final Component source = (Component) theEvent.getSource();
        source.setBackground(newColor);
        firePropertyChange("ColorChange", null, CHOOSER.getColor());
    }
    
    /**
     * Gets the current color.
     * Method is static for easy access, because CHOOSER, the color chooser is also static,
     * and Color is immutable so there are no encapsulation issues. 
     * @return The current color being used.
     */
    public static Color getColor() {
        return CHOOSER.getColor();
    }
    
    /**
     * DO NOT USE. Doesn't actually do anything for ColorAction, just returns null.
     * {@inheritDoc}
     */
    @Override
    public Shape createGraphics(final Point theP1, final Point theP2) {
        return null;
    }
    


}

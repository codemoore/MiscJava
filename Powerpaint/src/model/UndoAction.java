// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint


package model;

import java.awt.Component;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;

/**
 * Fires a property change that prompts an undo.
 * @author Joshua Moore
 * @version 11/14/13
 *
 */
@SuppressWarnings("serial")
public class UndoAction extends AbstractPaintAction {
    
    /**
     * Creates a new Undo Action.
     * @param theName the Name of the Action.
     * @param theCode the KeyEvent code for the mnemonic.
     */
    public UndoAction(final String theName, final int theCode) {
        super(theName, theCode);
    }
    
    /**
     * Fires a changes that tell the listener to undo.
     * {@inheritDoc}}
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        firePropertyChange("Undo", null, (Component) theEvent.getSource());     
    }
    
    
    /**
     * Does nothing in this class.
     * {@inheritDoc}}
     */
    @Override
    public Shape createGraphics(final Point theP1, final Point theP2) {
        return null;
    }

}

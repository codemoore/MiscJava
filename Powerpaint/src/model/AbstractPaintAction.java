// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Abstract Class that contains basic data and functionality of a tool in PowerPaint.
 * 
 * @author Joshua Moore
 * @version 11/4/13
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractPaintAction extends AbstractAction {
        
    /**
     * The Name of this Action.
     */
    private final String myName;
    
    /**
     * The Key Code for the mnemonic.
     */
    private int myCode;

    /**
     * Makes a new PaintAction obj with a name, Mnemonic, and a stored Drawing panel. 
     * @param theName the name of the Action.
     * @param theCode the VK code for the mnemonic.
     * @param thePanel
     */
    public AbstractPaintAction(final String theName, final int theCode) {
        super(theName);
        myCode = theCode;
        putValue(Action.MNEMONIC_KEY, myCode);
        myName = theName;
        putValue(Action.SELECTED_KEY, myName);
        
    }
        
    /**
     * Fires a property change giving a listener a reference to itself.
     * {@inheritDoc} 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        firePropertyChange("Tool", null, this);     
    }

    
    /**
     * Creates and returns a shape.
     * @param theP1 the first point the shape will be made of.
     * @param theP2 the last point the shape will be made of.
     * @return the shape made with these points.
     */
    public abstract Shape createGraphics(final Point theP1,  final Point theP2);
    

    /**
     * Returns the name of the Action.
     * @return the Action's name.
     */
    public String getName() {
        return myName;
    }
    
    /**
     * Gets the KeyEvent code for the mnemonic. 
     * @return the Action's key code.
     */
    public int getCode() {
        return myCode;
    }
    
    /**
     * The Name of the Enum associated with this Action, derived from the Name.
     * @return the name of an Enum. 
     */
    public String getEnumName() {
        return myName.replaceAll("[.]", "").toUpperCase();
    }

    
}

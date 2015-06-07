// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * Performs an action when the line tool is being used.
 * @author Joshua Moore
 * @version 11/13/13
 *
 */
@SuppressWarnings("serial")
public final class LineAction extends AbstractPaintAction {
    
    /**
     * Creates a new Line action.
     * @param theName the Name of the Action.
     * @param theCode the KeyEvent code for the mnemonic.
     */
    public LineAction(final String theName, final int theCode) {
        super(theName, theCode);
    }
        
    /**
     * Creates a new line shape.
     * {@inheritDoc}
     */
    @Override
    public Shape createGraphics(final Point theP1, final Point theP2) {
     
        return new Line2D.Double((int) theP1.getX(), (int) theP1.getY(),
                   (int) theP2.getX(), (int) theP2.getY());
        
    }
    

    

}

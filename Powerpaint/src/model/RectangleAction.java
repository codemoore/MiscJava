// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * Performs an action when the line tool is being used.
 * @author Joshua Moore
 * @version 11/13/13
 *
 */
@SuppressWarnings("serial")
public final class RectangleAction extends AbstractPaintAction {
    
    /**
     * Creates a new rectangle action.
     * @param theName the Name of the Action.
     * @param theCode the KeyEvent code for the mnemonic.
     */
    public RectangleAction(final String theName, final int theCode) {
        super(theName, theCode);

        
    }

    /**
     * Creates a rectangle Shape.
     * {@inheritDoc}
     */
    @Override
    public Shape createGraphics(final Point theP1, final Point theP2) {
        return new Rectangle2D.Double(Math.min(theP1.x, theP2.x), Math.min(theP1.y, theP2.y),
                      Math.abs(theP2.x - theP1.x), Math.abs(theP2.y - theP1.y));

    }

    


}

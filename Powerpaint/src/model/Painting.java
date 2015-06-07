/* 
 * TCSS 305 – Autumn 2013 
 * Assignment 5 - PowerPaint 
 */

package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;

/**
 * Stores a Shape, color, and stroke size, and allows you to draw the shape.
 * @author Joshua Moore
 * @version 11/13/13
 */
public class Painting {
    
    /**
     * The Color the shape is.
     */
    private final Color myColor;
    
    /**
     * The size of the stroke the shape is drawn with.
     */
    private final int myStrokeSize;
    
    /**
     * The Shape that is being stored and drawn.
     */
    private Shape myShape;
    
    
    /**
     * Creates a new paint object.
     * @param theColor the color of the painting.
     * @param theStroke the stroke size of the painting.
     * @param theShape  the shape of the painting.
     */
    public Painting(final Color theColor, final int theStroke, 
                    final Shape theShape) {
        myColor = theColor;
        myStrokeSize = theStroke;
        myShape = theShape;
    }
        
    /**
     * Draws the painting using it's stored color, stroke size, and shape.
     * @param theG the Graphics used to draw the painting.
     */
    public void redraw(final Graphics2D theG) {
        theG.setColor(myColor);
        theG.setStroke(new BasicStroke(myStrokeSize));
        theG.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        theG.draw(myShape);
    }
    

}

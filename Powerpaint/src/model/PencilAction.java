// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Performs an action when the Pencil tool is being used.
 * @author Joshua Moore
 * @version 11/13/13
 *
 */
@SuppressWarnings("serial")
public final class PencilAction extends AbstractPaintAction implements PropertyChangeListener {
    
    /**
     * Has the mouse button been released for this path?
     */
    private boolean myIsMouseReleased;
    
    /**
     * The list of points the mouse has been dragged over.
     */
    private List<Point> myPoints;
    
    /**
     * Creates a new Pencil action.
     * @param theName the Name of the Action.
     * @param theCode the KeyEvent code for the mnemonic.
     */
    public PencilAction(final String theName, final int theCode) {
        super(theName, theCode);
        myIsMouseReleased = false;
        myPoints = new ArrayList<Point>();
    }
    
    /**
     * Creates a path shape and returns it.
     * {@inheritDoc}
     */
    @Override
    public Shape createGraphics(final Point theP1, final Point theP2) {
        myPoints.add(0, theP1);
        myPoints.add(theP2);
        
        
        final Path2D path = new GeneralPath();
        path.moveTo(myPoints.get(0).getX(), myPoints.get(0).getY());
        for (int i = 1; i < myPoints.size(); i++) {
            path.lineTo(myPoints.get(i).getX(), myPoints.get(i).getY());
        }       
        
        if (myIsMouseReleased) {
            myIsMouseReleased = !myIsMouseReleased;
            myPoints.clear();
        }
        return path;
        
    }

    /**
     * Triggered when a property change is fired.
     * Changes myIsMouseReleased to true if it's the MouseRelease propertyChange.
     * @param theEvent the event that triggered the propertyChange.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("MouseRelease".equals(theEvent.getPropertyName())) {
            myIsMouseReleased = true;           
        }
    }
    


}

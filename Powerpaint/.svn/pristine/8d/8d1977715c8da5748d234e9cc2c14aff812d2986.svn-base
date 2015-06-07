// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.event.KeyEvent;

import javax.swing.Action;

/**
 * Enum that stores all available tools with their labels and actions.
 * 
 * About Warnings:  this class has checkstyle warnings for more than one instance of a String.
 *                  Because each these String are only used twice I elected to ignore it. 
 * 
 * @author Joshua Moore
 * @version 11/12/13
 */
public enum Tool {
    /**
     * Stores the button name and action for the Color tool.
     */
    COLOR("Color...", new ColorAction("Color...", KeyEvent.VK_C), false),
    
    /**
     * Stores the button name and action for the Pencil tool.
     */
    PENCIL("Pencil", new PencilAction("Pencil", KeyEvent.VK_P)),
    
    /**
     * Stores the button name and action for the Line tool.
     */
    LINE("Line", new LineAction("Line", KeyEvent.VK_L)),
    
    /**
     * Stores the button name and action for the Rectangle tool.
     */
    RECTANGLE("Rectangle", new RectangleAction("Rectangle", KeyEvent.VK_R)),
    
    /**
     * Stores the button name and action for the Ellipse tool.
     */
    ELLIPSE("Ellipse", new EllipseAction("Ellipse", KeyEvent.VK_E)),
    
    /**
     * Button name and action for undo tool.
     */
    UNDO("Undo", new UndoAction("Undo", KeyEvent.VK_U), false),
    
    /**
     * Button name and action for redo tool.
     */  
    REDO("Redo", new RedoAction("Redo", KeyEvent.VK_D), false);
    
    /**
     * The Name that appears on this Tool's button.
     */
    private final String myName;
    
    /**
     * The Action attached to the Tool which handle's it's functionality.
     */
    private final Action myAction;
    
    /**
     * If true the tool is grouped together with other tools. 
     * If false it is independent.
     */
    private boolean myIsGrouped;
    
    /**
     * Constructs a new Tool object with a name and a PaintAction.
     * @param theName the button name of the tool.
     * @param theAction the Action associated with the tool.
     */
    private Tool(final String theName, final AbstractPaintAction theAction) {
        this(theName, theAction, true);
    }
    
    /**
     * Constructs a new Tool object with a name and a PaintAction.
     * @param theName the button name of the tool.
     * @param theAction the Action associated with the tool.
     * @param theIsGrouped if the tool is grouped or independent.
     */
    private Tool(final String theName, final AbstractPaintAction theAction,
                 final boolean theIsGrouped) {
        myName = theName;
        myAction = theAction;
        myIsGrouped = theIsGrouped;
    }
    
    /**
     * 
     * @return the String name for the tool's buttons.
     */
    public String getName() {
        return myName;
    }
    
    /**
     * Gets the Tool's PaintAction.
     * @return the Action associated to this Tool.
     */
    public Action getAction() {
        return (AbstractPaintAction) myAction;
    }
    
    /**
     * Is the tool grouped or independent?
     * @return if the tool is grouped or not.
     */
    public boolean isGrouped() {
        return myIsGrouped;
    }
}

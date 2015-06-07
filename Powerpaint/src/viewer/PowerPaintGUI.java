// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package viewer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import model.ColorAction;
import model.DrawingPanel;
import model.PaintMenuBar;
import model.Tool;
import model.ToolBar;

/**
 * Creates the GUI for PowerPaint with back end functionality attached.
 * 
 * @author Joshua Moore
 * @version 11/5/13
 *
 */
public class PowerPaintGUI {
    
    /**
     * The file path for the Icon Image.
     */
    private static final String IMAGE_PATH = "icons/powerpaint.png";
    
    /**
     * The Default starting dimensions of the DrawingPanel.
     */
    private static final Dimension DEFAULT_DIMENSION = new Dimension(500, 300);
    
    /**
     * The Name of the JFrame.
     */
    private static final String FRAME_NAME = "TCSS 305 PowerPaint";
    
    /**
     * The main window for PowerPaint.
     */
    private final JFrame myFrame;
    
    /**
     * Panel that takes mouse input and allows drawing graphics on it.
     */
    private final DrawingPanel myDrawingPanel;
    
    /**
     * Creates a new instance of PowerPaintGUI.
     */
    public PowerPaintGUI() {
        myFrame = new JFrame(FRAME_NAME);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myDrawingPanel = new DrawingPanel(DEFAULT_DIMENSION);
      
        setup();
 
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Makes the toolbar for PowerPaint.
     */
    private void createToolBar() {
        final ToolBar toolBar = new ToolBar();
        for (Tool t:Tool.values()) {
            if (t.isGrouped()) {
                toolBar.addToggleButton(t.toString(), t.getAction());
            } else {
                if ("Color...".equals(t.getName())) {
                    toolBar.addButton(t.toString(), t.getAction(), ColorAction.getColor());
                } else {
                    toolBar.addButton(t.toString(), t.getAction());
                }

            }
            t.getAction().addPropertyChangeListener(myDrawingPanel);
        }
        myFrame.add(toolBar, BorderLayout.SOUTH);
    }
    
    /**
     * Makes the top menu bar for PowerPaint.
     */
    private void createMenuBar() {
        final PaintMenuBar bar = new PaintMenuBar(myFrame);
        bar.addPropertyChangeListener(myDrawingPanel);
        Tool.COLOR.getAction().addPropertyChangeListener(bar);
        myFrame.setJMenuBar(bar);      
    }
    
    /**
     * Performs necessary setup for PowerPaint:
     * Sets the JFrame icon, adds a property listener to the DrawingPanel,
     * adds the DrawingPanel, creates and adds the ToolBar and MenuBar.
     */
    private void setup() {
        try {
            myFrame.setIconImage(ImageIO.read(new File(IMAGE_PATH)));
        } catch (final IOException e) { //error message for debugging.
            System.out.println("image loading didn't work");
        }
        myDrawingPanel.addPropertyChangeListener(
                        (PropertyChangeListener) (Tool.PENCIL.getAction()));
        myFrame.add(myDrawingPanel, BorderLayout.CENTER);    
        
        createMenuBar();
        createToolBar(); 
    }
}    
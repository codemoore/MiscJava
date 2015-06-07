// CSS 305 - Autumn 2013
// Assignment 5 - PowerPaint

package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

/**
 * The Menu Bar specific to PowerPaint.
 * Don't look in here it's kind of messy.
 * @author Joshua Moore
 * @version 11/14/13
 *
 */
@SuppressWarnings("serial")
public class PaintMenuBar extends JMenuBar implements PropertyChangeListener {
    
    /**
     * The thicknesses available for stroke size.
     */
    private static final int[] THICKNESS = {1, 2, 4};
    
    /**
     * The Message displayed when About is selected.
     */
    private static final String ABOUT_MESSAGE = 
            "TCSS 305 PowerPaint, Autumn 2013";
    
    /**
     * Class that contains methods to easily create new items.
     */
    private final MenuBar myMenuCreator;
    
    /**
     * Reference to the frame thats being closed.
     */
    private final JFrame myFrame;
    
    /**
     * Keeps track of the color.
     */
    private Color myColor;
    
    /**
     * Keeps track of the color item.
     */
    private JMenuItem myColorItem;
    
    /**
     * Creates a new PaintMenuBar.
     * @param theFrame reference to the JFrame this bar will be attached to.
     */
    public PaintMenuBar(final JFrame theFrame) {
        super();
        myMenuCreator = new MenuBar();
        myFrame = theFrame;
        myColor = Color.BLACK;
        myColorItem = myMenuCreator.createMenuItem("Clear", 
                                                   KeyEvent.VK_C, new ActionListener() {
                //fires a property change when activated
            @Override
            public void actionPerformed(final ActionEvent theE) {
                firePropertyChange("Clear", "old value", "new Value");
            }
        });

        start();
    }
    
    /**
     * creates and adds all of the menus and items.
     */
    private void start() {     
        final JMenu file = myMenuCreator.createMenu("File", KeyEvent.VK_F);
        
        file.add(myColorItem);
        file.addSeparator();
        file.add(myMenuCreator.createMenuItem("Exit", new ExitAction("Exit", KeyEvent.VK_X)));
            
        add(file);
        
        final JMenu options = myMenuCreator.createMenu("Options", KeyEvent.VK_O);
        add(options);
        options.add(myMenuCreator.createCheckItem("Grid", KeyEvent.VK_G, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final boolean issEnabled = ((JCheckBoxMenuItem) 
                                               theEvent.getSource()).isEnabled();
                firePropertyChange("Grid", issEnabled, !issEnabled);
            }
        }));
        final JMenu thick = myMenuCreator.createMenu("Thickness", KeyEvent.VK_T);
        final ButtonGroup thickGroup = new ButtonGroup();
        for (final int t: THICKNESS) {
            final JRadioButtonMenuItem item = myMenuCreator.createRadioItem("" + t);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent theEvent) {
                    firePropertyChange("Stroke", null, t);            
                }
                
            });
            thick.add(item);
            thickGroup.add(item);
            if (t == 1) {
                thickGroup.setSelected(item.getModel(), true);
            }
            
        }
        options.add(thick);
        
        final JMenu tools = myMenuCreator.createMenu("Tools", KeyEvent.VK_T);
        final List<JMenuItem> radios = new ArrayList<JMenuItem>();
        for (Tool t:Tool.values()) {
            if (t.isGrouped()) {
                radios.add(myMenuCreator.createRadioItem(t.toString(), t.getAction()));
            } else {
                if ("Color".equals(t.getName())) {
                    radios.add(myMenuCreator.createMenuItem(t.toString(),
                                                            t.getAction(), myColor));
                } else {
                    radios.add(myMenuCreator.createMenuItem(t.toString(), t.getAction()));
                }
            }                   
        }
        
        
        radios.get(0).setBackground(Color.BLACK);
        radios.get(1).setSelected(true);
        tools.add(radios.get(0));
        tools.addSeparator();
        for (int i = 1; i < radios.size(); i++) {
            tools.add(radios.get(i));
        }

        add(tools);
       
        final JMenu help = myMenuCreator.createMenu("Help", KeyEvent.VK_H);
        help.add(myMenuCreator.createMenuItem("About", 
                         new DisplayMessage("About", KeyEvent.VK_A, this)));
        add(help);
    }
    
    /**
     * Fires an event that should trigger a colorChange.
     * {@inheritDoc}
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("ColorChange".equals(theEvent.getPropertyName())) {
            myColorItem.setBackground(ColorAction.getColor()); 
        }       
    }
    
    /**
     * Action for disposing the frame.
     * @author Joshua Moore
     * @version 11/14/13
     */
    private class ExitAction extends AbstractAction { 
        /**
         * Creates a new ExitAction.
         * @param theName the name of the Action,
         * @param theCode the mnemonic key code.
         */
        public ExitAction(final String theName, final int theCode) {
            putValue(Action.NAME, theName);
            putValue(Action.MNEMONIC_KEY, theCode);
        }
        
        @Override
        public void actionPerformed(final ActionEvent theE) {
            myFrame.dispose();         
        }   
    }
    
    /**
     * Action for displaying an about message.
     * @author Joshua Moore
     * @version 11/14/13
     */
    private class DisplayMessage extends AbstractAction {
        /**
         * The Component thats making the message.
         */
        private Component myItem;
        
        /**
         * Creates a new DisplayMessage.
         * @param theName the name of the Action,
         * @param theCode the mnemonic key code.
         * @param theItem 
         */
        public DisplayMessage(final String theName, final int theCode,
                               final Component theItem) {
            putValue(Action.NAME, theName);
            putValue(Action.MNEMONIC_KEY, theCode);
            myItem = theItem;
        }
        
        @Override
        public void actionPerformed(final ActionEvent theE) {
            JOptionPane.showMessageDialog(myItem, ABOUT_MESSAGE);
        }
        
    }
    
    

}

/*
 * @(#)DesignPatterns.java   2011-11-01
 * 
 * Copyright (c) 2011 Giorgio Peron giorgio.peron@gmail.com
 * All Rights Reserved. 
 *
 * Redistribution and use of this script, with or without modification, is
 * permitted provided that the following conditions are met:
 *
 * 1. Redistributions of this script must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO
 * EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */



package gamma.designpatterns;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * <p>Title: Design Patterns</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2003-2005</p>
 *
 * <p>Company: GioPerLab</p>
 *
 * @author giorgio_peron@libero.it
 * @version 1.0
 */
public class DesignPatterns extends JFrame {
    JPanel contentPane;
    BorderLayout borderLayout1 = new BorderLayout();
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    JToolBar jToolBar = new JToolBar();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    ImageIcon image1 =
        new ImageIcon(gamma.designpatterns.DesignPatterns.class.getResource("openFile.png"));
    ImageIcon image2 =
        new ImageIcon(gamma.designpatterns.DesignPatterns.class.getResource("closeFile.png"));
    ImageIcon image3 =
        new ImageIcon(gamma.designpatterns.DesignPatterns.class.getResource("help.png"));
    JLabel statusBar = new JLabel();
    JMenu jMenuCreational = new JMenu();
    JMenuItem jMenuItemAbstractFactory = new JMenuItem();
    JMenuItem jMenuItemBuilder = new JMenuItem();
    JMenuItem jMenuItemFactoryMethod = new JMenuItem();
    JMenuItem jMenuItemPrototype = new JMenuItem();
    JMenuItem jMenuItemSingleton = new JMenuItem();
    JMenu jMenuDesignPatterns = new JMenu();
    JMenu jMenuBehavioral = new JMenu();
    JMenuItem jMenuItemResponsability = new JMenuItem();
    JMenuItem jMenuItemCommand = new JMenuItem();
    JMenuItem jMenuItemObserver = new JMenuItem();
    JMenuItem jMenuItemVisitor = new JMenuItem();
    JMenu jMenuStructural = new JMenu();
    JMenuItem jMenuItemAdapter = new JMenuItem();
    JMenuItem jMenuItemBridge = new JMenuItem();
    JMenuItem jMenuItemComposite = new JMenuItem();
    JMenuItem jMenuItemDecorator = new JMenuItem();
    JMenuItem jMenuItemFacade = new JMenuItem();
    JMenuItem jMenuItemFlyweight = new JMenuItem();
    JMenuItem jMenuItemProxy = new JMenuItem();
    JMenuItem jMenuItemInterpreter = new JMenuItem();
    JMenuItem jMenuItemIterator = new JMenuItem();
    JMenuItem jMenuItemMediator = new JMenuItem();
    JMenuItem jMenuItemMemento = new JMenuItem();
    JMenuItem jMenuItemState = new JMenuItem();
    JMenuItem jMenuItemStrategy = new JMenuItem();
    JMenuItem jMenuItemTemplateMethod = new JMenuItem();

    /**
     * Constructs ...
     *
     */
    public DesignPatterns() {
        try {
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(borderLayout1);
        setSize(new Dimension(400, 300));
        setTitle("Design Patterns Examples");
        statusBar.setText(" ");
        jMenuFile.setText("File");
        jMenuFileExit.setText("Exit");
        jMenuFileExit.addActionListener(new DesignPatterns_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("Help");
        jMenuHelpAbout.setText("About");
        jMenuHelpAbout.addActionListener(new DesignPatterns_jMenuHelpAbout_ActionAdapter(this));
        jMenuCreational.setText("Creational");
        jMenuItemAbstractFactory.setActionCommand("Abstract Factory");
        jMenuItemAbstractFactory.setText("Abstract Factory");
        jMenuItemAbstractFactory.addActionListener(
            new DesignPatterns_jMenuItem1_actionAdapter(this));
        jMenuItemBuilder.setText("Builder");
        jMenuItemFactoryMethod.setText("Factory Method");
        jMenuItemPrototype.setText("Prototype");
        jMenuItemSingleton.setText("Singleton");
        jMenuDesignPatterns.setText("Design Patterns");
        jMenuBehavioral.setText("Behavioral");
        jMenuItemResponsability.setText("Chain of Responsability");
        jMenuItemCommand.setText("Command");
        jMenuItemObserver.setText("Observer");
        jMenuItemVisitor.setText("Visitor");
        jMenuStructural.setText("Structural");
        jMenuItemAdapter.setText("Adapter");
        jMenuItemBridge.setText("Bridge");
        jMenuItemComposite.setText("Composite");
        jMenuItemDecorator.setText("Decorator");
        jMenuItemFacade.setText("Facade");
        jMenuItemFlyweight.setText("Flyweight");
        jMenuItemProxy.setText("Proxy");
        jMenuItemInterpreter.setText("Interpreter");
        jMenuItemIterator.setText("Iterator");
        jMenuItemMediator.setText("Mediator");
        jMenuItemMemento.setText("Memento");
        jMenuItemState.setText("State");
        jMenuItemStrategy.setText("Strategy");
        jMenuItemTemplateMethod.setText("Template Method");
        jMenuBar1.add(jMenuFile);
        jMenuBar1.add(jMenuDesignPatterns);
        jMenuFile.add(jMenuFileExit);
        jMenuBar1.add(jMenuHelp);
        jMenuHelp.add(jMenuHelpAbout);
        setJMenuBar(jMenuBar1);
        jButton1.setIcon(image1);
        jButton1.setToolTipText("Open File");
        jButton2.setIcon(image2);
        jButton2.setToolTipText("Close File");
        jButton3.setIcon(image3);
        jButton3.setToolTipText("Help");
        jToolBar.add(jButton1);
        jToolBar.add(jButton2);
        jToolBar.add(jButton3);
        contentPane.add(jToolBar, BorderLayout.NORTH);
        contentPane.add(statusBar, BorderLayout.SOUTH);
        jMenuCreational.add(jMenuItemAbstractFactory);
        jMenuCreational.add(jMenuItemBuilder);
        jMenuCreational.add(jMenuItemFactoryMethod);
        jMenuCreational.add(jMenuItemPrototype);
        jMenuCreational.add(jMenuItemSingleton);
        jMenuDesignPatterns.add(jMenuCreational);
        jMenuDesignPatterns.add(jMenuStructural);
        jMenuDesignPatterns.add(jMenuBehavioral);
        jMenuBehavioral.add(jMenuItemResponsability);
        jMenuBehavioral.add(jMenuItemCommand);
        jMenuBehavioral.add(jMenuItemInterpreter);
        jMenuBehavioral.add(jMenuItemIterator);
        jMenuBehavioral.add(jMenuItemMediator);
        jMenuBehavioral.add(jMenuItemMemento);
        jMenuBehavioral.add(jMenuItemObserver);
        jMenuBehavioral.add(jMenuItemState);
        jMenuBehavioral.add(jMenuItemStrategy);
        jMenuBehavioral.add(jMenuItemTemplateMethod);
        jMenuBehavioral.add(jMenuItemVisitor);
        jMenuStructural.add(jMenuItemAdapter);
        jMenuStructural.add(jMenuItemBridge);
        jMenuStructural.add(jMenuItemComposite);
        jMenuStructural.add(jMenuItemDecorator);
        jMenuStructural.add(jMenuItemFacade);
        jMenuStructural.add(jMenuItemFlyweight);
        jMenuStructural.add(jMenuItemProxy);
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    /**
     * Help | About action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        DesignPatterns_AboutBox dlg = new DesignPatterns_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void jMenuItem1_actionPerformed(ActionEvent e) {}
}


class DesignPatterns_jMenuFileExit_ActionAdapter implements ActionListener {
    DesignPatterns adaptee;

    DesignPatterns_jMenuFileExit_ActionAdapter(DesignPatterns adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Method description
     *
     *
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class DesignPatterns_jMenuItem1_actionAdapter implements ActionListener {
    private DesignPatterns adaptee;

    DesignPatterns_jMenuItem1_actionAdapter(DesignPatterns adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        adaptee.jMenuItem1_actionPerformed(e);
    }
}


class DesignPatterns_jMenuHelpAbout_ActionAdapter implements ActionListener {
    DesignPatterns adaptee;

    DesignPatterns_jMenuHelpAbout_ActionAdapter(DesignPatterns adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * Method description
     *
     *
     * @param actionEvent
     */
    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}

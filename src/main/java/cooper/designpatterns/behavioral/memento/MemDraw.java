/*
 * @(#)MemDraw.java   2011-11-01
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



package cooper.designpatterns.behavioral.memento;

import java.awt.*;
import java.awt.event.*;

//swing classes
import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class MemDraw extends JxFrame implements ActionListener {
    JToolBar tbar;
    Mediator med;

    /**
     * Constructs ...
     *
     */
    public MemDraw() {
        super("Memento Drawing");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        med = new Mediator();
        jp.setLayout(new BorderLayout());
        tbar = new JToolBar();
        jp.add("North", tbar);
        RectButton rect = new RectButton(this, med);
        tbar.add(rect);
        UndoButton undo = new UndoButton(this, med);
        tbar.add(undo);
        tbar.addSeparator();
        ClearButton clr = new ClearButton(this, med);
        tbar.add(clr);
        JCanvas canvas = new JCanvas(med);
        jp.add("Center", canvas);
        MouseApp map = new MouseApp(med);
        canvas.addMouseListener(map);
        MouseMoveApp mvap = new MouseMoveApp(med);
        canvas.addMouseMotionListener(mvap);
        setSize(new Dimension(400, 300));
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        Command comd = (Command) e.getSource();
        comd.Execute();
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String[] argv) {
        new MemDraw();
    }
}


class MouseApp extends MouseAdapter {
    Mediator med;

    /**
     * Constructs ...
     *
     *
     * @param md
     */
    public MouseApp(Mediator md) {
        super();
        med = md;
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void mousePressed(MouseEvent e) {
        med.createRect(e.getX(), e.getY());
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void mouseReleased(MouseEvent e) {
        med.rememberPosition();
    }
}


class MouseMoveApp extends MouseMotionAdapter {
    Mediator med;

    /**
     * Constructs ...
     *
     *
     * @param md
     */
    public MouseMoveApp(Mediator md) {
        super();
        med = md;
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void mouseDragged(MouseEvent e) {
        med.drag(e.getX(), e.getY());
    }
}

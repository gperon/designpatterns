/*
 * @(#)TriangleDemo.java   2011-11-01
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



package cooper.designpatterns.behavioral.templatemethod;

import cooper.designpatterns.util.swing.JxFrame;

import java.awt.*;

import java.util.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class TriangleDemo extends JxFrame {
    StandardTriangle t, t1;
    IsocelesTriangle it;

    /**
     * Constructs ...
     *
     */
    public TriangleDemo() {
        super("Draw triangles");
        TPanel tp = new TPanel();
        t = new StandardTriangle(new Point(10, 10), new Point(150, 50), new Point(100, 75));
        it = new IsocelesTriangle(new Point(150, 100), new Point(240, 40), new Point(175, 150));
        t1 = new StandardTriangle(new Point(100, 100), new Point(240, 40), new Point(175, 150));
        tp.addTriangle(t);
        tp.addTriangle(it);
        tp.addTriangle(t1);
        getContentPane().add(tp);
        setSize(300, 200);
        setBackground(Color.white);
        setVisible(true);
    }

    /**
     * Method description
     *
     *
     * @param arg
     */
    static public void main(String[] arg) {
        new TriangleDemo();
    }
}


class TPanel extends JPanel {
    Vector triangles;

    /**
     * Constructs ...
     *
     */
    public TPanel() {
        triangles = new Vector();
    }

    /**
     * Method description
     *
     *
     * @param t
     */
    public void addTriangle(AbstractTriangle t) {
        triangles.addElement(t);
    }

    /**
     * Method description
     *
     *
     * @param g
     */
    public void paint(Graphics g) {
        for (int i = 0; i < triangles.size(); i++) {
            AbstractTriangle tngl = (AbstractTriangle) triangles.elementAt(i);
            tngl.draw(g);
        }
    }
}

/*
 * @(#)TextView.java   2011-11-01
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



package gamma.designpatterns.structural.adapter;

import gamma.designpatterns.structural.bridge.View;
import gamma.designpatterns.structural.bridge.Window;

/**
 * <p>Title: Design Patterns</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: GioPerLab</p>
 * @author giorgio_peron@libero.it
 * @version 1.0
 */
public class TextView implements View {
    protected String text;
    protected boolean empty;
    protected int x, y, w, h;

    /**
     * Constructs ...
     *
     */
    public TextView() {
        this(0, 0, 20, 4);
    }

    /**
     * Constructs ...
     *
     *
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public TextView(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.text = new String("Text in the view.");
    }

    /**
     * Method description
     *
     *
     * @param x
     * @param y
     */
    public void getOrigin(Coord x, Coord y) {
        x.setValue(this.x);
        y.setValue(this.y);
    }

    /**
     * Method description
     *
     *
     * @param width
     * @param height
     */
    public void getExtent(Coord width, Coord height) {
        width.setValue(this.w);
        height.setValue(this.h);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Method description
     *
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(text).append("\n");
        for (int i = 0; i < y; i++) {
            sb.append("\n");
        }
        StringBuilder space = repeatString(' ', x);
        StringBuilder topBottom = repeatString('-', w - 2);
        StringBuilder central = repeatString(' ', w - 2);
        sb.append(space).append('+').append(topBottom).append("+\n");
        for (int j = 1; j < h - 1; j++) {
            sb.append(space).append("|").append(central).append("|\n");
        }
        sb.append(space).append('+').append(topBottom).append("+\n");

        return sb.toString();
    }

    private static StringBuilder repeatString(char c, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(c);
        }

        return sb;
    }

    /**
     * draw
     *
     * @todo Implement this
     *   designpatterns.structural.decorator.VisualComponent method
     */
    public void draw() {
        System.out.print("draw TextView: " + text);
    }

    /**
     * resize
     *
     * @todo Implement this
     *   designpatterns.structural.decorator.VisualComponent method
     */
    public void resize() {}

    /**
     * Method description
     *
     *
     * @param w
     */
    public void drawOn(Window w) {}
}

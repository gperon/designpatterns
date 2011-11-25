/*
 * @(#)Window.java   2011-11-01
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



package gamma.designpatterns.structural.bridge;

import java.awt.*;

/**
 * <p>Title: Design Patterns</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2003-2005</p>
 *
 * <p>Company: GioPerLab</p>
 *
 * @author not attributable
 * @version 1.0
 */
public abstract class Window {
    private WindowImp imp;
    private View contents;    // the window's contents
    private String sys;       // system implementation

    protected Window(View contents) {
        this.contents = contents;
        this.sys = "X";
    }

    // requests handled by window

    /**
     * Method description
     *
     */
    public void drawContents() {
        contents.draw();
    }

    /**
     * Method description
     *
     */
    public abstract void open();

    /**
     * Method description
     *
     */
    public abstract void close();

    /**
     * Method description
     *
     */
    public abstract void iconify();

    /**
     * Method description
     *
     */
    public abstract void deiconify();

    // requests forwarded to implementation

    /**
     * Method description
     *
     *
     * @param at
     */
    public abstract void setOrigin(final Point at);

    /**
     * Method description
     *
     *
     * @param extent
     */
    public abstract void setExtent(final Point extent);

    /**
     * Method description
     *
     */
    public abstract void raise();

    /**
     * Method description
     *
     */
    public abstract void lower();

    /**
     * Method description
     *
     *
     * @param p0
     * @param p1
     */
    public abstract void drawLine(final Point p0, final Point p1);

    /**
     * Method description
     *
     *
     * @param p1
     * @param p2
     */
    public void drawRect(final Point p1, final Point p2) {
        WindowImp imp = getWindowImp();
        imp.deviceRect(new Coord(p1.getX()), new Coord(p1.getY()), new Coord(p2.getX()),
                       new Coord(p2.getY()));
    }

    /**
     * Method description
     *
     *
     * @param vertex
     * @param n
     */
    public abstract void drawPolygon(final Point[] vertex, int n);

    /**
     * Method description
     *
     *
     * @param s
     * @param p
     */
    public abstract void drawText(final String s, final Point p);

    /**
     * Method description
     *
     *
     * @return
     */
    public WindowImp getWindowImp() {
        if (imp == null) {
            imp = WindowSystemFactory.getInstance().makeWindowImp(getSys());
        }

        return imp;
    }

    protected abstract View getView();

    /**
     * Method description
     *
     *
     * @param contents
     */
    public void setContents(View contents) {
        this.contents = contents;
    }

    /**
     * Method description
     *
     *
     * @param sys
     */
    public void setSys(String sys) {
        this.sys = sys;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getSys() {
        return sys;
    }
}

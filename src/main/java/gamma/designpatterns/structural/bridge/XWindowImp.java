/*
 * @(#)XWindowImp.java   2011-11-01
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
public class XWindowImp extends WindowImp {

    /**
     * Constructs ...
     *
     */
    public XWindowImp() {}

    // lots of X window system-specific state, including:
    private Display dpy;
    private Drawable winid;    // window id
    private GC gc;             // window graphic context
    // remainder of public interface...

    /**
     * deviceBitmap
     *
     * @param s String
     * @param a Coord
     * @param b Coord
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     */
    public void deviceBitmap(String s, Coord a, Coord b) {}

    /**
     * deviceRect
     *
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     */
    public void deviceRect(Coord x0, Coord y0, Coord x1, Coord y1) {
        long x = Math.round(Math.min(x0.getValue(), x1.getValue()));
        long y = Math.round(Math.min(y0.getValue(), y1.getValue()));
        long w = Math.round(Math.abs(x0.getValue() - x1.getValue()));
        long h = Math.round(Math.abs(y0.getValue() - y1.getValue()));
        XDrawRectangle(dpy, winid, gc, x, y, w, h);
    }

    private void XDrawRectangle(Display dpy, Drawable winid, GC gc, long x, long y, long w,
                                long h) {}

    /**
     * deviceText
     *
     * @param s String
     * @param a Coord
     * @param b Coord
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     */
    public void deviceText(String s, Coord a, Coord b) {}

    /**
     * impBottom
     *
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     */
    public void impBottom() {}

    /**
     * impSetExtent
     *
     * @param p Point
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     */
    public void impSetExtent(Point p) {}

    /**
     * impSetOrigin
     *
     * @param p Point
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     */
    public void impSetOrigin(Point p) {}

    /**
     * impTop
     *
     * @todo Implement this designpatterns.structural.bridge.WindowImp method
     */
    public void impTop() {}

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @todo Implement this java.lang.Object method
     */
    public String toString() {
        return "X Window System";
    }
}

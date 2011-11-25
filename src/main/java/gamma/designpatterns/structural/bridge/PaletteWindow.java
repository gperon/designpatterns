/*
 * @(#)PaletteWindow.java   2011-11-01
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
public class PaletteWindow extends Window {

    /**
     * Constructs ...
     *
     *
     * @param contents
     */
    public PaletteWindow(View contents) {
        super(contents);
    }

    /**
     * close
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void close() {}

    /**
     * deiconify
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void deiconify() {}

    /**
     * drawContents
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void drawContents() {}

    /**
     * drawLine
     *
     * @param p0 Point
     * @param p1 Point
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void drawLine(Point p0, Point p1) {}

    /**
     * drawPolygon
     *
     * @param vertex Point[]
     * @param n int
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void drawPolygon(Point[] vertex, int n) {}

    /**
     * drawRect
     *
     * @param p0 Point
     * @param p1 Point
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void drawRect(Point p0, Point p1) {}

    /**
     * drawText
     *
     * @param s String
     * @param p Point
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void drawText(String s, Point p) {}

    /**
     * getView
     *
     * @return View
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    protected View getView() {
        return null;
    }

    /**
     * iconify
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void iconify() {}

    /**
     * lower
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void lower() {}

    /**
     * open
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void open() {}

    /**
     * raise
     *
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void raise() {}

    /**
     * setExtent
     *
     * @param extent Point
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void setExtent(Point extent) {}

    /**
     * setOrigin
     *
     * @param at Point
     * @todo Implement this designpatterns.structural.bridge.Window method
     */
    public void setOrigin(Point at) {}

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @todo Implement this java.lang.Object method
     */
    public String toString() {
        return "Palet on " + getWindowImp().toString();
    }
}

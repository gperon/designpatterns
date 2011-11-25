/*
 * @(#)TextShapeComposition.java   2011-11-01
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
public class TextShapeComposition implements Shape {
    private TextView text;

    /**
     * Constructs ...
     *
     *
     * @param t
     */
    public TextShapeComposition(TextView t) {
        this.text = t;
    }

    /**
     * Description of the Method
     *
     * @param bottomLeft Description of the Parameter
     * @param topRight Description of the Parameter
     */
    public void boundingBox(Point bottomLeft, Point topRight) {
        Coord bottom = new Coord();
        Coord left = new Coord();
        Coord width = new Coord();
        Coord height = new Coord();
        text.getOrigin(bottom, left);
        text.getExtent(width, height);
        bottomLeft = new Point(bottom.getValue(), left.getValue());
        topRight = new Point(bottom.getValue() + width.getValue(),
                             left.getValue() + height.getValue());
    }

    /**
     * Description of the Method
     *
     * @return Description of the Return Value
     * @todo Implement this designpatterns.structural.adapter.Shape method
     */
    public Manipulator createManipulator() {
        return new TextManipulator(this);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean isEmpty() {
        return text.isEmpty();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String toString() {
        return text.toString();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public TextView getText() {
        return text;
    }
}

/*
 * @(#)Composition.java   2011-11-01
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



package gamma.designpatterns.behavioral.strategy;

import java.util.*;

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
public class Composition {
    private Compositor compositor;
    private List<Component> components;    // the list of components
    private int componentCount;            // the number of components
    private int lineWidth;                 // the Composition's line width
    private int[] lineBreaks;              // the position of linebreaks
    // in components
    private int lineCount;    // the number of lines

    /**
     * Constructs ...
     *
     *
     * @param compositor
     */
    public Composition(Compositor compositor) {}

    /**
     * Method description
     *
     */
    public void repair() {
        Coord[] natural = new Coord[1];
        Coord[] stretchability = new Coord[1];
        Coord[] shrinkability = new Coord[1];
        int componentCount;
        int[] breaks = new int[1];
        // prepare the arrays with the desired component sizes
        // ...
        natural[0] = new Coord();
        stretchability[0] = new Coord();
        shrinkability[0] = new Coord();
        componentCount = 0;
        breaks[0] = 1;
        // determine where the breaks are:
        int breakCount;
        breakCount = compositor.compose(natural, stretchability, shrinkability, componentCount,
                                        lineWidth, breaks);
        // lay out components according to breaks
        // ...
    }
}

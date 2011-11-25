/*
 * @(#)Character.java   2011-11-01
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



package gamma.designpatterns.structural.flyweight;

import java.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: Design Patterns Examples</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: GioPerLab</p>
 * @author giorgio_peron@libero.it
 * @version 1.0
 */
public class Character implements Glyph {
    private char charcode;

    /**
     * Constructs ...
     *
     *
     * @param charcode
     */
    public Character(char charcode) {
        this.charcode = charcode;
    }

    /**
     * Method description
     *
     *
     * @param win
     * @param context
     */
    public void draw(Window win, GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method draw() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param font
     * @param context
     */
    public void setFont(Font font, GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method setFont() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param context
     */
    public void first(GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method first() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param context
     */
    public void next(GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method next() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param context
     *
     * @return
     */
    public boolean isDone(GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method isDone() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param context
     *
     * @return
     */
    public Glyph current(GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method current() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param glyph
     * @param context
     */
    public void insert(Glyph glyph, GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method insert() not yet implemented.");
    }

    /**
     * Method description
     *
     *
     * @param context
     */
    public void remove(GlyphContext context) {

        /** @todo Implement this designpatterns.structural.flyweight.Glyph method */
        throw new java.lang.UnsupportedOperationException("Method remove() not yet implemented.");
    }
}

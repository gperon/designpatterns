/*
 * @(#)BytecodeStream.java   2011-11-01
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



package gamma.designpatterns.structural.facade;

import java.io.*;

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
public class BytecodeStream extends OutputStream {
    private List<Bytecode> stream;

    /**
     * Constructs ...
     *
     */
    public BytecodeStream() {
        this.stream = new ArrayList<Bytecode>();
    }

    /**
     * Writes <code>b.length</code> bytes from the specified byte array to
     * this output stream.
     *
     * @param b the data.
     * @throws IOException if an I/O error occurs.
     * @todo Implement this java.io.OutputStream method
     */
    public void write(byte[] b) throws IOException {
        for (byte bt : b) {
            stream.add(new Bytecode(bt));
        }
    }

    /**
     * Writes <code>len</code> bytes from the specified byte array starting
     * at offset <code>off</code> to this output stream.
     *
     * @param b the data.
     * @param off the start offset in the data.
     * @param len the number of bytes to write.
     * @throws IOException if an I/O error occurs. In particular, an
     *   <code>IOException</code> is thrown if the output stream is closed.
     * @todo Implement this java.io.OutputStream method
     */
    public void write(byte[] b, int off, int len) throws IOException {
        for (byte bt : b) {
            stream.add(new Bytecode(bt));
        }
    }

    /**
     * Writes the specified byte to this output stream.
     *
     * @param b the <code>byte</code>.
     * @throws IOException if an I/O error occurs. In particular, an
     *   <code>IOException</code> may be thrown if the output stream has
     *   been closed.
     * @todo Implement this java.io.OutputStream method
     */
    public void write(int b) throws IOException {
        stream.add(new Bytecode((byte) b));
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     * @todo Implement this java.lang.Object method
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Bytecode bc : stream) {
            sb.append(bc);
        }

        return sb.toString();
    }
}

/*
 * @(#)Printer.java   2011-11-01
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



package cooper.designpatterns.creational.singleton;

/**
 *
 * @author gperon
 */
public class Printer {

    // this is a prototype for a printer-spooler class
    // such that only one instance can ever exist
    static boolean instance_flag = false;    // true if 1 instance

    /**
     * Constructs ...
     *
     *
     * @throws SingletonException
     */
    public Printer() throws SingletonException {
        if (instance_flag) {
            throw new SingletonException("Only one printer allowed");
        } else {
            instance_flag = true;    // set flag for 1 instance
        }

        System.out.println("printer opened");
    }

    /**
     * Method description
     *
     */
    public void finalize() {
        instance_flag = false;
    }

    static void print(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

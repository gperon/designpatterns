/*
 * @(#)ShowDynamicProxy.java   2011-11-01
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



package metsker.designpatterns.structural.proxy;

import java.util.HashSet;
import java.util.Set;

import metsker.designpatterns.util.firework.Firecracker;
import metsker.designpatterns.util.firework.Sparkler;
import metsker.designpatterns.util.Dollars;

/**
 * Show an example of using a dynamic proxy to add behavior to an object. In
 * this example, we add an element of impatience, complaining if any method
 * takes too long to execute.
 */
public class ShowDynamicProxy {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Set s = new HashSet();
        s = (Set) ImpatientProxy.newInstance(s);
        s.add(new Sparkler("Mr. Twinkle", new Dollars(0.05)));
        s.add(new BadApple("Lemon"));
        s.add(new Firecracker("Mr. Boomy", new Dollars(0.25)));
        System.out.println("The set contains " + s.size() + " things.");
    }
}

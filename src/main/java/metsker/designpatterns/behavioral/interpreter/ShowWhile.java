/*
 * @(#)ShowWhile.java   2011-11-01
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



package metsker.designpatterns.behavioral.interpreter;

import metsker.designpatterns.util.machine.Bin;
import metsker.designpatterns.util.machine.Machine;
import metsker.designpatterns.util.machine.MachineComposite;
import metsker.designpatterns.util.machine.OozinozFactory;
import metsker.designpatterns.behavioral.interpreter.CarryCommand;
import metsker.designpatterns.behavioral.interpreter.Constant;
import metsker.designpatterns.behavioral.interpreter.HasMaterial;
import metsker.designpatterns.behavioral.interpreter.Term;
import metsker.designpatterns.behavioral.interpreter.WhileCommand;

/**
 * Show the use of a "while" interpreter.
 */
public class ShowWhile {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        MachineComposite dublin = OozinozFactory.dublin();
        Term starPress = new Constant((Machine) dublin.find("StarPress:1401"));
        Term fuser = new Constant((Machine) dublin.find("Fuser:1101"));
        starPress.eval().load(new Bin(77));
        starPress.eval().load(new Bin(88));
        WhileCommand command = new WhileCommand(new HasMaterial(starPress),
                                   new CarryCommand(starPress, fuser));
        command.execute();
    }
}

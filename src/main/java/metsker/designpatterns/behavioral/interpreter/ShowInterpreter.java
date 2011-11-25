/*
 * @(#)ShowInterpreter.java   2011-11-01
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
import metsker.designpatterns.util.machine.Fuser;
import metsker.designpatterns.util.machine.MachineComposite;
import metsker.designpatterns.util.machine.OozinozFactory;
import metsker.designpatterns.util.machine.ShellAssembler;
import metsker.designpatterns.util.machine.StarPress;
import metsker.designpatterns.behavioral.command.CarryCommand;
import metsker.designpatterns.behavioral.command.CommandSequence;

/**
 * Demonstrate an initial carry command.
 */
public class ShowInterpreter {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        MachineComposite dublin = OozinozFactory.dublin();
        ShellAssembler assembler = (ShellAssembler) dublin.find("ShellAssembler:3302");
        StarPress press = (StarPress) dublin.find("StarPress:3404");
        Fuser fuser = (Fuser) dublin.find("Fuser:3102");
        assembler.load(new Bin(11011));
        press.load(new Bin(11015));
        CarryCommand carry1 = new CarryCommand(assembler, fuser);
        CarryCommand carry2 = new CarryCommand(press, fuser);
        CommandSequence seq = new CommandSequence();
        seq.add(carry1);
        seq.add(carry2);
        seq.execute();
    }
}

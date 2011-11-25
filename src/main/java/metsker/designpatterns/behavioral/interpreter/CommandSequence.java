/*
 * @(#)CommandSequence.java   2011-11-01
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

/*
* Copyright (c) 2001, 2005. Steven J. Metsker.
*
* Steve Metsker makes no representations or warranties about
* the fitness of this software for any particular purpose,
* including the implied warranty of merchantability.
*
* Please use this software as you wish with the sole
* restriction that you may not claim that you wrote it.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains a sequence of other commands.
 */
public class CommandSequence extends Command {
    protected List commands = new ArrayList();

    /**
     * Add a command to the sequence of commands to which this object will
     * cascade an Execute() command.
     * @param c a command to add
     */
    public void addCommand(Command c) {
        commands.add(c);
    }

    /**
     * @return a string description of this command sequence.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        boolean needLine = false;
        for (int i = 0; i < commands.size(); i++) {
            Command c = (Command) commands.get(i);
            if (needLine) {
                sb.append("\n");
            }
            sb.append(c);
            needLine = true;
        }

        return sb.toString();
    }

    /**
     * Ask each command in the sequence to execute.
     */
    public void execute() {
        for (int i = 0; i < commands.size(); i++) {
            Command c = (Command) commands.get(i);
            c.execute();
        }
    }
}

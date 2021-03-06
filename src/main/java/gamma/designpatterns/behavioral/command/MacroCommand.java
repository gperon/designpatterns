/*
 * @(#)MacroCommand.java   2011-11-01
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


package gamma.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>
 * Title: </p> <p>
 * <p>
 * Description: Design Patterns Examples</p> <p>
 * <p>
 * Copyright: Copyright (c) 2003</p> <p>
 * <p>
 * Company: GioPerLab</p>
 *
 * @author giorgio_peron@libero.it
 * @version 1.0
 * @created 2 marzo 2003
 */
public class MacroCommand implements Command {
    private final List<Command> cmds;

    /**
     * Constructor for the MacroCommand object
     */
    public MacroCommand() {
        cmds = new ArrayList();
    }

    /**
     * Description of the Method
     */
    public void execute() {
        for (Command cmd : cmds) {
            cmd.execute();
        }
    }

    /**
     * Description of the Method
     *
     * @param c Description of the Parameter
     */
    public void add(Command c) {
        cmds.add(c);
    }

    /**
     * Description of the Method
     *
     * @param c Description of the Parameter
     */
    public void remove(Command c) {
        cmds.remove(c);
    }
}

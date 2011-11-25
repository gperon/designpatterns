/*
 * @(#)ShellProcess.java   2011-11-01
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



package metsker.designpatterns.util.process;

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

/**
 * This class provides an object model of Oozinoz's process for making an aerial
 * shell.
 */
public class ShellProcess {
    protected static ProcessSequence make;

    /**
     * @return an object model of Oozinoz's process for making an aerial shell.
     */
    public static ProcessSequence make() {
        if (make == null) {
            make = new ProcessSequence("Make an aerial shell");
            make.add(buildInnerShell());
            make.add(inspect());
            make.add(reworkOrFinish());
        }

        return make;
    }

    protected static ProcessStep buildInnerShell() {
        return new ProcessStep("Build inner shell");
    }

    protected static ProcessStep inspect() {
        return new ProcessStep("Inspect");
    }

    protected static ProcessAlternation reworkOrFinish() {
        return new ProcessAlternation("Rework inner shell, or complete shell",
                                      new ProcessComponent[] { rework(),
                finish() });
    }

    protected static ProcessSequence rework() {
        return new ProcessSequence("Rework", new ProcessComponent[] { disassemble(), make() });
    }

    protected static ProcessStep disassemble() {
        return new ProcessStep("Disassemble");
    }

    protected static ProcessStep finish() {
        return new ProcessStep("Finish: Attach lift, insert fusing, wrap");
    }
}

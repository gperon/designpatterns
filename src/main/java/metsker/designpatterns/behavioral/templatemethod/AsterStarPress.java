/*
 * @(#)AsterStarPress.java   2011-11-01
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



package metsker.designpatterns.behavioral.templatemethod;

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
 * This class runs on the (fictional) Aster star press and aids communication
 * with the factory in which the star press runs. In fact this class is a
 * mock-up that shows how a client might supply a template method.
 *
 * The "Template Method" chapter in "Design Patterns in C#" describes this
 * class.
 */
public abstract class AsterStarPress {
    protected int currentMoldID;

    /**
     * Extrude all of the chemical paste (used for firework stars) to waste
     * area.
     */
    public void dischargePaste() {}

    /**
     * Spray water over the processing and discharge areas, keeping the press
     * from getting gunky.
     */
    public void flush() {}

    /**
     * @return true if the machine is processing a mold.
     */
    public boolean inProcess() {
        return false;
    }

    /**
     * Subclasses have to fill in how the host factory can deal with the problem
     * of an incompletely processed mold.
     *
     * @param id
     *            which mold is incomplete
     */
    public abstract void markMoldIncomplete(int id);

    /**
     * Stop processing, mark the current mold as incomplete, move off all molds,
     * discharge any prepared paste, and flush the processing area with water.
     */
    public void shutdown() {
        if (inProcess()) {
            stopProcessing();
            markMoldIncomplete(currentMoldID);
        }
        usherInputMolds();
        dischargePaste();
        flush();
    }

    /**
     * Stop the processing subassembly.
     */
    public void stopProcessing() {}

    /**
     * Move all molds to the output conveyor.
     */
    public void usherInputMolds() {}
}

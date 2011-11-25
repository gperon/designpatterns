/*
 * @(#)AsterStarPress2.java   2011-11-01
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
 * This class is a revision of the AsterStarPress class that uses the Command
 * pattern to let a client modify its behavior.
 *
 * The "Command" chapter in "Design Patterns in Java" describes this class.
 */
public class AsterStarPress2 {

    /** Field description */
    public Hook moldIncompleteHook;
    protected int currentMoldID;

    /**
     * Constructs ...
     *
     */
    public AsterStarPress2() {
        moldIncompleteHook = new NullHook();
    }

    /**
     * Method description
     *
     *
     * @param hook
     */
    public void setMoldIncompleteHook(Hook hook) {
        moldIncompleteHook = hook;
    }

    /**
     * ID of the mold that is in the processing area.
     *
     * @return
     */
    public int getCurrentMoldID() {
        return currentMoldID;
    }

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
     * @return true if the machine is processing a mold
     */
    public boolean inProcess() {
        return false;
    }

    /**
     * Stop processing, mark the current mold as incomplete, move off all molds,
     * discharge any prepared paste, and flush the processing area with water.
     */
    public void shutDown() {
        if (inProcess()) {
            stopProcessing();
            moldIncompleteHook.execute(this);
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

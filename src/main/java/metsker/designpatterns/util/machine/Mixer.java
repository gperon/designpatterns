/*
 * @(#)Mixer.java   2011-11-01
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



package metsker.designpatterns.util.machine;

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
 * A mixer mixes chemicals.
 *
 * @author Steven J. Metsker
 *
 */
public class Mixer extends Machine {

    /**
     * Create a mixer with the given id and with the supplied parent machine.
     *
     * @param id
     *            the identity of this mixer
     * @param parent
     *            the composite this machine belongs to
     */
    public Mixer(int id, MachineComponent parent) {
        super(id, parent);
    }

    /**
     * Create a mixer with the given id.
     *
     * @param id
     *            the identity of this mixer
     */
    public Mixer(int id) {
        super(id);
    }

    /**
     * Create a mixer with the given id and with access to the mediator that
     * will control bin/machine relations.
     *
     * @param id
     *            the identity of this mixer
     * @param Mediator
     *            the mediator that controls this machine's relation to bins
     */
    protected Mixer(int id, TubMediator mediator) {
        this(id, mediator, null);
    }

    /**
     * Create a mixer with the given id, with access to the mediator that will
     * control bin/machine relations, and with the supplied parent machine.
     *
     * @param id
     *            the identity of this mixer
     * @param mediator
     * @param parent
     *            the composite this machine belongs to
     */
    public Mixer(int id, TubMediator mediator, MachineComponent parent) {
        super(id, mediator, parent);
    }
}

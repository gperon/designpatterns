/*
 * @(#)AmbitiousMenu.java   2011-11-01
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
 * This (dysfunctional) class shows a method from an overly ambitious menu that
 * figures out who the responsible engineer is for a piece of equipment. In the
 * "Chain of Responsibility" chapter of "Design Patterns in Java," this code is
 * refactored so that the domain objects determine who is the responsible
 * engineer.
 */
public class AmbitiousMenu {

    /**
     * @param item The interesting item
     * @return The engineer who is responsible for item
     */
    public Engineer getResponsible(VisualizationItem item) {
        if (item instanceof Tool) {
            Tool t = (Tool) item;

            return t.getToolCart().getResponsible();
        }
        if (item instanceof ToolCart) {
            ToolCart tc = (ToolCart) item;

            return tc.getResponsible();
        }
        if (item instanceof MachineComponent) {
            MachineComponent c = (MachineComponent) item;
            if (c.getResponsible() != null) {
                return c.getResponsible();
            }
            if (c.getParent() != null) {
                return c.getParent().getResponsible();
            }
        }

        return null;
    }
}

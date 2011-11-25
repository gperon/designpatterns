/*
 * @(#)PricingVisitor.java   2011-11-01
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



package gamma.designpatterns.behavioral.visitor;

import gamma.designpatterns.structural.composite.Bus;
import gamma.designpatterns.structural.composite.Card;
import gamma.designpatterns.structural.composite.Chassis;
import gamma.designpatterns.structural.composite.FloppyDisk;

/**
 *  <p>
 *
 *  Title: </p> <p>
 *
 *  Description: Design Patterns Examples</p> <p>
 *
 *  Copyright: Copyright (c) 2003</p> <p>
 *
 *  Company: GioPerLab</p>
 *
 * @author     giorgio_peron@libero.it
 * @created    8 marzo 2003
 * @version    1.0
 */
public class PricingVisitor implements EquipmentVisitor {
    double total;

    /**
     *  Constructor for the PricingVisitor object
     */
    public PricingVisitor() {}

    /**
     *  Description of the Method
     *
     * @param  floppy  Description of the Parameter
     */
    public void visitFloppyDisk(FloppyDisk floppy) {
        total += floppy.netPrice();
    }

    /**
     *  Description of the Method
     *
     * @param  card  Description of the Parameter
     */
    public void visitCard(Card card) {
        total += card.netPrice();
    }

    /**
     *  Description of the Method
     *
     * @param  chassis  Description of the Parameter
     */
    public void visitChassis(Chassis chassis) {
        total += chassis.discountPrice();
    }

    /**
     *  Description of the Method
     *
     * @param  bus  Description of the Parameter
     */
    public void visitBus(Bus bus) {
        total += bus.netPrice();
    }

    /**
     *  Gets the total attribute of the PricingVisitor object
     *
     * @return    The total value
     */
    public double getTotal() {
        return total;
    }
}

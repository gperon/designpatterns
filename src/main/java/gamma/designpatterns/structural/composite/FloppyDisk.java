/*
 * @(#)FloppyDisk.java   2011-11-01
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



package gamma.designpatterns.structural.composite;

import gamma.designpatterns.behavioral.visitor.EquipmentVisitor;

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
public class FloppyDisk extends AbstractEquipment {

    /**
     *  Constructor for the FloppyDisk object
     *
     * @param  name  Description of the Parameter
     */
    public FloppyDisk(String name) {
        super(name);
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public int power() {
        return 10;
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public double netPrice() {
        return 20.0d;
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public double discountPrice() {
        return 18.0d;
    }

    /**
     *  Description of the Method
     *
     * @param  visitor  Description of the Parameter
     */
    public void accept(EquipmentVisitor visitor) {
        visitor.visitFloppyDisk(this);
    }
}

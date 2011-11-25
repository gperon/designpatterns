/*
 * @(#)CompositeEquipment.java   2011-11-01
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

import java.util.*;

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
public abstract class CompositeEquipment extends AbstractEquipment {
    private List<Equipment> equipments;

    /**
     *  Constructor for the CompositeEquipment object
     *
     * @param  name  Description of the Parameter
     */
    public CompositeEquipment(String name) {
        super(name);
        this.equipments = new ArrayList();
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public List<Equipment> getEquipments() {
        return equipments;
    }

    /**
     *  Description of the Method
     *
     * @param  equipment  Description of the Parameter
     */
    public void add(Equipment equipment) {
        equipments.add(equipment);
    }

    /**
     *  Description of the Method
     *
     * @param  equipment  Description of the Parameter
     */
    public void remove(Equipment equipment) {
        equipments.remove(equipment);
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public int power() {
        int tot = 0;
        for (Equipment e : equipments) {
            tot += e.power();
        }

        return tot;
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public double discountPrice() {
        double tot = 0;
        for (Equipment e : equipments) {
            tot += e.discountPrice();
        }

        return tot;
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public double netPrice() {
        double tot = 0;
        for (Equipment e : equipments) {
            tot += e.netPrice();
        }

        return tot;
    }
}

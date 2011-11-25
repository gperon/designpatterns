/*
 * @(#)ShowComparator.java   2011-11-01
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
import java.util.Arrays;

import metsker.designpatterns.util.firework.Rocket;
import metsker.designpatterns.util.Dollars;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class ShowComparator {

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String args[]) {
        Rocket r1 = new Rocket("Sock-it", 0.8, new Dollars(11.95), 320, 25);
        Rocket r2 = new Rocket("Sprocket", 1.5, new Dollars(22.95), 270, 40);
        Rocket r3 = new Rocket("Mach-it", 1.1, new Dollars(22.95), 1000, 70);
        Rocket r4 = new Rocket("Pocket", 0.3, new Dollars(4.95), 150, 20);
        Rocket[] rockets = new Rocket[] { r1, r2, r3, r4 };
        System.out.println("Sorted by apogee: ");
        Arrays.sort(rockets, new ApogeeComparator());
        for (int i = 0; i < rockets.length; i++) {
            System.out.println(rockets[i]);
        }
        System.out.println();
        System.out.println("Sorted by name: ");
        Arrays.sort(rockets, new NameComparator());
        for (int i = 0; i < rockets.length; i++) {
            System.out.println(rockets[i]);
        }
    }
}

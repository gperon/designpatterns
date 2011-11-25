/*
 * @(#)NameBase.java   2011-11-01
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



package metsker.designpatterns.behavioral.mediator;

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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class NameBase {
    private List boxes;
    private Hashtable tubMachine;

    /**
     * Method description
     *
     *
     * @return
     */
    public Object[] boxes() {
        if (boxes == null) {
            boxes = new ArrayList();
            boxes.add("Mixer-2201");
            boxes.add("Mixer-2202");
            boxes.add("Fuser-2101");
            boxes.add("StarPress-2401");
            boxes.add("StarPress-2402");
            boxes.add("Assembler-2301");
        }

        return boxes.toArray();
    }

    private Hashtable tubMachine() {
        if (tubMachine == null) {
            tubMachine = new Hashtable();
            tubMachine.put("T502", "Mixer-2201");
            tubMachine.put("T503", "Mixer-2201");
            tubMachine.put("T504", "Mixer-2201");
            tubMachine.put("T101", "StarPress-2402");
            tubMachine.put("T102", "StarPress-2402");
        }

        return tubMachine;
    }

    /**
     * Method description
     *
     *
     * @param machineName
     *
     * @return
     */
    public Object[] tubNames(String machineName) {
        ArrayList result = new ArrayList();
        Enumeration iter = this.tubMachine().keys();
        while (iter.hasMoreElements()) {
            String key = iter.nextElement().toString();
            String value = getMachineContaining(key);
            if (value.equals(machineName)) {
                result.add(key);
            }
        }

        return result.toArray();
    }

    /**
     * Method description
     *
     *
     * @param tubName
     *
     * @return
     */
    public String getMachineContaining(String tubName) {
        return (String) tubMachine().get(tubName);
    }

    /**
     * Method description
     *
     *
     * @param tubName
     * @param toMachineName
     */
    public void put(String tubName, String toMachineName) {
        tubMachine().put(tubName, toMachineName);
    }
}

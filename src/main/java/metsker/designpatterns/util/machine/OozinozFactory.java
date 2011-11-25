/*
 * @(#)OozinozFactory.java   2011-11-01
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
 * This class provides object models of a few of Oozinoz's factories, in terms
 * of the factories' machines.
 */
public class OozinozFactory {

    /**
     * @return a model of the machines in our Dublin facility.
     */
    public static MachineComposite dublin() {
        MachineRoot root = new MachineRoot(0, new Engineer(4096));
        root.setName(" Factory Dublin");
        TubMediator m = new TubMediator();
        root.add(line1(m, root));
        root.add(line2(m, root));
        root.add(line3(m, root));

        return root;
    }

    /**
     *
     * @param m
     * @param parent
     * @return a sample manufacturing line
     */
    public static MachineComposite line1(TubMediator m, MachineComposite parent) {
        MachineComposite c = new MachineComposite(1000, parent);
        c.setName("Line 1");
        c.add(new Machine[] { new Mixer(1201, m, c), new StarPress(1401, m, c),
                              new ShellAssembler(1301, m, c), new Fuser(1101, m, c) });

        return c;
    }

    /**
     *
     * @param m
     * @param parent
     * @return a second sample manufacturing line
     */
    public static MachineComposite line2(TubMediator m, MachineComposite parent) {
        MachineComposite c = new MachineComposite(2000, parent);
        c.setName("Line 2");
        c.add(new Machine[] {
            new Mixer(2201, m, c), new Mixer(2202, m, c), new StarPress(2401, m, c),
            new StarPress(2402, m, c), new ShellAssembler(2301, m, c), new Fuser(2101, m, c)
        });

        return c;
    }

    /**
     *
     * @param m
     * @param parent
     * @return a third sample manufacturing line
     */
    public static MachineComposite line3(TubMediator m, MachineComposite parent) {
        MachineComposite c = new MachineComposite(3000, parent);
        c.setName("Line 3");
        c.add(new Machine[] {
            new Mixer(3201, m, c), new Mixer(3202, m, c), new Mixer(3203, m, c),
            new Mixer(3204, m, c), new StarPress(3401, m, c), new StarPress(3402, m, c),
            new StarPress(3403, m, c), new StarPress(3404, m, c), new ShellAssembler(3301, m, c),
            new ShellAssembler(3302, m, c), new Fuser(3101, m, c), new Fuser(3102, m, c)
        });

        return c;
    }

    /**
     * @return a plant (a factory) that is not a tree.
     */
    public static MachineComposite plant() {
        MachineComposite plant = new MachineComposite(100);
        MachineComposite bay = new MachineComposite(101);
        Machine mixer = new Mixer(102);
        Machine press = new StarPress(103);
        Machine assembler = new ShellAssembler(104);
        bay.add(mixer);
        bay.add(press);
        bay.add(assembler);
        plant.add(mixer);
        plant.add(bay);

        return plant;
    }
}

/*
 * @(#)ShowConcurrentMutex.java   2011-11-01
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



package metsker.designpatterns.behavioral.iterator;

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
import java.util.*;

/**
 * Show a "synchronized" list with iteration over the list.
 */
public class ShowConcurrentMutex implements Runnable {
    private List list;

    protected static List upMachineNames() {
        return new ArrayList(Arrays.asList(new String[] { "Mixer1201", "ShellAssembler1301",
                "StarPress1401", "UnloadBuffer1501" }));
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        new ShowConcurrentMutex().go();
    }

    protected void go() {
        System.out.println("This version synchronizes properly:");
        list = Collections.synchronizedList(upMachineNames());
        synchronized (list) {
            display();
        }
    }

    private void display() {
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {    // simulate wake-up
                new Thread(this).start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }
            System.out.println(list.get(i));
        }
    }

    /**
     * * Insert an element in the list, in a separate thread.
     */
    public void run() {
        synchronized (list) {
            list.add(0, "Fuser1101");
        }
    }
}

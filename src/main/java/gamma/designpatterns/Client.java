/*
 * @(#)Client.java   2011-11-01
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



package gamma.designpatterns;

import gamma.designpatterns.behavioral.BehavioralClient;
import gamma.designpatterns.creational.CreationalClient;
import gamma.designpatterns.structural.StructuralClient;

import java.io.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class Client {
    static final char CREATIONAL = '1';
    static final char STRUCTURAL = '2';
    static final char BEHAVIORAL = '3';
    static BufferedReader input;

    static char showMenu() {
        String s;
        System.out.println("*** Design Patterns Examples ***");
        System.out.println("1) Creational");
        System.out.println("2) Structural");
        System.out.println("3) Behavioral");
        System.out.println("");
        System.out.println("Press q to quit");
        System.out.println("");
        System.out.print("-> ");
        System.out.flush();
        if (input == null) {
            input = new BufferedReader(new InputStreamReader(System.in));
        }
        try {
            s = input.readLine();
        } catch (IOException e) {
            return 'q';
        }
        if (s.length() > 0) {
            return s.charAt(0);
        } else {
            return (char) 0;
        }
    }

    static void startCreationalExample() {
        new CreationalClient().main(null);
    }

    static void startStructuralExample() {
        new StructuralClient().main(null);
    }

    static void startBehavioralExample() {
        new BehavioralClient().main(null);
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String args[]) {
        int choice;
        System.out.println("The purpose of this program is to demonstrate design patterns issues.");
        System.out.println("");
        while (true) {
            switch (showMenu()) {
                case CREATIONAL :
                    startCreationalExample();

                    break;

                case STRUCTURAL :
                    startStructuralExample();

                    break;

                case BEHAVIORAL :
                    startBehavioralExample();

                    break;

                case 'q' :
                    System.exit(1);
                default :
                    break;
            }
        }
    }
}

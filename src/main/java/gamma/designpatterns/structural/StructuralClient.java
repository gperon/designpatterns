/*
 * @(#)StructuralClient.java   2011-11-01
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



package gamma.designpatterns.structural;

import gamma.designpatterns.structural.adapter.AnotherTextView;
import gamma.designpatterns.structural.adapter.Manipulator;
import gamma.designpatterns.structural.adapter.Shape;
import gamma.designpatterns.structural.adapter.TextShape;
import gamma.designpatterns.structural.adapter.TextShapeComposition;
import gamma.designpatterns.structural.adapter.TextView;
import gamma.designpatterns.structural.bridge.ContentView;
import gamma.designpatterns.structural.bridge.IconWindow;
import gamma.designpatterns.structural.bridge.TransientWindow;
import gamma.designpatterns.structural.bridge.View;
import gamma.designpatterns.structural.bridge.Window;
import gamma.designpatterns.structural.composite.Bus;
import gamma.designpatterns.structural.composite.Cabinet;
import gamma.designpatterns.structural.composite.Card;
import gamma.designpatterns.structural.composite.Chassis;
import gamma.designpatterns.structural.composite.CompositeEquipment;
import gamma.designpatterns.structural.composite.FloppyDisk;
import gamma.designpatterns.structural.decorator.BorderDecorator;
import gamma.designpatterns.structural.decorator.ScrollDecorator;
import gamma.designpatterns.structural.facade.BytecodeStream;
import gamma.designpatterns.structural.proxy.ShowProxy;

import java.io.*;

/**
 *  <p>
 *
 *  Title: Design Patterns</p> <p>
 *
 *  Description: </p> <p>
 *
 *  Copyright: Copyright (c) 2002</p> <p>
 *
 *  Company: GioPerLab</p>
 *
 * @author     giorgio_peron@libero.it
 * @created    2 giugno 2002
 * @version    1.0
 */
public class StructuralClient {
    static final char ADAPTER = '1';
    static final char BRIDGE = '2';
    static final char COMPOSITE = '3';
    static final char FACADE = '4';
    static final char DECORATOR = '5';
    static final char FLYWEIGHT = '6';
    static final char PROXY = '7';
    static BufferedReader input;

    /**
     *  A unit test for JUnit
     */
    private static void testAdapter() {

        /* Drawing editor */
        Shape s = new TextShape();
        System.out.println(s);
        Manipulator m = s.createManipulator();
        m.move(5, 3);
        System.out.println(s);
        s = new TextShapeComposition(new AnotherTextView());
        System.out.println(s);
        m = s.createManipulator();
        m.move(10, 2);
        System.out.println(s);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testBridge() {
        // new ProductDisplay();
        View view = new ContentView();
        Window iconX = new IconWindow(view);
        iconX.setSys("X");
        iconX.getWindowImp();
        System.out.println(iconX);
        Window iconPM = new IconWindow(view);
        iconPM.setSys("PM");
        iconPM.getWindowImp();
        System.out.println(iconPM);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testComposite() {
        CompositeEquipment cabinet = new Cabinet("PC Cabinet");
        CompositeEquipment chassis = new Chassis("PC Chassis");
        cabinet.add(chassis);
        CompositeEquipment bus = new Bus("MCA Bus");
        bus.add(new Card("16Mbs Token Ring"));
        chassis.add(bus);
        chassis.add(new FloppyDisk("3.5in Floppy"));
        System.out.println("The net price is " + cabinet.netPrice());
    }

    /**
     *  A unit test for JUnit
     */
    private static void testDecorator() {
        TextView textView = new TextView();
        Window window = new TransientWindow(textView);
        System.out.println(window);
        System.out.println("without decoration");
        window.drawContents();
        window.setContents(new BorderDecorator(new ScrollDecorator(textView), 1));
        System.out.println("\nwith decoration");
        window.drawContents();
        System.out.println("");
    }

    /**
     *  A unit test for JUnit
     */
    private static void testFacade() {
        try {
            byte[] buffer = new byte[1024];
            new FileInputStream("src/java/designpatterns/structural/facade/source.txt").read(
                buffer);
            InputStream is = new ByteArrayInputStream(buffer);
            BytecodeStream bs = new BytecodeStream();
            gamma.designpatterns.structural.facade.Compiler compiler =
                new gamma.designpatterns.structural.facade.Compiler();
            compiler.compile(is, bs);
            System.out.println(bs.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     *  A unit test for JUnit
     */
    private static void testFlyweight() {}

    /**
     *  A unit test for JUnit
     */
    private static void testProxy() {
        new ShowProxy().main(null);

        /*
         *          TextDocument text = new TextDocument();
         *          text.insert(new ImageProxy("anImageFileName"));
         */
    }

    /**
     *  The main program for the CreationalClient class
     *
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            switch (showMenu()) {
                case ADAPTER :
                    testAdapter();

                    break;

                case BRIDGE :
                    testBridge();

                    break;

                case COMPOSITE :
                    testComposite();

                    break;

                case FACADE :
                    testFacade();

                    break;

                case DECORATOR :
                    testDecorator();

                    break;

                case FLYWEIGHT :
                    testFlyweight();

                    break;

                case PROXY :
                    testProxy();

                    break;

                case 'q' :
                    System.exit(1);
                case '0' :
                    return;

                default :
                    break;
            }
        }
    }

    static char showMenu() {
        String s;
        System.out.println("*** Design Patterns Examples - Structural ***");
        System.out.println("0) Back");
        System.out.println("");
        System.out.println("1) Adapter");
        System.out.println("2) Bridge");
        System.out.println("3) Composite");
        System.out.println("4) Facade");
        System.out.println("5) Decorator");
        System.out.println("6) Flyweight");
        System.out.println("7) Proxy");
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
}

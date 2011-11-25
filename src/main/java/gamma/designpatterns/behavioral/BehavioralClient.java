/*
 * @(#)BehavioralClient.java   2011-11-01
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



package gamma.designpatterns.behavioral;

//import designpatterns.behavioral.iterator.*;
import gamma.designpatterns.behavioral.chainofresponsibility.*;
import gamma.designpatterns.behavioral.command.*;
import gamma.designpatterns.behavioral.interpreter.*;
import gamma.designpatterns.behavioral.iterator.*;
import gamma.designpatterns.behavioral.observer.*;
import gamma.designpatterns.behavioral.state.*;
import gamma.designpatterns.behavioral.strategy.*;
import gamma.designpatterns.behavioral.visitor.*;
import gamma.designpatterns.structural.composite.*;

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
public class BehavioralClient {

    /**
     *  Constructor for the BehavioralClient object
     */
    public BehavioralClient() {}

    static BufferedReader input;

    /**
     *  A unit test for JUnit
     */
    private static void testChainOfResponsibility() {
        gamma.designpatterns.behavioral.chainofresponsibility.Application application =
            new gamma.designpatterns.behavioral.chainofresponsibility.Application(
                Topic.APPLICATION_TOPIC);
        Dialog dialog = new Dialog(application, Topic.PRINT_TOPIC);
        gamma.designpatterns.behavioral.chainofresponsibility.Button button =
            new gamma.designpatterns.behavioral.chainofresponsibility.Button(dialog,
                Topic.PAPER_ORIENTATION_TOPIC);
        button.handleHelp();
        dialog.handleHelp();
        application.handleHelp();
    }

    /**
     *  A unit test for JUnit
     */
    private static void testCommand() {
        gamma.designpatterns.behavioral.command.Application appl =
            new gamma.designpatterns.behavioral.command.Application();
        Document docA = new Document("pippo.txt");
        Document docB = new Document("pluto.txt");
        MacroCommand cmds = new MacroCommand();
        cmds.add(new OpenCommand(appl));
        cmds.add(new PasteCommand(docA));
        cmds.add(new PasteCommand(docB));
        cmds.execute();
    }

    /**
     *  A unit test for JUnit
     */
    private static void testInterpreter() {
        BooleanExp expression;
        Context context = Context.instance();
        VariableExp x = new VariableExp("X");
        VariableExp y = new VariableExp("Y");
        expression = new OrExp(new AndExp(new Constant(true), x), new AndExp(y, new NotExp(x)));
        context.assign(x, false);
        context.assign(y, true);
        boolean result = expression.evaluate(context);
        System.out.println("result: " + result);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testIterator() {
        List<gamma.designpatterns.behavioral.iterator.Employee> l =
            new List<gamma.designpatterns.behavioral.iterator.Employee>(4);
        l.append(new gamma.designpatterns.behavioral.iterator.Employee("John"));
        l.append(new gamma.designpatterns.behavioral.iterator.Employee("Peter"));
        l.append(new gamma.designpatterns.behavioral.iterator.Employee("Paul"));
        l.append(new gamma.designpatterns.behavioral.iterator.Employee("Samantha"));
        Iterator i = l.iterator();
        for (i.first(); !i.isDone(); i.next()) {
            System.out.println("Employee: " + i.currentItem());
        }
    }

    /**
     *  A unit test for JUnit
     */
    private static void testMediator() {}

    /**
     *  A unit test for JUnit
     */
    private static void testMemento() {}

    /**
     *  A unit test for JUnit
     */
    private static void testObserver() {
        ClockTimer timer = new ClockTimer();
        DigitalClock digital = new DigitalClock(timer);
        AnalogClock analog = new AnalogClock(timer);
        timer.tick();
    }

    /**
     *  A unit test for JUnit
     */
    private static void testState() {
        new ShowCarousel().main(null);
    }

    /**
     *  A unit test for JUnit
     */
    private static void testStrategy() {
        try {
            new Customer().main(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Composition quick = new Composition(new SimpleCompositor());
        Composition slick = new Composition(new TeXCompositor());
        Composition iconic = new Composition(new ArrayCompositor(100));
    }

    /**
     *  A unit test for JUnit
     */
    private static void testTemplateMethod() {}

    /**
     *  A unit test for JUnit
     */
    private static void testVisitor() {
        CompositeEquipment cabinet = new Cabinet("PC Cabinet");
        CompositeEquipment chassis = new Chassis("PC Chassis");
        cabinet.add(chassis);
        CompositeEquipment bus = new Bus("MCA Bus");
        bus.add(new Card("16Mbs Token Ring"));
        bus.add(new Card("16Mbs Token Ring"));
        chassis.add(bus);
        chassis.add(new FloppyDisk("3.5in Floppy"));
        chassis.add(new FloppyDisk("3.5in Floppy"));
        chassis.add(new FloppyDisk("3.5in Floppy"));
        InventoryVisitor visitor = new InventoryVisitor();
        cabinet.accept(visitor);
        System.out.println("Inventory " + cabinet.name() + " " + visitor.getInventory());
        PricingVisitor newVisitor = new PricingVisitor();
        cabinet.accept(newVisitor);
        System.out.println("Pricing " + cabinet.name() + " " + newVisitor.getTotal());
    }

    /**
     *  The main program for the CreationalClient class
     *
     * @param  args  The command line arguments
     */
    public static void main(String[] args) {
        switch (showMenu()) {
            case '1' :
                testChainOfResponsibility();

                break;

            case '2' :
                testCommand();

                break;

            case '3' :
                testInterpreter();

                break;

            case '4' :
                testIterator();

                break;

            case '5' :
                testMediator();

                break;

            case '6' :
                testMemento();

                break;

            case '7' :
                testObserver();

                break;

            case '8' :
                testState();

                break;

            case '9' :
                testStrategy();

                break;

            case 10 :
                testTemplateMethod();

                break;

            case 11 :
                testVisitor();

                break;

            case 'q' :
                System.exit(1);
            case '0' :
                return;

            default :
                break;
        }
    }

    static char showMenu() {
        String s;
        System.out.println("*** Design Patterns Examples - Behavioral ***");
        System.out.println(" 0) Back");
        System.out.println("");
        System.out.println(" 1) Chain of Responsability");
        System.out.println(" 2) Command");
        System.out.println(" 3) Interpreter");
        System.out.println(" 4) Iterator");
        System.out.println(" 5) Mediator");
        System.out.println(" 6) Memento");
        System.out.println(" 7) Observer");
        System.out.println(" 8) State");
        System.out.println(" 9) Strategy");
        System.out.println("10) Template Method");
        System.out.println("11) Visitor");
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

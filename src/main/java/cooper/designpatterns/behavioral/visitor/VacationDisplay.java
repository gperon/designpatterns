/*
 * @(#)VacationDisplay.java   2011-11-01
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



package cooper.designpatterns.behavioral.visitor;

import cooper.designpatterns.util.swing.JxFrame;
import cooper.designpatterns.structural.adapter.JawtList;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class VacationDisplay extends JxFrame implements ActionListener {
    JawtList empList;
    JTextField total, btotal;
    JButton Vac;
    Employee[] employees;

    /**
     * Constructs ...
     *
     */
    public VacationDisplay() {
        super("Vacation Display");
        JPanel jp = new JPanel();
        getContentPane().add(jp);
        jp.setLayout(new GridLayout(1, 2));
        empList = new JawtList(10);
        jp.add(empList);
        createEmployees();
        Box box = Box.createVerticalBox();
        jp.add(box);
        total = new JTextField(5);
        total.setHorizontalAlignment(JTextField.CENTER);
        box.add(total);
        box.add(Box.createVerticalStrut(10));
        btotal = new JTextField(5);
        btotal.setHorizontalAlignment(JTextField.CENTER);
        box.add(btotal);
        box.add(Box.createVerticalStrut(10));
        Vac = new JButton("Vacations");
        box.add(Vac);
        Vac.addActionListener(this);
        setSize(300, 200);
        setVisible(true);
        total.setText("  ");
        total.setBackground(Color.white);
        total.setEditable(false);
    }

    /**
     * Method description
     *
     */
    public void createEmployees() {
        employees = new Employee[7];
        int i = 0;
        employees[i++] = new Employee("Susan Bear", 55000, 12, 1);
        employees[i++] = new Employee("Adam Gehr", 150000, 9, 0);
        employees[i++] = new Employee("Fred Harris", 50000, 15, 2);
        employees[i++] = new Employee("David Oakley", 57000, 12, 2);
        employees[i++] = new Employee("Larry Thomas", 100000, 20, 6);
        Boss b = new Boss("Leslie Susi", 175000, 16, 4);
        b.setBonusDays(12);
        Boss b1 = new Boss("Laurence Byerly", 35000, 17, 6);
        b1.setBonusDays(17);
        employees[i++] = b;
        employees[i++] = b1;
        for (i = 0; i < employees.length; i++) {
            empList.add(employees[i].getName());
        }
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        VacationVisitor vac = new VacationVisitor();
        BonusVacationVisitor bvac = new BonusVacationVisitor();
        for (int i = 0; i < employees.length; i++) {
            employees[i].accept(vac);
            employees[i].accept(bvac);
        }
        total.setText(new Integer(vac.getTotalDays()).toString());
        btotal.setText(new Integer(bvac.getTotalDays()).toString());
    }

    /**
     * Method description
     *
     *
     * @param argv
     */
    static public void main(String argv[]) {
        new VacationDisplay();
    }
}

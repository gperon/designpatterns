/*
 * @(#)Employee.java   2011-11-01
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



package cooper.designpatterns.structural.composite;

import java.util.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Employee {
    String name;
    float salary;
    Vector subordinates;
    boolean isLeaf;
    Employee parent = null;

    /**
     * Constructs ...
     *
     *
     * @param _name
     * @param _salary
     */
    public Employee(String _name, float _salary) {
        name = _name;
        salary = _salary;
        subordinates = new Vector();
        isLeaf = false;
    }

    /**
     * Constructs ...
     *
     *
     * @param _parent
     * @param _name
     * @param _salary
     */
    public Employee(Employee _parent, String _name, float _salary) {
        name = _name;
        salary = _salary;
        parent = _parent;
        subordinates = new Vector();
        isLeaf = false;
    }

    /**
     * Method description
     *
     *
     * @param b
     */
    public void setLeaf(boolean b) {
        isLeaf = b;    // if true, do not allow children
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method description
     *
     *
     * @param e
     *
     * @return
     */
    public boolean add(Employee e) {
        if (!isLeaf) {
            subordinates.addElement(e);
        }

        return isLeaf;    // false if unsuccessful
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void remove(Employee e) {
        if (!isLeaf) {
            subordinates.removeElement(e);
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Enumeration elements() {
        return subordinates.elements();
    }

    /**
     * Method description
     *
     *
     * @param s
     *
     * @return
     */
    public Employee getChild(String s) {
        Employee newEmp = null;
        if (getName().equals(s)) {
            return this;
        } else {
            boolean found = false;
            Enumeration e = elements();
            while (e.hasMoreElements() && (!found)) {
                newEmp = (Employee) e.nextElement();
                found = newEmp.getName().equals(s);
                if (!found) {
                    newEmp = newEmp.getChild(s);
                    found = (newEmp != null);
                }
            }
            if (found) {
                return newEmp;
            } else {
                return null;
            }
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public float getSalaries() {
        float sum = salary;
        for (int i = 0; i < subordinates.size(); i++) {
            sum += ((Employee) subordinates.elementAt(i)).getSalaries();
        }

        return sum;
    }
}

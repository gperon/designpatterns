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



package gamma.designpatterns.structural.composite;

import java.util.*;

/**
 *  Description of the Class
 *
 * @author     giorgio
 * @created    9 giugno 2002
 */
public class Employee {
    String name;
    float salary;
    List<Employee> subordinates;
    boolean isLeaf;
    Employee parent = null;

    /**
     *  Constructor for the Employee object
     *
     * @param  name    Description of the Parameter
     * @param  salary  Description of the Parameter
     */
    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
        subordinates = new ArrayList();
        isLeaf = false;
    }

    /**
     *  Constructor for the Employee object
     *
     * @param  parent  Description of the Parameter
     * @param  name    Description of the Parameter
     * @param  salary  Description of the Parameter
     */
    public Employee(Employee parent, String name, float salary) {
        this(name, salary);
        this.parent = parent;
    }

    /**
     *  Sets the leaf attribute of the Employee object
     *
     * @param  b  The new leaf value
     */
    public void setLeaf(boolean b) {
        isLeaf = b;
        // if true, do not allow children
    }

    /**
     *  Gets the salary attribute of the Employee object
     *
     * @return    The salary value
     */
    public float getSalary() {
        return salary;
    }

    /**
     *  Gets the name attribute of the Employee object
     *
     * @return    The name value
     */
    public String getName() {
        return name;
    }

    /**
     *  Description of the Method
     *
     * @param  e  Description of the Parameter
     * @return    Description of the Return Value
     */
    public boolean add(Employee e) {
        if (!isLeaf) {
            subordinates.add(e);
        }

        return isLeaf;
        // false if unsuccessful
    }

    /**
     *  Description of the Method
     *
     * @param  e  Description of the Parameter
     */
    public void remove(Employee e) {
        if (!isLeaf) {
            subordinates.remove(e);
        }
    }

    /**
     *  Description of the Method
     *
     * @return    Description of the Return Value
     */
    public List<Employee> elements() {
        return subordinates;
    }

    /**
     *  Gets the child attribute of the Employee object
     *
     * @param  s  Description of the Parameter
     * @return    The child value
     */
    public Employee getChild(String s) {
        Employee newEmp = null;
        if (getName().equals(s)) {
            return this;
        } else {
            boolean found = false;
            for (Employee e : subordinates) {
                newEmp = e;
                found = newEmp.getName().equals(s);
                if (!found) {
                    newEmp = newEmp.getChild(s);
                    found = (newEmp != null);
                }
                if (found) {
                    return newEmp;
                }
            }

            return null;
        }
    }

    /**
     *  Gets the salaries attribute of the Employee object
     *
     * @return    The salaries value
     */
    public float getSalaries() {
        float sum = salary;
        for (Employee e : subordinates) {
            sum += e.getSalaries();
        }

        return sum;
    }
}

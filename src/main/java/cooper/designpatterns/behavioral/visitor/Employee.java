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



package cooper.designpatterns.behavioral.visitor;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Employee {
    int sickDays, vacDays;
    float salary;
    String name;

    /**
     * Constructs ...
     *
     *
     * @param name
     * @param salary
     * @param vacdays
     * @param sickdays
     */
    public Employee(String name, float salary, int vacdays, int sickdays) {
        vacDays = vacdays;
        sickDays = sickdays;
        this.salary = salary;
        this.name = name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getSickdays() {
        return sickDays;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getVacDays() {
        return vacDays;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public float getSalary() {
        return this.salary;
    }

    /**
     * Method description
     *
     *
     * @param v
     */
    public void accept(Visitor v) {
        v.visit(this);
    }
}

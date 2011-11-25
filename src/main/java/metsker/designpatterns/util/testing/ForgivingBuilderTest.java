/*
 * @(#)ForgivingBuilderTest.java   2011-11-01
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



package metsker.designpatterns.util.testing;

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
import java.text.ParseException;

import java.util.Date;

import junit.framework.TestCase;

import metsker.designpatterns.creational.builder.BuilderException;
import metsker.designpatterns.creational.builder.ForgivingBuilder;
import metsker.designpatterns.creational.builder.Reservation;
import metsker.designpatterns.creational.builder.ReservationBuilder;
import metsker.designpatterns.creational.builder.ReservationParser;
import metsker.designpatterns.util.Dollars;

/**
 *  Test that a forgiving builder builds correctly.
 */
public class ForgivingBuilderTest extends TestCase {
    Date nextNov5;

    /**
     * Method description
     *
     */
    public void setUp() {
        // Pick a date definitely in the past: 11-5-2000
        nextNov5 = ReservationBuilder.futurize(new Date(2000 - 1900, 11 - 1, 5));
    }

    /**
     *  Test that we disallow a too low figure for dollars/head.
     *
     * @throws ParseException
     */
    public void testLowDollars() throws ParseException {
        String s = "Date, November 5, Headcount, 250, "
                   + "City, Springfield, DollarsPerHead, 1.95, " + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();    // should throw an exception
            fail("Should throw a BuilderException");
        } catch (BuilderException expected) {}
    }

    /**
     *  Test that we disallow a too low figure for headcount.
     *
     * @throws ParseException
     */
    public void testLowHeadCount() throws ParseException {
        String s = "Date, November 5, Headcount, 2, " + "City, Springfield, DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();    // should throw an exception
            fail("Should throw a BuilderException");
        } catch (BuilderException expected) {}
    }

    /**
     *  Test that we disallow a missing city.
     *
     * @throws ParseException
     */
    public void testNoCity() throws ParseException {
        String s = "Date, November 5, Headcount, 250, " + "DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();    // should throw an exception
            fail("Should throw a BuilderException");
        } catch (BuilderException expected) {}
    }

    /**
     *  Test that we disallow a missing date.
     *
     * @throws ParseException
     */
    public void testNoDate() throws ParseException {
        String s = "Headcount, 250, " + "City, Springfield, DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new ForgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();    // should throw an exception
            fail("Should throw a BuilderException");
        } catch (BuilderException expected) {}
    }

    /**
     *  Test that if there is a headcount but no dollars/head value,
     *  set the dollars/head value to be high enough to generate
     *  the minimum take.
     *
     * @throws BuilderException
     * @throws ParseException
     */
    public void testNoDollar() throws BuilderException, ParseException {
        String s = "Date, November 5, Headcount, 250, City, Springfield, " + "  HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        assertEquals(nextNov5, r.getDate());
        assertEquals(250, r.getHeadcount());
        Dollars price = r.getDollarsPerHead().times(r.getHeadcount());
        assertFalse(price.isLessThan(ReservationBuilder.MINTOTAL));
        assertEquals("Springfield", r.getCity());
        assertFalse(r.hasSite());
    }

    /**
     *  Test that if there is no headcount but there is a dollars/head value,
     *  set the headcount to be at least the minimum attendance and at least
     *  enough to generate enough money for the event.
     *
     * @throws BuilderException
     * @throws ParseException
     */
    public void testNoHeadcount() throws BuilderException, ParseException {
        String s = "Date, November 5,   City, Springfield, "
                   + "DollarsPerHead, 9.95, HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        assertEquals(nextNov5, r.getDate());
        assertTrue(r.getHeadcount() >= ReservationBuilder.MINHEAD);
        Dollars price = r.getDollarsPerHead().times(r.getHeadcount());
        assertFalse(price.isLessThan(ReservationBuilder.MINTOTAL));
        assertEquals("Springfield", r.getCity());
        assertEquals(new Dollars(9.95), r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }

    /**
     *  Test that if the reservation request specifies no headcount and no
     *  dollars/head, set the headcount to the minimum and set dollars/head
     *  to the minimum total divided by the headcount.
     *
     * @throws BuilderException
     * @throws ParseException
     */
    public void testNoHeadcountNoDollar() throws BuilderException, ParseException {
        String s = "Date, November 5,   City, Springfield, " + "  HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        assertEquals(nextNov5, r.getDate());
        assertEquals(ReservationBuilder.MINHEAD, r.getHeadcount());
        assertEquals("Springfield", r.getCity());
        assertEquals(ReservationBuilder.MINTOTAL.dividedBy(r.getHeadcount()),
                     r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }

    /**
     *  Test a normal reservation.
     *
     * @throws BuilderException
     * @throws ParseException
     */
    public void testNormal() throws BuilderException, ParseException {
        String s = "Date, November 5, Headcount, 250, City, Springfield, "
                   + "DollarsPerHead, 9.95, HasSite, false";
        ForgivingBuilder b = new ForgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        assertEquals(nextNov5, r.getDate());
        assertEquals(250, r.getHeadcount());
        assertEquals("Springfield", r.getCity());
        assertEquals(new Dollars(9.95), r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }
}

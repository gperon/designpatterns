/*
 * @(#)UnforgivingBuilderTest.java   2011-11-01
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
import metsker.designpatterns.creational.builder.Reservation;
import metsker.designpatterns.creational.builder.ReservationBuilder;
import metsker.designpatterns.creational.builder.ReservationParser;
import metsker.designpatterns.creational.builder.UnforgivingBuilder;
import metsker.designpatterns.util.Dollars;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class UnforgivingBuilderTest extends TestCase {
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
     * Method description
     *
     *
     * @throws ParseException
     */
    public void testDisallowLowDollarsPerHead() throws ParseException {
        String sample = "Date, November 5, Headcount, 250, "
                        + "City, Springfield, DollarsPerHead, 1.95, " + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(sample);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {}
    }

    /**
     * Method description
     *
     *
     * @throws ParseException
     */
    public void testDisallowLowHeadCount() throws ParseException {
        String s = "Date, November 5, Headcount, 2, " + "City, Springfield, DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {}
    }

    /**
     * Method description
     *
     *
     * @throws ParseException
     */
    public void testDisallowNoDollars() throws ParseException {
        String sample = "Date, November 5, Headcount, 250, " + "City, Springfield, "
                        + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(sample);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {}
    }

    /**
     * Method description
     *
     *
     * @throws ParseException
     */
    public void testDisallowNoHeadCount() throws ParseException {
        String s = "Date, November 5, " + "City, Springfield, DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("Expected BuilderException: built " + r);
        } catch (BuilderException expected) {}
    }

    /**
     * Method description
     *
     *
     * @throws BuilderException
     * @throws ParseException
     */
    public void testNormalReservation() throws BuilderException, ParseException {
        String s = "Date, November 5, Headcount, 250, City, Springfield, "
                   + "DollarsPerHead, 9.95, HasSite, false";
        UnforgivingBuilder b = new UnforgivingBuilder();
        ReservationParser p = new ReservationParser(b);
        p.parse(s);
        Reservation r = b.build();
        assertEquals(nextNov5, r.getDate());
        assertEquals(250, r.getHeadcount());
        assertEquals("Springfield", r.getCity());
        assertEquals(new Dollars(9.95), r.getDollarsPerHead());
        assertFalse(r.hasSite());
    }

    /**
     * Method description
     *
     *
     * @throws ParseException
     */
    public void testDisallowMissingCity() throws ParseException {
        String s = "Date, November 5, Headcount, 250, " + "DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("BuilderException expected: built " + r);
        } catch (BuilderException expected) {}
    }

    /**
     * Method description
     *
     *
     * @throws ParseException
     */
    public void testDisallowMissingDate() throws ParseException {
        String s = "Headcount, 250, " + "City, Springfield, DollarsPerHead, 9.95, "
                   + "HasSite, false";
        ReservationBuilder b = new UnforgivingBuilder();
        new ReservationParser(b).parse(s);
        try {
            Reservation r = b.build();
            fail("BuilderException expected: built " + r);
        } catch (BuilderException expected) {}
    }
}

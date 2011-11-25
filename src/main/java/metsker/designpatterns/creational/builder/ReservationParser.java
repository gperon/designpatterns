/*
 * @(#)ReservationParser.java   2011-11-01
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



package metsker.designpatterns.creational.builder;

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
import java.text.DateFormat;
import java.text.ParseException;

import java.util.Calendar;
import java.util.Date;

import metsker.designpatterns.util.Dollars;

/**
 * This class parses a request for a fireworks exhibition. The request must be a
 * comma-separated list of parameter names and values. The expected parameters
 * for an exhibition are: date, heacount, city, dollarsPerHead, and hasSite. For
 * example, a valid request is: <blockquote>
 *
 * <pre>
 *       Date, November 5, Headcount, 250, City, Springfield,
 *       DollarsPerHead, 9.95, HasSite, No
 * </pre>
 *
 * </blockquote> The format for dates is the name of the month followed by the
 * day. This parser assumes the year for the date is the year in which the date
 * next occurs.
 */
public class ReservationParser {
    private ReservationBuilder builder;

    /**
     * Create a parser that will pass its results to the specified builder.
     * @param builder the builder to pass parameters to
     */
    public ReservationParser(ReservationBuilder builder) {
        this.builder = builder;
    }

    /**
     * Parse a reservation request, passing its information to the builder.
     * @param s the request
     *
     * @throws ParseException
     */
    public void parse(String s) throws ParseException {
        String[] tokens = s.split(",\\s*");
        for (int i = 0; i < tokens.length; i += 2) {
            String type = tokens[i];
            String val = tokens[i + 1];
            if ("date".compareToIgnoreCase(type) == 0) {
                Calendar now = Calendar.getInstance();
                DateFormat formatter = DateFormat.getDateInstance();
                Date d = formatter.parse(val + ", " + now.get(Calendar.YEAR));
                builder.setDate(ReservationBuilder.futurize(d));
            } else if ("headcount".compareToIgnoreCase(type) == 0) {
                builder.setHeadcount(Integer.parseInt(val));
            } else if ("City".compareToIgnoreCase(type) == 0) {
                builder.setCity(val.trim());
            } else if ("DollarsPerHead".compareToIgnoreCase(type) == 0) {
                builder.setDollarsPerHead(new Dollars(Double.parseDouble(val)));
            } else if ("HasSite".compareToIgnoreCase(type) == 0) {
                builder.setHasSite(val.equalsIgnoreCase("true"));
            }
        }
    }
}

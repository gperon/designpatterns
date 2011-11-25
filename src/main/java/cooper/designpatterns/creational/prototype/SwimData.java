/*
 * @(#)SwimData.java   2011-11-01
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



package cooper.designpatterns.creational.prototype;

import cooper.designpatterns.util.swing.InputFile;

import java.util.*;

import java.io.*;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class SwimData implements Cloneable, Serializable {
    protected List<Swimmer> swimmers;

    /**
     * Constructs ...
     *
     *
     * @param filename
     */
    public SwimData(String filename) {
        String s = "";
        swimmers = new ArrayList();
        InputFile f = new InputFile(getClass(), filename);
        s = f.readLine();
        while (s != null) {
            swimmers.add(new Swimmer(s));
            s = f.readLine();
        }
        f.close();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int size() {
        return swimmers.size();
    }

    /**
     * Method description
     *
     *
     * @param i
     *
     * @return
     */
    public Swimmer getSwimmer(int i) {
        return swimmers.get(i);
    }

    /**
     * Method description
     *
     */
    public void sortByTime() {
        Collections.sort(swimmers, new Comparator<Swimmer>() {
            public int compare(Swimmer o1, Swimmer o2) {
                if (o1.isFemale() && !o2.isFemale()) {
                    return -1;
                } else if (!o1.isFemale() && o2.isFemale()) {
                    return 1;
                } else {
                    if (o1.getTime() < o2.getTime()) {
                        return -1;
                    } else if (o1.getTime() > o2.getTime()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object deepClone() {
        try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(b);
            out.writeObject(this);
            ByteArrayInputStream bIn = new ByteArrayInputStream(b.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bIn);

            return (oi.readObject());
        } catch (Exception e) {
            System.out.println("exception:" + e.getMessage());
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object clone() {
        try {
            return super.clone();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return null;
        }
    }
}


class Swimmer implements Serializable {
    String name;
    int age;
    String club;
    float time;
    boolean female;

    /**
     * Constructs ...
     *
     *
     * @param dataline
     */
    public Swimmer(String dataline) {
        StringTokenizer st = new StringTokenizer(dataline, ",");
        name = st.nextToken();
        age = new Integer(st.nextToken().trim()).intValue();
        club = st.nextToken().trim();
        time = new Float(st.nextToken().trim()).floatValue();
        // System.out.println(name+" "+time);
        String sx = st.nextToken().trim().toUpperCase();
        female = sx.equals("F");
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean isFemale() {
        return female;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public float getTime() {
        return time;
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
     * @return
     */
    public String getClub() {
        return club;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String toString() {
        String retValue;
        retValue = name + "\t" + (female ? "(F)" : "(M)") + "\t" + time;

        return retValue;
    }
}

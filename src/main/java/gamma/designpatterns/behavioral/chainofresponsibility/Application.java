/*
 * @(#)Application.java   2011-11-01
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



package gamma.designpatterns.behavioral.chainofresponsibility;

/**
 *  Application
 * <p>
 *
 *  Title: </p> <p>
 *
 *  Description: Design Patterns Examples</p> <p>
 *
 *  Copyright: Copyright (c) 2003</p> <p>
 *
 *  Company: GioPerLab</p>
 *
 * @author     giorgio_peron@libero.it
 * @created    2 marzo 2003
 * @version    1.0
 */
public class Application extends HelpHandler {

    /**
     *  Constructor for the Application object
     *
     * @param  topic  Description of the Parameter
     */
    public Application(Topic topic) {
        super(null, topic);
    }

    /**
     *  Description of the Method
     */
    public void handleHelp() {
        // show a list of help topics
        System.out.println("1. help 1");
        System.out.println("2. help 2");
        System.out.println("3. help 3");
        System.out.println("4. help 4");
    }
}

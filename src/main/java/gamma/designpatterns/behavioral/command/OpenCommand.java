/*
 * @(#)OpenCommand.java   2011-11-01
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


package gamma.designpatterns.behavioral.command;

/**
 * <p>
 * <p>
 * Title: </p> <p>
 * <p>
 * Description: Design Patterns Examples</p> <p>
 * <p>
 * Copyright: Copyright (c) 2003</p> <p>
 * <p>
 * Company: GioPerLab</p>
 *
 * @author giorgio_peron@libero.it
 * @version 1.0
 * @created 2 marzo 2003
 */
public class OpenCommand implements Command {
    private String response;
    private final Application application;

    /**
     * Constructor for the OpenCommand object
     *
     * @param application Description of the Parameter
     */
    public OpenCommand(Application application) {
        this.application = application;
    }

    /**
     * Description of the Method
     */
    public void execute() {
        String name = askUser();
        if (name != null) {
            Document doc = new Document(name);
            application.add(doc);
            doc.open();
        }
    }

    /**
     * Description of the Method
     *
     * @return Description of the Return Value
     */
    protected String askUser() {
        return "askUser";
    }
}

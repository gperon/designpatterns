/*
 * @(#)Mediator.java   2011-11-01
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



package cooper.designpatterns.behavioral.mediator;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>
 */
public class Mediator {
    private ClearButton clearButton;
    private MoveButton moveButton;
    private KTextField ktext;
    private KidList klist;
    private PickedKidsList picked;

    /**
     * Constructs ...
     *
     */
    public Mediator() {}

    /**
     * Method description
     *
     */
    public void move() {
        picked.add(ktext.getText());
        clearButton.setEnabled(true);
    }

    /**
     * Method description
     *
     */
    public void init() {
        clear();
    }

    /**
     * Method description
     *
     */
    public void clear() {
        ktext.setText("");
        moveButton.setEnabled(false);
        clearButton.setEnabled(false);
        picked.clear();
        klist.clearSelection();
        System.out.println("cleared");
    }

    /**
     * Method description
     *
     */
    public void select() {
        String s = (String) klist.getSelectedValue();
        ktext.setText(s);
        moveButton.setEnabled(true);
        System.out.println("selected");
    }

    /**
     * Method description
     *
     *
     * @param cb
     */
    public void registerClear(ClearButton cb) {
        clearButton = cb;
    }

    /**
     * Method description
     *
     *
     * @param mv
     */
    public void registerMove(MoveButton mv) {
        moveButton = mv;
    }

    /**
     * Method description
     *
     *
     * @param tx
     */
    public void registerText(KTextField tx) {
        ktext = tx;
    }

    /**
     * Method description
     *
     *
     * @param pl
     */
    public void registerPicked(PickedKidsList pl) {
        picked = pl;
    }

    /**
     * Method description
     *
     *
     * @param kl
     */
    public void registerKidList(KidList kl) {
        klist = kl;
    }
}

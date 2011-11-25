/*
 * @(#)MoveATubMediator.java   2011-11-01
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



package metsker.designpatterns.behavioral.mediator;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Class description
 *
 *
 * @version        0.1.1, 2011-11-01
 * @author         <a href="mailto:giorgio.peron@gmail.com">Giorgio Peron</a>    
 */
public class MoveATubMediator implements ListSelectionListener, ActionListener {
    MoveATub2 gui;
    NameBase data;
    private Object selectedMachine;
    private Object selectedTub;

    /**
     * Constructs ...
     *
     *
     * @param gui
     * @param data
     */
    public MoveATubMediator(MoveATub2 gui, NameBase data) {
        this.gui = gui;
        this.data = data;
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if ((selectedMachine == null) || (selectedTub == null)) {
            return;
        }
        String tubName = selectedTub.toString();
        String fromMachineName = data.getMachineContaining(tubName);
        String toMachineName = selectedMachine.toString();
        data.put(tubName, toMachineName);
        updateTubList(fromMachineName);
        gui.assignButton().setEnabled(false);
    }

    /**
     * Method description
     *
     *
     * @param e
     */
    public void valueChanged(ListSelectionEvent e) {
        JList sender = (JList) e.getSource();
        if (!sender.isSelectionEmpty()) {
            Object selection = sender.getSelectedValue();
            if (sender.equals(gui.boxList())) {
                this.updateTubList(selection.toString());
            } else if (sender.equals(gui.machineList())) {
                selectedMachine = selection;
            } else if (sender.equals(gui.tubList())) {
                selectedTub = selection;
            }
        }
        gui.assignButton().setEnabled(!gui.tubList().isSelectionEmpty()
                                      && !gui.machineList().isSelectionEmpty());
    }

    /**
     * Method description
     *
     *
     * @param machineName
     */
    public void updateTubList(String machineName) {
        gui.tubList().setListData(data.tubNames(machineName));
    }
}

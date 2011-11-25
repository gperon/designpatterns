/*
 * @(#)Direction.java   2011-11-01
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



package gamma.designpatterns.creational.maze;

/**
 *  ** <p>
 *
 *  Title: Design Patterns</p> <p>
 *
 *  Description: </p> <p>
 *
 *  Copyright: Copyright (c) 2002</p> <p>
 *
 *  Company: GioPerLab</p>
 *
 * @author     giorgio_peron@libero.it
 * @created    2 giugno 2002
 * @version    1.0
 */
public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    /**
     *  Gets the oppositeDirection attribute of the Direction class
     *
     * @param  d  Description of the Parameter
     * @return    The oppositeDirection value
     */
    public static Direction getOppositeDirection(Direction d) {
        switch (d) {
            case NORTH :
                return SOUTH;

            case EAST :
                return WEST;

            case SOUTH :
                return NORTH;

            case WEST :
                return EAST;

            default :
                return null;
        }
    }
}

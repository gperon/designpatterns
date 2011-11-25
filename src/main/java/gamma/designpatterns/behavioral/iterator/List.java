/*
 * @(#)List.java   2011-11-01
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



/*
* List.java
*
* Created on 4 novembre 2006, 10.24
*
* To change this template, choose Tools | Template Manager
* and open the template in the editor.
 */
package gamma.designpatterns.behavioral.iterator;

import java.util.*;

/**
 *
 * @author gperon
 *
 * @param <Item>
 */
public class List<Item> {
    private int size;
    private Item[] array;

    /**
     * Creates a new instance of List
     *
     * @param capacity
     */
    public List(int capacity) {
        array = (Item[]) new Object[capacity];
        size = 0;
    }

    /**
     * Constructs ...
     *
     *
     * @param l
     */
    public List(List l) {
        throw new UnsupportedOperationException();
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public long count() {
        return size;
    }

    /**
     * Method description
     *
     *
     * @param index
     *
     * @return
     */
    public Item get(int index) {
        return array[index];
    }

    /**
     * Method description
     *
     *
     * @param item
     */
    public void append(Item item) {
        if (size >= array.length) {
            throw new IndexOutOfBoundsException();
        } else {
            array[size] = item;
            size++;
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Iterator<Item> iterator() {
        return new ListIterator(this);
    }

    /*
     * Item first() {}
     * Item last() {}
     * boolean includes(Item item){}
     *
     * void append(Item item){}
     * void prepend(Item item){}
     *
     * void remove(Item item){}
     * void removeLast(){}
     * void removeFirst(){}
     * void removeAll(){}
     *
     * Item top(){}
     * void push(Item item){}
     * Item pop(){}
     */
}

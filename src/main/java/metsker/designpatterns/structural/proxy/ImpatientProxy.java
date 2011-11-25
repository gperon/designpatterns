/*
 * @(#)ImpatientProxy.java   2011-11-01
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



package metsker.designpatterns.structural.proxy;

import java.lang.reflect.*;

/**
 * This class is an example of a dynamic proxy. Instances of this class wrap a
 * proxied object. This class simply forwards calls to the object it wraps.
 * However, if any method takes a long time to execute, this class will print a
 * warning message.
 */
public class ImpatientProxy implements InvocationHandler {
    private Object obj;

    /**
     * Construct a dynamic proxy around the given object.
     * @param obj the object to wrap
     * @return the proxy
     */
    public static Object newInstance(Object obj) {
        ClassLoader loader = obj.getClass().getClassLoader();
        Class[] classes = obj.getClass().getInterfaces();

        return Proxy.newProxyInstance(loader, classes, new ImpatientProxy(obj));
    }

    private ImpatientProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * The method that all dynamic proxies must implement. This dynamic proxy
     * complains when a method takes a long time to return.
     *
     * @param proxy
     * @param m
     * @param args
     *
     * @return
     *
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        long t1 = System.currentTimeMillis();
        result = m.invoke(obj, args);
        long t2 = System.currentTimeMillis();
        if (t2 - t1 > 10) {
            System.out.println("> It takes " + (t2 - t1) + " millis to invoke " + m.getName()
                               + "() with");
            for (int i = 0; i < args.length; i++) {
                System.out.println(">     arg[" + i + "]: " + args[i]);
            }
        }

        return result;
    }
}

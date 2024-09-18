/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.tools.web;

import de.tr7zw.nbtinjector.javassist.tools.web.Webserver;
import java.io.IOException;
import java.net.Socket;

class ServiceThread
extends Thread {
    Webserver web;
    Socket sock;

    public ServiceThread(Webserver w2, Socket s2) {
        this.web = w2;
        this.sock = s2;
    }

    @Override
    public void run() {
        try {
            this.web.process(this.sock);
        } catch (IOException iOException) {
            // empty catch block
        }
    }
}


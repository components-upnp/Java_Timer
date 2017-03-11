package com.irit.main;

import com.irit.fenetre.upnp.ChronoServer;

/**
 * Created by Abdourahamane Ly on 11/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        Thread serverThread = new Thread(new ChronoServer());
        serverThread.setDaemon(false);
        serverThread.start();
    }
}

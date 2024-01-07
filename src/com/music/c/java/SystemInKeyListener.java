package com.music.c.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SystemInKeyListener implements KeyListener {
    private KeyListener delegate;
    public SystemInKeyListener(KeyListener delegate) {
        this.delegate = delegate;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        delegate.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        delegate.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        delegate.keyReleased(e);
    }
}

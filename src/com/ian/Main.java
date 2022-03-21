package com.ian;

import com.ian.gui.Frame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static Frame f;

    public static void main(String[] args) {
        f = new Frame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.requestFocus();
        f.setVisible(true);
        f.requestFocus();
    }
}

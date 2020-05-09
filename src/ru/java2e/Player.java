package ru.java2e;

import javax.swing.*;
import java.awt.*;

public class Player {
    Image img = new ImageIcon("res/player.png").getImage();

    int v = 4;
    int dv = 0;
    int s = 0;

    int x = 30;
    int y = 100;


    int layer1 = 0;



    public void move() {
        s += v;
        layer1 -= v;

    }
}

package ru.java2e;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

import javax.swing.*;

public class Road extends JPanel implements ActionListener,Runnable {

    Timer mainTimer = new Timer(20,this);

    Image img = new ImageIcon("res/road.jpg").getImage();

    Player p = new Player();

    Thread enemiesFactory = new Thread(this);

    List<Enemy> enemies = new ArrayList<Enemy>();


    public Road(){
        mainTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    private class MyKeyAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            p.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            p.keyReleased(e);
        }
    }

    public void paint(Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(img, p.layer1, 0, null);
        g.drawImage(img, p.layer2, 0, null);
        g.drawImage(p.img, p.x, p.y, null);


    }
    public void actionPerformed(ActionEvent e){
        p.move();
        repaint();
        }
        public void run(){
        while (true){
            Random rand = new Random();
            try {
                Thread.sleep(rand.nextInt(2000));
                enemies.add(new Enemy(1200, rand.nextInt(480), rand.nextInt(70),this ));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }

    }


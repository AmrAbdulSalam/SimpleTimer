package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CounterFrame extends JFrame implements ActionListener {
    private JLabel north_label , center_label;
    private JPanel p1 , p2 , p3 ,p4;
    private String on , off ;
    private JButton rest , start ;
    private boolean preesed , statflag , key , key2;
    private static MyThread thread , thread1;
    private int counter;
    private static int mill , second , minute;
    private static int x , y , z;
    private DecimalFormat decimalFormat_second , decimalFormat_minute , decimalFormat_mill ;

    public CounterFrame(){
        super("StopWatch");
        on = "Timer : ON";
        off = "Timer : OFF";
        north_label = new JLabel(off);
        north_label.setForeground(Color.red);
        north_label.setFont(new Font("Garamond" , Font.BOLD , 16));
        //for center
        center_label = new JLabel("00:00.0");
        center_label.setFont(new Font("Serif" , Font.BOLD , 40));
        // for the buttons
        rest = new JButton(" REST ");
        start = new JButton(" START ");
        start.setForeground(Color.GREEN);
        preesed = false;
        //adding panels
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.add(north_label);
        p1.setBackground(Color.GRAY);
        add(p1 , BorderLayout.NORTH);
        p2.add(center_label);
        add(p2 , BorderLayout.CENTER);
        p2.setBackground(Color.gray);
        p3.add(start);
        p3.add(rest);
        add(p3 , BorderLayout.SOUTH);
        p3.setBackground(Color.gray);
        start.addActionListener(this);
        rest.addActionListener(this);
        //for thread
        counter = 0;
        statflag = false;

    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == start){
            north_label.setText(on);
            north_label.setForeground(Color.GREEN);
            start.setText(" PAUSE ");
            start.setForeground(Color.RED);
            key = true;
            key2 = true;
            if (counter == 0) {
                thread = new MyThread("TimerThrid");
                thread.start();
                counter++;
            }
            if (preesed){
                start.setText(" START ");
                north_label.setText(off);
                north_label.setForeground(Color.RED);
                start.setForeground(Color.GREEN);
                x = mill;
                y = second;
                z = minute;
                key2 = false; // while loop still running when its true it increment the value!
            }
            preesed = !preesed ;
        }
        else if (event.getSource() == rest){
            north_label.setText(off);
            north_label.setForeground(Color.red);
            start.setText(" START ");
            start.setForeground(Color.GREEN);
            preesed = false;
            counter = 0;
            key = false; // to break from the loop
            mill = second = minute = 0;
            center_label.setText("00:00.0");
        }
    }
    public void setCenter_label(String name){
        center_label.setText(name);
    }

    class MyThread extends Thread{

        public MyThread(String name){
            super(name);
            mill = 0;
            second = 0;
            minute = 0;
            decimalFormat_second = new DecimalFormat("00");
            decimalFormat_mill = new DecimalFormat("0");
            decimalFormat_minute = new DecimalFormat("00");
        }
        public void run() {
            while (true) {
                try {
                    if (!key)
                       break;
                    setCenter_label(decimalFormat_minute.format(minute) + ":" +
                            decimalFormat_second.format(second) + "." +
                            decimalFormat_mill.format(mill));
                    if (key2) {
                        Thread.sleep(20);
                        mill++;
                        if (mill == 10) {
                            second++;
                            mill = mill % 10;
                            if (second == 60) {
                                minute++;
                                second = second % 60;
                                if(minute == 60){
                                    minute = minute % 60;
                                }
                            }
                        }
                    }
                } catch (InterruptedException exception) {
                    System.out.println(exception.toString());
                }
            }
        }
    }
}//end of the class

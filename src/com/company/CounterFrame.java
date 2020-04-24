package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame implements ActionListener {
    private JLabel north_label , center_label;
    private JPanel p1 , p2 , p3;
    private String on , off ;
    private JButton rest , start , pause ;
    public CounterFrame(){
        north_label = new JLabel("Hi test");
        on = "Timer : ON";
        off = "Timer : OFF";
        //for center
        center_label = new JLabel("00:00.0");
        center_label.setFont(new Font("Serif" , Font.BOLD , 40));
        // for the buttons
        rest = new JButton("REST");
        start = new JButton("START");
        pause = new JButton("PAUSE");

        //adding panels
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        p1.add(north_label);
        add(p1 , BorderLayout.NORTH);

        p2.add(center_label);
        add(p2 , BorderLayout.CENTER);

        p3.add(start);
        p3.add(rest);
        add(p3 , BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == start){
            System.out.println("Working! start");
        }
        else if (event.getSource() == rest){
            System.out.println("Working! clear");
        }
    }

}

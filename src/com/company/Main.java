package com.company;

public class Main {

    public static void main(String[] args) {
        CounterFrame frame = new CounterFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(400,180);
        frame.setLocationRelativeTo(null);
    }
}

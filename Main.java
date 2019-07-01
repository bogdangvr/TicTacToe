package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static int dim = 3;
    public static int moves = 0;
    public static JLabel top = new JLabel("TicTacToe");
    public static JLabel bottom = new JLabel("X's Move");
    public static JPanel center = new JPanel();
    public static MyJButton b[][];

    public static int check() {
        boolean ok = true;
        for (int i=1;i<dim;i++) {
            if (b[i][i].getValue() != b[0][0].getValue()) {
                ok = false;
            }
        }
        if (ok && b[0][0].getValue() != -1) {
            return b[0][0].getValue();
        }

        ok = true;
        for (int i=1;i<dim;i++) {
            if (b[i][dim - i - 1].getValue() != b[0][dim - 1].getValue()) {
                ok = false;
            }
        }
        if (ok  && b[0][dim-1].getValue() != -1) {
            return b[0][dim-1].getValue();
        }

        for (int i=0;i<dim;i++) {
            ok = true;
            for (int j=1;j<dim;j++)
                if (b[i][j].getValue() != b[i][0].getValue())
                    ok = false;
            if (ok  && b[i][0].getValue() != -1) {
                return b[i][0].getValue();
            }

        }

        for (int j=0;j<dim;j++) {
            ok = true;
            for (int i=1;i<dim;i++)
                if (b[i][j].getValue() != b[0][j].getValue())
                    ok = false;
            if (ok  && b[0][j].getValue() != -1) {
                return b[0][j].getValue();
            }
        }

        return -1;
    }

    public static void removeAll() {
        for (int i=0;i<dim;i++)
            for (int j=0;j<dim;j++)
                b[i][j].setEnabled(false);
    }


    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300, 300);
        window.setLayout(new BorderLayout());

        center.setLayout(new GridLayout(dim, dim));
        b = new MyJButton[dim][dim];

        for (int i=0;i<dim;i++)
            for (int j=0;j<dim;j++) {
                b[i][j] = new MyJButton(-1);
                b[i][j].draw();

                b[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub

                        MyJButton currentObject = (MyJButton)e.getSource();
                        currentObject.setEnabled(false);
                        if (currentObject.getValue() != -1)
                            return;
                        moves++;

                        if (moves % 2 == 1) {
                            currentObject.setValue(1);
                            bottom.setText("0's move");

                        } else {
                            currentObject.setValue(0);
                            bottom.setText("X's move");
                        }

                        int end = check();

                        if (end == 0) {
                            bottom.setText("0 won!");
                            removeAll();
                        } else
                        if (end == 1) {
                            bottom.setText("X won!");
                            removeAll();
                        } else
                        if (moves == dim*dim) {
                            bottom.setText("Draw!");
                            removeAll();
                        }
                        currentObject.draw();

                    }
                });

                center.add(b[i][j]);
            }
        window.add(top, BorderLayout.NORTH);
        window.add(bottom, BorderLayout.SOUTH);
        window.add(center, BorderLayout.CENTER);

        window.setVisible(true);

    }
}

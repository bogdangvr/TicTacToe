package com.company;

import javax.swing.JButton;

public class MyJButton extends JButton{
    private int value;

    public MyJButton(){
        super();
    }

    public MyJButton(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    void draw() {
        if (value == 0)
            this.setText("0");
        else
        if (value == 1)
            this.setText("X");
        else
            this.setText("");
    }

}

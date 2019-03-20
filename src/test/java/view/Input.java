package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Input {

    public Input(){}

    public void main(String[] args){

        JFrame frame = new JFrame("Mein erster Frage lol");
        frame.setSize(200, 200);
        JButton button = new JButton("Drück mich!!!!");
        button.addActionListener(new ActionListener {this});








        frame.setVisible(true);




    }
}
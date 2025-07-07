package UI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame{

    JFrame frm;

    public Frame(String title) {
        
        frm = new JFrame("Calculator");
        frm.setSize(420, 500);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setIconImage(new ImageIcon("src/main/resources/calc.png").getImage());
        frm.setLayout(null);
        frm.getContentPane().setBackground(Color.GRAY);
    }

    public JFrame getFrame() {
        return frm;
    }
}
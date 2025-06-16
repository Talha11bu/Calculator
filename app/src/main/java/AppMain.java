import javax.swing.ImageIcon;
import javax.swing.JFrame;

import UI.Buttons;

public class AppMain {
    public static void main(String args[])throws Exception{

        JFrame frm = new JFrame("Calculator");

        frm.setSize(420, 500);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setIconImage(new ImageIcon("src/main/resources/calc.png").getImage());
        frm.setLayout(null);
        frm.getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        Buttons Btn = new Buttons(frm);

        frm.setVisible(true);

        
    }
}
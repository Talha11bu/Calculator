package UI;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Theme {

    JMenuBar menuBar;
    JMenu themes;
    JMenuItem light, dark, red;
    
    public Theme(JFrame frm, JTextField TextArea, JButton[] function, JButton[] num) {

        menuBar = new JMenuBar();
        themes = new JMenu("Themes");
        light = new JMenuItem("Light");
        dark = new JMenuItem("Dark");
        red = new JMenuItem("Red");

        light.addActionListener(e -> {
            frm.getContentPane().setBackground(Color.WHITE);
            TextArea.setBackground(Color.WHITE);
            TextArea.setForeground(Color.BLACK);
            for (JButton function1 : function) {
                function1.setBackground(Color.WHITE);
                function1.setForeground(Color.BLACK);
            }
            for (JButton number : num) {
                number.setBackground(Color.WHITE);
                number.setForeground(Color.BLACK);
            }
        });

        dark.addActionListener(e -> {
            frm.getContentPane().setBackground(Color.DARK_GRAY);
            TextArea.setBackground(Color.DARK_GRAY);
            TextArea.setForeground(Color.WHITE);
            for (JButton function1 : function) {
                function1.setBackground(Color.DARK_GRAY);
                function1.setForeground(Color.WHITE);
            }
            for (JButton number : num) {
                number.setBackground(Color.DARK_GRAY);
                number.setForeground(Color.WHITE);
            }
        });

        red.addActionListener(e -> {
            frm.getContentPane().setBackground(Color.RED);
            TextArea.setBackground(Color.PINK);
            TextArea.setForeground(Color.MAGENTA);
            for (JButton function1 : function)
                function1.setForeground(Color.MAGENTA);
            for (JButton number : num)
                number.setForeground(Color.MAGENTA);
        });

        themes.add(light);
        themes.add(dark);
        themes.add(red);
        menuBar.add(themes);
        frm.setJMenuBar(menuBar);
        
    }
}

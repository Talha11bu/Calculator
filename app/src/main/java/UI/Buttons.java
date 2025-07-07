package UI;

import Util.Validator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Buttons{

    JPanel panel;
    JTextField TextArea;
    JButton add, sub, mul, div, eq, clr, dot, del, mod, pow;
    Theme themeMenu;

    JButton[] num = new JButton[10];
    JButton[] function = new JButton[10];

    Font font = new Font("Helvetica", Font.BOLD, 20);

    StringBuilder record = new StringBuilder();

    Validator validator =  new Validator();

    public Buttons(JFrame frm) {
    
        TextArea = new JTextField();
        TextArea.setBounds(50, 20, 300, 50);
        TextArea.setFont(font);
        TextArea.setForeground(Color.BLACK);
        TextArea.setEditable(false);
        TextArea.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.GRAY));


        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        eq = new JButton("=");
        clr = new JButton("C");
        dot = new JButton(".");
        del = new JButton("Del");
        mod = new JButton("%");
        pow = new JButton("^");

        function[0] = add;
        function[1] = sub;
        function[2] = mul;
        function[3] = div;
        function[4] = eq;
        function[5] = clr;
        function[6] = dot;
        function[7] = del;
        function[8] = mod;
        function[9] = pow;

        for (JButton function1 : function) {
            function1.addActionListener(listener);
            function1.setFont(font);
            function1.setFocusable(false);
            function1.setContentAreaFilled(false);
            function1.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.GRAY));
        }

        for (int i = 0; i < num.length; i++) {
            num[i] = new JButton(String.valueOf(i));
            num[i].addActionListener(listener);
            num[i].setFont(font);
            num[i].setFocusable(false);
            num[i].setContentAreaFilled(false);
            num[i].setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.GRAY));
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        panel.add(function[5]);
        panel.add(function[9]);
        panel.add(function[7]);
        panel.add(function[3]);
        panel.add(num[1]);
        panel.add(num[2]);
        panel.add(num[3]);
        panel.add(function[2]);
        panel.add(num[4]);
        panel.add(num[5]);
        panel.add(num[6]);
        panel.add(function[0]);
        panel.add(num[7]);
        panel.add(num[8]);
        panel.add(num[9]);
        panel.add(function[1]);
        panel.add(function[6]);
        panel.add(num[0]);
        panel.add(function[8]);
        panel.add(function[4]);

        themeMenu = new Theme(frm, TextArea, function, num);

        frm.add(TextArea);
        frm.add(panel);

    }

    private String calculate(String equation){
        Expression expression = new ExpressionBuilder(equation).build();
        record.delete(0, record.length());
        record.append(expression.evaluate());
        return record.toString();
    }

    private boolean isOperator(int Position) {
        char ch = record.charAt(Position);
        return '+' == ch || '-' == ch || '*' == ch || '/' == ch || '%' == ch || '^' == ch ;        
    }

    ActionListener listener = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    record.append(e.getActionCommand());
                    TextArea.setText(record.toString());
                }

                case "+", "-", "/", "%", "^", "*" -> {
        
                    if(record.isEmpty() && e.getActionCommand().equals("-"))
                        record.append(e.getActionCommand());
                    else if(validator.isValid(record.toString()))
                        record.append(e.getActionCommand());
                    else if(isOperator(record.length()-1) && !e.getActionCommand().equals("-")){  
                        record.deleteCharAt(record.length()-1);
                        record.append(e.getActionCommand());
                    }
                    else if(record.length() > 2 && isOperator(record.length()-2) && e.getActionCommand().equals("-"))
                        record.append(e.getActionCommand());
                    TextArea.setText(record.toString());
                }

                case "=" -> {
                    if(validator.isValid(record.toString()))
                        TextArea.setText(calculate(record.toString()));
                }

                case "C" -> {
                    record.delete(0, record.length());
                    TextArea.setText(record.toString());
                }

                case "Del" -> {
                    if (!record.isEmpty()){
                        record.deleteCharAt(record.length()-1);
                    }
                    TextArea.setText(record.toString());
                }

                case "." -> {
                    if(validator.isValid(record.toString()))
                        record.append(".");
                    TextArea.setText(record.toString());
                }

                default -> {
                    System.out.println("Somethings went wrong");
                }

            }
        }
    };
}
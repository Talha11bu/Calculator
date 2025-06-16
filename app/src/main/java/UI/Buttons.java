package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Buttons{

    JFrame frm;
    JPanel panel;
    JTextField TextArea;
    JButton add, sub, mul, div, eq, clr, dot, del, mod, pow, neg;

    JButton[] num = new JButton[10];
    JButton[] function = new JButton[10];

    Font font = new Font("Helvetica", Font.BOLD, 20);

    StringBuilder record = new StringBuilder();

    public Buttons(JFrame frm) {
        this.frm = frm;
        TextArea = new JTextField();
        TextArea.setBounds(50, 30, 300, 50);
        TextArea.setFont(font);
        TextArea.setForeground(Color.BLACK);
        TextArea.setEditable(false);
        TextArea.setOpaque(false);
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
        neg = new JButton("(-)");

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
            function1.setForeground(Color.BLACK);
            function1.setFocusable(false);
            function1.setOpaque(false);
            function1.setContentAreaFilled(false);
            function1.setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.GRAY));
        }

        for (int i = 0; i < num.length; i++) {
            num[i] = new JButton(String.valueOf(i));
            num[i].addActionListener(listener);
            num[i].setFont(font);
            num[i].setForeground(Color.BLACK);
            num[i].setFocusable(false);
            num[i].setOpaque(false);
            num[i].setContentAreaFilled(false);
            num[i].setBorder(BorderFactory.createBevelBorder(1, Color.DARK_GRAY, Color.GRAY));
        }

        neg.setBounds(165, 405, 70, 50);
        neg.setFont(font);
        neg.setForeground(Color.BLACK);
        neg.setOpaque(false);
        neg.setContentAreaFilled(false);

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

        frm.add(TextArea);
        frm.add(panel);
        frm.add(neg);

    }

    private String calculate(){   
        var match = new ArrayList<String>(List.of(record.toString().split(" ")));    
        double result = Double.parseDouble(match.get(0));
        match.remove(0);

        while(!match.isEmpty()){
            result = switch (match.get(0)) {
                case "+" -> result + Double.parseDouble(match.get(1));
                case "-" -> result - Double.parseDouble(match.get(1));
                case "*" -> result * Double.parseDouble(match.get(1));
                case "/" -> result / Double.parseDouble(match.get(1));
                default -> Double.parseDouble(match.get(1));      
            };
            match.remove(0);
            match.remove(0);
        }

        record.delete(0, record.length());
        record.append(Double.toString(result));
        return record.toString();
    }

    private void removeLastCharIfOperator() {
        if(record.length() > 1){
            char str = record.charAt(record.length()-2);
            if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str) || "%".equals(str) || "^".equals(str))
                record.delete(record.length()-3, record.length());
        }
    }

    ActionListener listener = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" -> {
                    TextArea.setText(TextArea.getText().concat(e.getActionCommand()));
                    record.append(e.getActionCommand());
                }

                case "+", "-", "/", "%", "^", "*" -> {
                    if(!record.isEmpty()){
                        removeLastCharIfOperator();
                        record.append(" ");
                        record.append(e.getActionCommand());
                        record.append(" ");
                    }
                    TextArea.setText(record.toString());
                }

                case "=" -> {
                    if(record.length()>0)
                        removeLastCharIfOperator();
                    TextArea.setText(calculate());
                }

                case "C" -> {
                    record.delete(0, record.length());
                    TextArea.setText("");
                }

                case "Del" -> {
                    if (!(record.length() > 0))
                        removeLastCharIfOperator();
                        else
                            record.deleteCharAt(record.length()-1);
                    TextArea.setText(record.toString());
                }

                case "." -> {
                    record.append(e.getActionCommand());
                    TextArea.setText(record.toString());
                }

                case "(-)" -> {
                    if(record.length() > 1){
                    char str = record.charAt(record.length()-2);
                    if("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str) || "%".equals(str) || "^".equals(str))
                        record.append("-");
                    }
                    TextArea.setText(record.toString());
                }
            }
        }

    };

}

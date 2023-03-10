import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    static void printW() {
        System.out.println("ww");
    }

    JFrame frame;
    JTextField texfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Bauhaus 93", Font.PLAIN, 25);

    double num1 = 0, num2 = 0, result;
    char operator;

    //Method check 2nd "+-*." char pushed?

    //Method check negativ number?

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);// there is no layout manager

        texfield = new JTextField();
        texfield.setBounds(50, 25, 300, 50);
        texfield.setFont(myFont);
        texfield.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(texfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    int countDec = 0;
    int count = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == subButton && num1 == 0) {                  //My if
            texfield.setText("-");
        }
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                texfield.setText(texfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {                               //It is ok now. You can use . only once
            if (countDec < 1) {
                texfield.setText(texfield.getText().concat("."));
                countDec++;
            }else {
                texfield.getText();
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '+';
            texfield.setText("+");
        }
        if (e.getSource() == subButton) {
            count++;
            if (count>1){

            }
            num1 = Double.parseDouble(texfield.getText());
            operator = '-';
            texfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '*';
            texfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '/';
            texfield.setText("");
        }

        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(texfield.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            texfield.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == delButton) {                           //My if
            String string = texfield.getText();
            string = string.substring(0, string.length() - 1);
            texfield.setText(string);

        }
        if (e.getSource() == clrButton) {                           //My if
            texfield.setText("");
            num1 = 0;
            num2 = 0;
            result = 0;
        }
    }
}





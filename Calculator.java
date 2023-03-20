import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField texfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Bauhaus 93", Font.PLAIN, 25);

    double num1;
    double num2 = 0, result, tempResult;
    char operator;

    ArrayList<String> fullList = new ArrayList<String>();  //collect the /*-+ signs

    public void toFullList(Integer n) {
        fullList.add(String.valueOf(n));
    }

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
        negButton = new JButton("+-");


        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        delButton.setBounds(50, 430, 110, 50);
        //delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(170, 430, 110, 50);
        //clrButton.setBounds(205, 430, 145, 50);
        negButton.setBounds(288, 430, 60, 50);

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
        frame.add(negButton);
        frame.add(texfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme

        } catch (Exception e) {
            e.printStackTrace();
        }

        Calculator calc = new Calculator();
    }

    int countDec = 0;
    boolean equalWasPushed = false;
    boolean outcome = false;

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 10; i++) {
            if (e.getSource().equals(numberButtons[i])) {
                if (outcome) {
                    texfield.setText("");
                    outcome = false;
                }
                texfield.setText(texfield.getText().concat(String.valueOf(i)));
                System.out.println();
            }
        }
        if (e.getSource().equals(decButton)) {                               //It is ok now. You can use . only once
            if (countDec < 1) {
                texfield.setText(texfield.getText().concat("."));
                countDec++;
            } else {
                countDec++;
                System.out.println("This was already the " + countDec + " -dot!");
            }
        }
        if (e.getSource().equals(addButton)) {
            num1 = Double.parseDouble(texfield.getText());
            tempResult = num1;
            operator = '+';
            texfield.setText("+");
            num1 = num1 + tempResult;
            System.out.println("num1 " + num1 + " num2 " + num2 + "tempResult " + tempResult);
            tempResult = 0;
            countDec = 0;
            //loopVar = true;
        }
        if (e.getSource().equals(subButton)) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '-';
            texfield.setText("");
            countDec = 0;
        }
        if (e.getSource().equals(mulButton)) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '*';
            texfield.setText("");
            countDec = 0;
        }
        if (e.getSource().equals(divButton)) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '/';
            texfield.setText("");
            countDec = 0;
        }
        if (e.getSource().equals(negButton)) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '+';
            texfield.setText("-");
            outcome = false;
            System.out.println(String.valueOf(texfield.getText()));
        }

        if (e.getSource().equals(equButton)) {
            try {
                num2 = Double.parseDouble(texfield.getText());   //Ha megnyomtad = akkor nem írhat be újabb számot az eredmény után
                equalWasPushed = true;
            } catch (NumberFormatException e2) {
                System.out.println("Cannot end with an operation sign");
            }

            switch (operator) {
                case '+' -> {
                    tempResult = 0;
                    result = num1 + num2;
                    countDec = 0;
                    System.out.println("num1: " + num1 + " + num2: " + num2 + " result " + result + "\n" + "tempresult " + tempResult);
                }
                case '-' -> {
                    result = num1 - num2;
                    countDec = 0;
                    System.out.println("num1: " + num1 + " - num2: " + num2 + " result " + result);
                }
                case '*' -> {
                    result = num1 * num2;
                    countDec = 0;
                    System.out.println("num1: " + num1 + " * num2: " + num2 + " result " + result);
                }
                case '/' -> {
                    result = num1 / num2;
                    countDec = 0;
                    System.out.println("num1: " + num1 + " / num2: " + num2 + " Eredmeny: " + result);
                }
            }
            System.out.println("*****************************************************");
            texfield.setText(String.valueOf(result));
            //num1 = result;
            outcome = true;        //Ez egy számláló. ha van eredmény akkor törölje a képet
            countDec = 1;
        }
        //ciklus vége


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
            countDec = 0;
            outcome = false;
        }
    }
}





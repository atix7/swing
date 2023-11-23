import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator1 implements ActionListener {
    JFrame frame;
    static JTextField texfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Bauhaus 93", Font.PLAIN, 25);
    boolean num1Exist = false;
    static boolean equalWasPushed = false;
    double num1, num2 = 0;
    static int countDec = 0;
    char operator;

    public static double doCalc(double n1, double n2, char operatorCalc) {
        equalWasPushed = true;
        countDec = 0;
        switch (operatorCalc) {
            case '+' -> {
                System.out.println("n1: " + n1 + " + n2: " + n2 + " result " + (n1 + n2) + "\n");
                n1 = n1 + n2;
                countDec = 0;
                texfield.setText(String.valueOf(n1));
            }
            case '-' -> {
                System.out.println("n1: " + n1 + " - n2: " + Math.abs(n2) + " result " + (n1 - Math.abs(n2) + "\n"));
                n1 = n1 - Math.abs(n2);
                countDec = 0;
                texfield.setText(String.valueOf(n1));
            }
            case '*' -> {
                System.out.println("n1: " + n1 + " * n2: " + n2 + " result " + (n1 * n2) + "\n");
                n1 = n1 * n2;
                countDec = 0;
                texfield.setText(String.valueOf(n1));
            }
            case '/' -> {
                System.out.println("n1: " + n1 + " / n2: " + n2 + " result " + (n1 / n2) + "\n");
                n1 = n1 / n2;
                if (n2 == 0) {
                    System.out.println("0-val nem lehet osztani");
                    texfield.setText("0-val nem lehet osztani");
                } else {
                    texfield.setText(String.valueOf(n1));
                }
                countDec = 0;
            }
        }
        System.out.println("***************************************************** doCalc result: ");
        System.out.println(n1);
        countDec = 1;
        return n1;

    }

    Calculator1() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(365, 520);
        frame.setLayout(null);// there is no layout manager
        // System.out.println(dotAtTheEnd("1236."));  //***************************************************
        texfield = new JTextField();
        texfield.setBounds(25, 25, 300, 50);
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
        delButton.setBounds(25, 420, 110, 50);
        clrButton.setBounds(145, 420, 110, 50);
        negButton.setBounds(264, 420, 60, 50);

        panel = new JPanel();
        panel.setBounds(25, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(numberButtons[0]);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(decButton);
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
        Calculator1 calc = new Calculator1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource().equals(numberButtons[i])) {
                if (equalWasPushed) {
                    texfield.setText("");
                    equalWasPushed = false;
                }
                texfield.setText(texfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource().equals(decButton)) {
            if (countDec < 1) {
                texfield.setText(texfield.getText().concat("."));
                countDec++;
            } else {
                countDec++;
                System.out.println("This was already the " + countDec + " -dot!");
            }
        }

        if (e.getSource().equals(addButton)) {  //****************** ADD  jó
            operator = '+';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist && !equalWasPushed) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert + jel num2");
                }
                num1 = doCalc(num1, num2, operator);
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert + jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            texfield.setText("+");
        }

        if (e.getSource().equals(subButton)) {  //****************** Subs  jó
            operator = '-';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist && !equalWasPushed) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert - jel num2");
                }
                num1 = doCalc(num1, num2, operator);
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert - jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            texfield.setText("-");
        }

        if (e.getSource().equals(mulButton)) {  //****************** multiplication
            operator = '*';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist && !equalWasPushed) {                         //Második szám beolvasás
                try {
                    System.out.println("Most olvasom a num2-t!");
                    num2 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num2");
                }
                num1 = doCalc(num1, num2, operator);
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            texfield.setText("*");
        }

        if (e.getSource().equals(divButton)) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '/';
            texfield.setText("");
            countDec = 0;
        }
        if (e.getSource().equals(negButton)) {
            try {
                num1 = Double.parseDouble(texfield.getText());
            } catch (NumberFormatException exception) {
                System.out.println("Sikertelen parse-olás char-ból double-be");
                if (operator == '-') {
                    texfield.setText("+");
                }
            }
            operator = '-';
            texfield.setText("-");
            System.out.println(texfield.getText());
        }


        if (e.getSource().equals(equButton)) {
            try {
                String string1 = texfield.getText();
                if (string1.length() > 1) {
                    string1 = string1.substring(1);
                    num2 = Double.parseDouble(string1);   //Ha megnyomtad = akkor nem folytathatja a számot az eredmény után
                }
                equalWasPushed = true;
                countDec = 0;
            } catch (NumberFormatException e2) {
                System.out.println("Cannot end with an operation sign");
            }
            System.out.println("***************************************************** equal gomb");
            countDec = 0;
            num1 = doCalc(num1, num2, operator);
            num2 = 0;
            num1Exist = true;
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
            num1Exist = false;
            countDec = 0;
            System.out.println("*** clear was pushed ***");
        }

    }
}





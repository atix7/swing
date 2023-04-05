import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    boolean num1Exist = false;
    boolean num2Exist = false;
    static boolean equalWasPushed = false;
    double num1;
    double num2 = 0, result, tempResult;   //result, tempresult nem fog kelleni
    static int countDec = 0;
    char operator;

    public static double doCalc(double n1, double n2, char operatorCalc) {
        equalWasPushed = true;
        countDec = 0;
        switch (operatorCalc) {
            case '+' -> {
                System.out.println("n1: " + n1 + " + n2: " + n2 + " result " + (n1 + n2) + "\n");
                n1 = n1 + n2;
            }
            case '-' -> {
                System.out.println("n1: " + n1 + " - n2: " + n2 + " result " + (n1 - Math.abs(n2)) + "\n");
                n1 = n1 - Math.abs(n2);
            }
            case '*' -> {
                System.out.println("n1: " + n1 + " * n2: " + n2 + " result " + (n1 * n2) + "\n");
                n1 = n1 * n2;
            }
            case '/' -> {
                System.out.println("n1: " + n1 + " - n2: " + n2 + " result " + (n1 / n2) + "\n");
                n1 = n1 / n2;
            }
        }
        System.out.println("***************************************************** doCalc result: ");
        System.out.println(n1);
        texfield.setText(String.valueOf(n1));
        countDec = 1;
        return n1;

    }



    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calculator calc = new Calculator();
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
        if (e.getSource().equals(addButton)) {
            operator = '+';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
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
        if (e.getSource().equals(subButton)) {
            operator = '-';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
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
        if (e.getSource().equals(mulButton)) {/*
            num1 = Double.parseDouble(texfield.getText());
            operator = '*';
            texfield.setText("");
            countDec = 0;
            }*/
            operator = '*';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num2");
                    String tempNum = String.valueOf(texfield.getText());
                    num2 = Double.parseDouble(tempNum.substring(1));
                    System.out.println(num2);
                    num1 = doCalc(num1, num2, operator);
                }
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
            operator = '/';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                texfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(texfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num2");
                    String tempNum = String.valueOf(texfield.getText());
                    num2 = Double.parseDouble(tempNum.substring(1));
                    System.out.println(num2);
                    num1 = doCalc(num1, num2, operator);
                }
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
            texfield.setText("/");
        }
        if (e.getSource().equals(negButton)) {
            num1 = Double.parseDouble(texfield.getText());
            operator = '+';
            texfield.setText("-");
            System.out.println(texfield.getText());
        }


        if (e.getSource().equals(equButton)) {
            try {
                num2 = Double.parseDouble(texfield.getText());   //Ha megnyomtad = akkor nem folytathatja a számot az eredmény után
                equalWasPushed = true;
                countDec = 0;
            } catch (NumberFormatException e2) {
                System.out.println("Cannot end with an operation sign");
                String tempNum = String.valueOf(texfield.getText());
                num2 = Double.parseDouble(tempNum.substring(1));
            }
            System.out.println("***************************************************** equal gomb");
            countDec = 0;
            num1 = doCalc(num1, num2, operator);
            num2 = 0;
            num1Exist = true;
            num2Exist = false;
            System.out.println(num1 + "  " + num2);
        }

        if (e.getSource() == delButton) {
            String string = texfield.getText();
            string = string.substring(0, string.length() - 1);
            texfield.setText(string);

        }
        if (e.getSource() == clrButton) {
            texfield.setText("");
            num1 = 0;
            num2 = 0;
            num1Exist = false;
            num2Exist = false;
            result = 0;
            countDec = 0;
            tempResult = 0;
        }
    }
}





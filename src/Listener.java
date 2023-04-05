import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {
    public boolean equalWasPushed = false;
    private Gui gui;

    public Listener(Gui gui){
        this.gui = gui;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource().equals(gui.numberButtons[i])) {
                if (equalWasPushed) {
                    gui.textfield.setText("");
                    equalWasPushed = false;
                }
                gui.textfield.setText(gui.textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource().equals(decButton)) {
            if (countDec < 1) {
                gui.textfield.setText(gui.textfield.getText().concat("."));
                countDec++;
            } else {
                countDec++;
                System.out.println("This was already the " + countDec + " -dot!");
            }
        }
        if (e.getSource().equals(addButton)) {
            operator = '+';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                gui.textfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert + jel num2");
                }
                num1 = doCalc(num1, num2, operator);
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert + jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            gui.textfield.setText("+");
        }
        if (e.getSource().equals(subButton)) {
            operator = '-';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                gui.textfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert - jel num2");
                }
                num1 = doCalc(num1, num2, operator);
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert - jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            gui.textfield.setText("-");
        }
        if (e.getSource().equals(mulButton)) {/*
            num1 = Double.parseDouble(gui.textfield.getText());
            operator = '*';
            gui.textfield.setText("");
            countDec = 0;
            }*/
            operator = '*';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                gui.textfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num2");
                    String tempNum = String.valueOf(gui.textfield.getText());
                    num2 = Double.parseDouble(tempNum.substring(1));
                    System.out.println(num2);
                    num1 = doCalc(num1, num2, operator);
                }
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            gui.textfield.setText("*");

        }
        if (e.getSource().equals(divButton)) {
            operator = '/';
            if (num1Exist && equalWasPushed) {        //Egyenlőség lenyomása után
                gui.textfield.setText("");
                countDec = 0;
            }
            if (num1Exist) {                         //Második szám beolvasás
                try {
                    num2 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num2");
                    String tempNum = String.valueOf(gui.textfield.getText());
                    num2 = Double.parseDouble(tempNum.substring(1));
                    System.out.println(num2);
                    num1 = doCalc(num1, num2, operator);
                }
                countDec = 0;
            }
            if (!num1Exist) {                          // Első szám beolvasás
                try {
                    num1 = Double.parseDouble(gui.textfield.getText());
                } catch (NumberFormatException exception) {
                    System.out.println("Ez nem double mert * jel num1");
                }
                num1Exist = true;
                countDec = 0;
            }
            gui.textfield.setText("/");
        }
        if (e.getSource().equals(negButton)) {
            num1 = Double.parseDouble(gui.textfield.getText());
            operator = '+';
            gui.textfield.setText("-");
            System.out.println(gui.textfield.getText());
        }


        if (e.getSource().equals(equButton)) {
            try {
                num2 = Double.parseDouble(gui.textfield.getText());   //Ha megnyomtad = akkor nem folytathatja a számot az eredmény után
                equalWasPushed = true;
                countDec = 0;
            } catch (NumberFormatException e2) {
                System.out.println("Cannot end with an operation sign");
                String tempNum = String.valueOf(gui.textfield.getText());
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
            String string = gui.textfield.getText();
            string = string.substring(0, string.length() - 1);
            gui.textfield.setText(string);

        }
        if (e.getSource() == clrButton) {
            gui.textfield.setText("");
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

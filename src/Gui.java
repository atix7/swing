import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    public static JTextField textfield;
    public JButton[] numberButtons = new JButton[10];
    public JButton[] functionButtons = new JButton[9];
    public JButton addButton, subButton, mulButton, divButton;
    public JButton decButton, equButton, delButton, clrButton, negButton;
    public JPanel panel;
    public Font myFont = new Font("Bauhaus 93", Font.PLAIN, 25);
    Gui() {
        super("Calculator");
        //frame = new JFrame("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(365, 520);
        setLayout(null);// there is no layout manager
        // System.out.println(dotAtTheEnd("1236."));  //***************************************************

        textfield = new JTextField();
        textfield.setBounds(25, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);

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
        frame.add(textfield);
        frame.setVisible(true);
    }
}

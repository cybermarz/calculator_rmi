import java.rmi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

public class MyClient implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[7];
    JButton addButton, subButton, mulButton, divButton;
    JButton equButton, delButton, clrButton;
    JPanel panel;
    Calculator stub;

    Font myFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);

    String num1 = "", num2 = "", result = "", errorMessage = "";
    char operator = '?';

    MyClient(Calculator stub) {
        this.stub = stub;

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        //Colors
        frame.getContentPane().setBackground(new Color(233, 126, 127));

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(new Color(86, 86, 90));
        textfield.setForeground(new Color(0, 0, 0));
        textfield.setBorder(new LineBorder(new Color(233, 126, 127)));

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        addButton.setForeground(new Color(255, 255, 255));
        addButton.setBackground(new Color(233, 126, 127));
        addButton.setBorder(new LineBorder(Color.BLACK));
        subButton.setForeground(new Color(255, 255, 255));
        subButton.setBackground(new Color(233, 126, 127));
        subButton.setBorder(new LineBorder(Color.BLACK));
        mulButton.setForeground(new Color(255, 255, 255));
        mulButton.setBackground(new Color(233, 126, 127));
        mulButton.setBorder(new LineBorder(Color.BLACK));
        divButton.setForeground(new Color(255, 255, 255));
        divButton.setBackground(new Color(233, 126, 127));
        divButton.setBorder(new LineBorder(Color.BLACK));
        equButton.setForeground(new Color(255, 255, 255));
        equButton.setBackground(new Color(233, 126, 127));
        equButton.setBorder(new LineBorder(Color.BLACK));
        delButton.setForeground(new Color(255, 255, 255));
        delButton.setBackground(new Color(233, 126, 127));
        delButton.setBorder(new LineBorder(Color.BLACK));
        clrButton.setForeground(new Color(255, 255, 255));
        clrButton.setBackground(new Color(233, 126, 127));
        clrButton.setBorder(new LineBorder(Color.BLACK));

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = delButton;
        functionButtons[6] = clrButton;

        for (int i = 0; i < 7; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setForeground(new Color(255, 255, 255));
            functionButtons[i].setBackground(new Color(233, 126, 127));
            functionButtons[i].setBorder(new LineBorder(Color.BLACK));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setForeground(new Color(255, 255, 255));
            numberButtons[i].setBackground(new Color(233, 126, 127));
            numberButtons[i].setBorder(new LineBorder(Color.BLACK));
        }

        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(233, 126, 127));

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
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);


    }

    public static void main(String args[]) {

        try {
            String port = args[0];
            Calculator stub = (Calculator) Naming.lookup("rmi://localhost:"+port+"/calculator");
            MyClient calc = new MyClient(stub);
        } catch (Exception e) {
            System.out.println("Client exception: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                String str = textfield.getText();
                if (str.equals("0") || str.equals(result)
                        || (!errorMessage.equals(""))) {
                    errorMessage = "";
                    textfield.setText(String.valueOf(i));
                } else {
                    if(str.length() < 9) {
                        textfield.setText(str.concat(String.valueOf(i)));
                    }
                }
            }
        }
        if (e.getSource() == addButton) {
            if (errorMessage.equals("")) {
                String str = textfield.getText();
                if (!str.equals("")) {
                    num1 = str;
                }
                operator = '+';
                textfield.setText("");
            }
        }
        if (e.getSource() == subButton) {
            if (errorMessage.equals("")) {
                String str = textfield.getText();
                if (!str.equals("")) {
                    num1 = str;
                }
                operator = '-';
                textfield.setText("");
            }
        }
        if (e.getSource() == mulButton) {
            if (errorMessage.equals("")) {
                String str = textfield.getText();
                if (!str.equals("")) {
                    num1 = str;
                }
                operator = '*';
                textfield.setText("");
            }
        }
        if (e.getSource() == divButton) {
            if (errorMessage.equals("")) {
                String str = textfield.getText();
                if (!str.equals("")) {
                    num1 = str;
                }
                operator = '/';
                textfield.setText("");
            }
        }
        if (e.getSource() == equButton) {
            if (errorMessage.equals("") && !textfield.getText().equals("")) {
                num2 = textfield.getText();
                if(operator == '?'){
                    result = num2;
                    textfield.setText(result);
                    num1 = result;
                } else {
                    try {
                        errorMessage = stub.checkOperand(num1, num2);
                        if (errorMessage.equals("")) {
                            result = stub.calculate(operator, Integer.parseInt(num1), Integer.parseInt(num2));

                            errorMessage = stub.checkResult(result);
                        }
                        if (errorMessage.equals("")) {
                            textfield.setText(result);
                            num1 = result;
                        } else {
                            textfield.setText(errorMessage);
                        }
                        num2 = "";
                        operator = '?';

                    } catch (RemoteException ex) {
                        System.out.println("Remote exception: " + ex);
                    }
                }
            }
        }
        if (e.getSource() == clrButton) {
            textfield.setText("");
            num1 = "";
            num2 = "";
            operator = '?';
            errorMessage = "";
        }
        if (e.getSource() == delButton) {
            String str = textfield.getText();
            textfield.setText("");
            if (errorMessage.equals("")) {
                for (int i = 0; i < str.length() - 1; i++) {
                    textfield.setText(textfield.getText() + str.charAt(i));
                }
            }
            errorMessage = "";
        }
    }
}



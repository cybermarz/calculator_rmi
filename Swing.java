import javax.swing.*;
import java.awt.event.*;

public class Swing {
    public static void main(String args[]){
        JFrame f = new JFrame("Button Example");
        JTextField tf = new JTextField();
        tf.setBounds(50,50, 150,40);
        JLabel l=new JLabel("Label");
        l.setBounds(50,30, 250,20);
        JButton b1=new JButton("1");
        JButton b2=new JButton("2");
        JButton b3=new JButton("3");
        JButton b4=new JButton("4");
        JButton b5=new JButton("5");
        JButton b6=new JButton("6");
        JButton b7=new JButton("7");
        JButton b8=new JButton("8");
        JButton b9=new JButton("9");

        b1.setBounds(25,100,60,30);
        b2.setBounds(95,100,60,30);
        b3.setBounds(165,100,60,30);
        b4.setBounds(25,140,60,30);
        b5.setBounds(95,140,60,30);
        b6.setBounds(165,140,60,30);
        b7.setBounds(25,180,60,30);
        b8.setBounds(95,180,60,30);
        b9.setBounds(165,180,60,30);
        /*b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tf.setText("Welcome to JavaPoint.");
            }
        });*/
        f.add(b1); f.add(b2); f.add(b3);
        f.add(b4); f.add(b5); f.add(b6);
        f.add(b7); f.add(b8); f.add(b9);
        f.add(tf);
        f.add(l);
        f.setSize(250,400);
        f.setLayout(null);
        f.setVisible(true);
    }
}

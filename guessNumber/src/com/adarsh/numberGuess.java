package com.adarsh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class numberGuess {
    JFrame f = new JFrame();
    Random rand = new Random();
    Integer x = rand.nextInt(99);
    JLabel l1 = new JLabel("Enter A Number");
    JButton b = new JButton("SUBMIT");
    JLabel l2 = new JLabel("You Have");
    JLabel l3 = new JLabel("5");
    JLabel l4 = new JLabel("Attempts Left");
    JTextField jf1 = new JTextField();

    numberGuess(){
        guiInter();
        comp();
    }
    public void guiInter(){
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setVisible(true);
        f.setSize(400,300);
        f.getContentPane().setBackground(Color.LIGHT_GRAY);
        f.setTitle("Number Guess");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void comp(){
        l1.setBounds(50,50,120,40);
//        l.setBackground(Color.PINK);
//        l.setOpaque(true);
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        f.add(l1);

        l2.setBounds(155,92,58,20);
        f.add(l2);
        l3.setBounds(215,92,10,20);
        f.add(l3);
        l4.setBounds(227,92,100,20);
        f.add(l4);

        jf1.setBounds(172,50,120,40);
        jf1.setBackground(Color.YELLOW);
        f.add(jf1);
        jf1.setHorizontalAlignment(SwingConstants.RIGHT);

        b.setBounds(150,130,100,40);
        f.add(b);
        b.setBackground(Color.WHITE);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Integer guess = Integer.parseInt(jf1.getText());
                    Integer count = Integer.parseInt(l3.getText());
                    int i;
                    for(i = 0; i < count ; i++) {
                        if (guess > x) {
                            JOptionPane.showMessageDialog(f, "You Guess Larger Number Than Original");
                            count--;
                            l3.setText(String.valueOf(count));
                            break;
                        } else if (guess < x) {
                            JOptionPane.showMessageDialog(f, "You Guess Number Smaller Than Original");
                            count--;
                            l3.setText(String.valueOf(count));
                            break;
                        } else if (guess == x) {
                            JOptionPane.showMessageDialog(f, "You Guess Correct Number");
                            count--;
                            l3.setText(String.valueOf(count));
                            break;
                        }
                    }if (i == count) {
                        JOptionPane.showMessageDialog(f, "OOps!! You Have No Chances Remaining " + x + " Was Correct Number");
                    }
                }catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        numberGuess ngg = new numberGuess();
    }
}

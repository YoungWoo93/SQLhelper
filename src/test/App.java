package test;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) {
        JFrame fr = new JFrame("This 프레임");
        JPanel pn = new JPanel();
        JButton[] bt = new JButton[5];

        BorderLayout fl = new BorderLayout();
        pn.setLayout(fl);

        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton("Button" + i);
        //    pn.add(bt[i]);
        }

        pn.add(bt[0], BorderLayout.NORTH);
        pn.add(bt[1], BorderLayout.EAST);
        pn.add(bt[2], BorderLayout.CENTER);
        pn.add(bt[3], BorderLayout.WEST);
        pn.add(bt[4], BorderLayout.SOUTH);

        fr.setContentPane(pn);

        fr.setSize(400, 300);
        fr.setVisible(true);
    }
}
package test;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
public class testpen1 extends JPanel {

	/**
     *
     */
    private static final long serialVersionUID = 1L;
    public JLabel jtestlabel;
    public JPanel jtestpanel;

    testpen1(){
        jtestlabel = new JLabel("test1 pen");
        jtestpanel = new JPanel();

        jtestpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jtestpanel.add(jtestlabel);

        add(jtestpanel);

        setSize(100, 50);
    }
}
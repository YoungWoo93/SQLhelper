package DBhelper.Frame.WorkSpace.SideSpace;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.*;

import DBhelper.*;

public class CombineFunctionComponent extends JPanel{
    Model model;
    Cantrol controller;

    CombineFunctionComponent(Model m, Cantrol c) {
		model = m;
        controller = c;
        
        setBorder(new LineBorder(Color.black,1));
        JLabel jtestlabel = new JLabel("CombineFunctionComponent");
        
        add(jtestlabel);
    }
}
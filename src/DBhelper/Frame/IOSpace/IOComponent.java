package DBhelper.Frame.IOSpace;

import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.*;

import DBhelper.*;

public class IOComponent extends JPanel{
    public QueryComponent queryComponent;
    public SQLOutComponent sqlOutComponent;
    
    Model model;
    Cantrol controller;

    public IOComponent(Model m, Cantrol c) {
		model = m;
        controller = c;
        c.IOView = this;
        //JLabel jtestlabel = new JLabel("WorkComponent");
        //add(jtestlabel);
        setLayout(new GridLayout(1,2));
        setBorder(new LineBorder(Color.black,1));
        queryComponent = new QueryComponent(m,c);
        sqlOutComponent = new SQLOutComponent(m,c);

       
        add(sqlOutComponent);
        add(queryComponent);
        
        System.out.println(sqlOutComponent.GetText());
    
        System.out.println(queryComponent.GetText());

        
    }
}
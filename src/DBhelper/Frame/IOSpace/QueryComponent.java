package DBhelper.Frame.IOSpace;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.*;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import DBhelper.*;




public class QueryComponent extends JPanel{
    public JTextArea ta;
    public Model model;
    public Cantrol controller;

    public JPanel btPanel;
    public JScrollPane taScrollPanel;
    public JButton bConnect;
    public JButton bCommit;
    public JButton bRunAll;
    public JButton bRunLine;

    QueryComponent(Model m, Cantrol c) {
        model = m;
        controller = c;

        setLayout(new BorderLayout());
    
        ta = new JTextArea(7,20);
        ta.setLineWrap(true);
        
        btPanel = new JPanel();
        taScrollPanel = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        bConnect = new JButton("▣");
        bConnect.addActionListener(controller);
        bCommit = new JButton("▲");
        bCommit.addActionListener(controller);
        bRunAll = new JButton("▶");
        bRunAll.addActionListener(controller);
        bRunLine = new JButton("≫");
        bRunLine.addActionListener(controller);
        
        ta.setBorder(new LineBorder(Color.black,1));
        btPanel.setBorder(new LineBorder(Color.black,1));
        btPanel.setLayout(new BoxLayout(btPanel,BoxLayout.X_AXIS));
        btPanel.add(bConnect);
        btPanel.add(bCommit);
        btPanel.add(bRunAll);
        btPanel.add(bRunLine);

        
        add(btPanel, BorderLayout.NORTH);
        add(taScrollPanel, BorderLayout.CENTER);

    }

    public String GetText(){
        return ta.getText();
    }

    public void SetText(String _str){
        ta.setText(_str);
    }
}


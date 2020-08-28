package DBhelper.Frame.IOSpace;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.*;
import javax.swing.JScrollPane;

import DBhelper.*;

// 출력후 아래로 스크롤할땐 https://unikys.tistory.com/211 참고
public class SQLOutComponent extends JPanel{
    JTextArea ta;
    Model model;
    Cantrol controller;

    SQLOutComponent(Model m, Cantrol c) {
		model = m;
        controller = c;
        
        setLayout(new GridLayout());
        setBorder(new LineBorder(Color.black,1));
        ta = new JTextArea(7,20); 
        ta.setLineWrap(true);
        ta.setEditable(false);
        JScrollPane taScrollPanel = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        add(taScrollPanel);
        ta.setText("SQL 질의 결과 출력");
    }

    public String GetText(){
        return ta.getText();
    }

    public void SetText(String _str){
        ta.setText(_str);
    }
}
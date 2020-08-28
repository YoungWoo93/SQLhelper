package DBhelper.Frame.WorkSpace;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import DBhelper.*;
import DBhelper.Frame.WorkSpace.TableSpace.*;
import DBhelper.Frame.WorkSpace.SideSpace.*;


public class WorkComponent extends JPanel{
    public JSplitPane workComponent;
    public JPanel sideComponent;
    public JPanel tableComponent;
    
    Model model;
    Cantrol controller;
    
    public WorkComponent(Model m, Cantrol c){
        model = m;
        controller = c;

        c.WorkView = this;
        
        //JLabel jtestlabel = new JLabel("WorkComponent");
        //add(jtestlabel);
        setLayout(new GridLayout(1,1));
        sideComponent = new SideComponent(m,c);
        tableComponent = new TableComponent(m,c);

        workComponent = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sideComponent ,tableComponent);
        workComponent.setOneTouchExpandable(true);
        workComponent.setDividerLocation(300); // 기본 300px 위치 초기화
        workComponent.setResizeWeight (0); //창이 확장될때 좌0% 우 100% 비율로 커진 공간을 이용함
        Dimension minimumSize = new Dimension(100, 50); // 최소 크기 지정
        sideComponent.setMinimumSize(minimumSize);
        tableComponent.setMinimumSize(minimumSize);

        add(workComponent);
    }

    public JPanel getTableComponet(){
        return tableComponent;
    }
}
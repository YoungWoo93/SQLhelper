package DBhelper.Frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import DBhelper.*;
import DBhelper.Frame.IOSpace.IOComponent;
import DBhelper.Frame.WorkSpace.WorkComponent;


public class MainFrame extends JFrame{
    Model model;
    Cantrol comtroller;
    
    private JSplitPane mainFrame;
    public JPanel workComponent;
    public JPanel ioComponent;

    public MainFrame(Model m, Cantrol c){
        model = m;
        comtroller = c;

        workComponent = new WorkComponent(m,c);
        ioComponent = new IOComponent(m,c);

        mainFrame = new JSplitPane(JSplitPane.VERTICAL_SPLIT, workComponent ,ioComponent);
        mainFrame.setOneTouchExpandable(true);
        mainFrame.setDividerLocation(0.75); // 기본 150px 위치 초기화
        mainFrame.setResizeWeight (0.75); //창이 확장될때 좌0% 우 100% 비율로 커진 공간을 이용함
        Dimension minimumSize = new Dimension(100, 50);
        workComponent.setMinimumSize(minimumSize);
        ioComponent.setMinimumSize(minimumSize);
        
        add(mainFrame);

    }
    public static void main(String[] args) throws Exception {
        
    }
}
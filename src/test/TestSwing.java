package test;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

public class TestSwing {
    public static void main(String[] args) {
        JFrame fr = new JFrame("This 프레임");
        JPanel pn = new JPanel();
        JButton[] bt = new JButton[5];

        JLabel jMainLabel;
        JLabel jMenuLabel;
        JLabel jBottomLabel;

        JPanel jTopPanel;
        testpen1 jWestPanel;
        JPanel jCenterPanel;
        JPanel jBottomPanel;

        JSplitPane spHorizonPanel;
        JSplitPane spVerticalPanel;

        for (int i = 0; i < bt.length; i++) {
            bt[i] = new JButton("Button" + i);
        }


        BorderLayout fl = new BorderLayout();
        pn.setLayout(fl);

        jMainLabel = new JLabel("Center table");
        jMenuLabel = new JLabel("menu bar");
        jBottomLabel = new JLabel("bottom I/O board");
        
        jTopPanel = new JPanel();
        jWestPanel = new testpen1();
        jCenterPanel = new JPanel();
        jBottomPanel = new JPanel();

        jTopPanel.add(jMenuLabel);
        jCenterPanel.add(jMainLabel);
        jBottomPanel.add(jBottomLabel);

        spHorizonPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jWestPanel ,jCenterPanel);
        spHorizonPanel.setOneTouchExpandable(true);
        spHorizonPanel.setDividerLocation(150); // 기본 150px 위치 초기화
        spHorizonPanel.setResizeWeight (0.0); //창이 확장될때 좌0% 우 100% 비율로 커진 공간을 이용함
        Dimension minimumSize = new Dimension(100, 50);
        jWestPanel.setMinimumSize(minimumSize);
        jCenterPanel.setMinimumSize(minimumSize);

        spVerticalPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, spHorizonPanel ,jBottomPanel);
        spVerticalPanel.setOneTouchExpandable(true);
        spVerticalPanel.setDividerLocation(300); // 기본 300px 위치 초기화
        spVerticalPanel.setResizeWeight (0.75); //창이 확장될때 상75% 허 25% 비율로 커진 공간을 이용함
        

        pn.add(jTopPanel, BorderLayout.NORTH);
        //pn.add(jWestPanel, BorderLayout.WEST);
        pn.add(spVerticalPanel, BorderLayout.CENTER);

        // pn.add(bt[0], BorderLayout.NORTH);
        // pn.add(bt[1], BorderLayout.EAST);
        // pn.add(bt[2], BorderLayout.CENTER);
        // pn.add(bt[3], BorderLayout.WEST);
        // pn.add(bt[4], BorderLayout.SOUTH);

        fr.setContentPane(pn);

        fr.setSize(750, 500);
        fr.setVisible(true);
    }
}
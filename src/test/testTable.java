package test;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class testTable {
	
	private JFrame frame;
	private JPanel wrapper_panel;
	
	private JTable tableView;
	private JScrollPane scrollList;
	
	public testTable() {
		
		frame = new JFrame("ClassData");
		
		
		setLayout();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void setLayout()
	{
		wrapper_panel = new JPanel(new BorderLayout());
		
		String colNames[] = {"이름", "번호"};
		String dataSet[][] = {
            {"test1", "1"},
            {"test2", "2"},
            {"test3", "3"},
        };
		tableView = new JTable(dataSet, colNames);
		scrollList = new JScrollPane(tableView);
		wrapper_panel.add(scrollList,BorderLayout.CENTER);
		frame.add(wrapper_panel);
		
	}
	
	public static void main(String[] args) {
		testTable ttest = new testTable();
	}
	
	
}
package DBhelper.Frame.WorkSpace.TableSpace;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import DBhelper.*;
import DBhelper.DataBase.*;

// 테이블 헤더 클릭 반응은
// https://www.codejava.net/java-se/swing/how-to-handle-mouse-clicking-event-on-jtable-column-header
// 참고
public class TableComponent extends JPanel{
	private JPanel wrapper_panel;
    private final JTabbedPane pane = new JTabbedPane();

	Model model;
	Cantrol controller;
	
	public TableComponent(Model m, Cantrol c) {
		model = m;
		controller = c;

		c.TableTabView = this;

		setLayout(new GridLayout(1,1));
		wrapper_panel = new JPanel(new GridLayout(1,1));
		

		pane.removeAll();

		wrapper_panel.add(pane);
		add(wrapper_panel);

	}

	public JScrollPane CreateTestScrollTable(){
		String colNames[] = {"이름", "번호"};
		String dataSet[][] = {
            {"test1", "1"},
            {"test2", "2"},
            {"test3", "3"},
        };
		return new JScrollPane( new JTable(dataSet, colNames));
	}
	public JScrollPane CreateScrollTable(SqlTable table){
		Vector<String> colNames = table.getHeaderNames();
		Vector<Vector<String>> dataSet = table.getData();
		
		return new JScrollPane( new JTable(dataSet, colNames));
	}

	public void AddTab(String tabName){
		pane.add(tabName, CreateScrollTable(model.getTable(tabName)));
		pane.setTabComponentAt(pane.getTabCount()-1, new TableItem(pane));
		ChanageTab();
	}

	public int FindTab(String tabName){
		for (int i=0; i<pane.getTabCount(); i++){
			if(pane.getTitleAt(i).equals(tabName)){
				return i;
			}
		}
			
		return -1;
	}

	public void ChanageTab(int index){
		pane.setSelectedIndex(index);
	}
	
	public void ChanageTab(){
		pane.setSelectedIndex(pane.getTabCount()-1);
	}
}
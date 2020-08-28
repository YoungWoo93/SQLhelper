package DBhelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;
import javax.swing.tree.TreePath;

import DBhelper.*;
import DBhelper.Frame.MainFrame;
import DBhelper.Frame.IOSpace.*;
import DBhelper.Frame.WorkSpace.*;
import DBhelper.Frame.WorkSpace.SideSpace.*;
import DBhelper.Frame.WorkSpace.TableSpace.TableComponent;

public class Cantrol implements ActionListener, MouseInputListener {
    public MainFrame MainView;
    public IOComponent IOView;
    public WorkComponent WorkView;
    public SideComponent SideView;
    public DBStructureComponent DBTreeView;
    public TableComponent TableTabView;

    public Model model;

    public Cantrol(final Model m) {
        model = m;
    }

    public void userAction() {

    }

    @Override
    public void actionPerformed(final ActionEvent e) {

        if (e.getSource() == IOView.queryComponent.bCommit) {
            IOView.sqlOutComponent.SetText(model.RunSQL("commit;"));
            System.out.println("quertComponent commit 버튼 눌림");
        } else if (e.getSource() == IOView.queryComponent.bConnect) {
            IOView.sqlOutComponent.SetText("quertComponent connect 버튼 눌림");
            System.out.println("quertComponent connect 버튼 눌림");
        } else if (e.getSource() == IOView.queryComponent.bRunAll) {
            IOView.sqlOutComponent.SetText(model.RunSQL(IOView.queryComponent.GetText()));
            System.out.println("quertComponent runall 버튼 눌림");
        } else if (e.getSource() == IOView.queryComponent.bRunLine) {
            IOView.sqlOutComponent.SetText(model.RunSQL2(IOView.queryComponent.GetText()));
            System.out.println("quertComponent runline 버튼 눌림");
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(final MouseEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == DBTreeView.DBTree){
            int selRow = DBTreeView.DBTree.getRowForLocation(e.getX(), e.getY());
            TreePath selPath = DBTreeView.DBTree.getPathForLocation(e.getX(), e.getY());
            if(selRow != -1) {
                if(e.getClickCount() == 1) {
                    //System.out.println("클릭 :" + selPath);
                    if(selPath.getPathCount() == 2)
                    DBTreeView.TableOpen(selPath);
                }
                else if(e.getClickCount() == 2) {
                    //System.out.println("더블 클릭 :" + selPath);
                    
                    
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
package DBhelper.Frame.WorkSpace.SideSpace;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ResourceBundle.Control;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.border.*;

import DBhelper.*;

public class DBStructureComponent extends JPanel {
    private Model model;
    private Cantrol controller;

    public JTree DBTree;
    // https://bestugi.tistory.com/34 참고

    public DBStructureComponent(Model m, Cantrol c) {
        model = m;
        controller = c;
        c.DBTreeView = this;
        
        setBorder(new LineBorder(Color.black, 1));

        DBTree = new JTree(model.getTree());

        setLayout(new BorderLayout());
        add(DBTree);

        DBTree.addMouseListener(controller);


        // MouseListener ml = new MouseAdapter() {
        //     public void mousePressed(MouseEvent e) {
        //         int selRow = DBTree.getRowForLocation(e.getX(), e.getY());
        //         TreePath selPath = DBTree.getPathForLocation(e.getX(), e.getY());
        //         if(selRow != -1) {
        //             if(e.getClickCount() == 1) {
        //                 //System.out.println("클릭 :" + selPath);
        //                 if(selPath.getPathCount() == 2)
        //                     TableOpen(selPath);
        //             }
        //             else if(e.getClickCount() == 2) {
        //                 //System.out.println("더블 클릭 :" + selPath);
                        
                        
        //             }
        //         }
        //     }
        // };
        // DBTree.addMouseListener(ml);

    }



    public void TableOpen(TreePath path){
        String name = path.getLastPathComponent().toString();
    
        System.out.println("테이블 " + path.getLastPathComponent().toString());

        if(controller.TableTabView.FindTab(name) == -1)
            controller.TableTabView.AddTab(name);
        else
            controller.TableTabView.ChanageTab(controller.TableTabView.FindTab(name));
    }
}

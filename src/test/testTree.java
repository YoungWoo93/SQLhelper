package test;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class testTree {
 JFrame myFrame;
 
 public testTree(String title){
  myFrame = new JFrame(title);
  Container con = myFrame.getContentPane();
  
  DefaultMutableTreeNode root = new DefaultMutableTreeNode("DATABASE"); 
  DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("테이블1");
  DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("테이블2");
  DefaultMutableTreeNode child1_child1 = new DefaultMutableTreeNode("애트리뷰트 리스트");
  DefaultMutableTreeNode child1_child2 = new DefaultMutableTreeNode("튜플 리스트");
  
  DefaultMutableTreeNode child1_child1_child1 = new DefaultMutableTreeNode("번호");
  DefaultMutableTreeNode child1_child1_child2 = new DefaultMutableTreeNode("이름");

  root.add(child1); root.add(child2);
  child1.add(child1_child1); child1.add(child1_child2);
  child1_child1.add(child1_child1_child1); child1_child1.add(child1_child1_child2);
  JTree myTree = new JTree(root);
  con.setLayout(new BorderLayout());
  con.add(myTree);
  
  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  myFrame.setSize(300, 200);
  myFrame.setVisible(true);
 }
 
 public static void main(String[] args) {
    testTree t = new testTree("트리만들기");
 }
}

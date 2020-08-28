package DBhelper;

import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;

import DBhelper.DataBase.*;

public class Model {
    MySqlDB db;
    SqlTable table;

    Model(){
        DBconnect();
    }

    public void DBconnect(){
        db = new MySqlDB("localhost/kbs", "root", "1234");
    }

    public SqlTable getTable(String tableName){
        if(!db.IsConnect()){
            System.out.println("getTable error, without db connect check");
            return null;
        }

        return db.getTable(tableName);
        
    }

    public DefaultMutableTreeNode getTree(){

        if(!db.IsConnect()){
            System.out.println("getTree error, without db connect check");
            return null;
        }

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(db.getURL());

        Vector<String> tableList = db.getTableList();
        for(int i=0; i<tableList.size(); i++){
            DefaultMutableTreeNode tableNode = new DefaultMutableTreeNode(tableList.elementAt(i));
            DefaultMutableTreeNode tableRows = new DefaultMutableTreeNode("레코드");
            DefaultMutableTreeNode tableCols = new DefaultMutableTreeNode("속성");
            root.add(tableNode);
            tableNode.add(tableRows);
            tableNode.add(tableCols);


            SqlTable temp = db.getTable(tableList.elementAt(i));
            Vector<String> dataList = temp.getDataNames();
            Vector<String> headerList = temp.getHeaderNames();

            for(int j=0; j<dataList.size(); j++){
                tableRows.add(new DefaultMutableTreeNode(dataList.elementAt(j)));
            }
            
            for(int j=0; j<headerList.size(); j++){
                tableCols.add(new DefaultMutableTreeNode(headerList.elementAt(j)));
            }
        }
        
        return root;
    }

    public String RunSQL(String sql){
        return db.RunSql(sql);
    }

    public String RunSQL2(String sql){
        return db.RunSql2(sql);
    }
}
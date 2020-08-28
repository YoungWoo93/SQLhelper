package DBhelper.DataBase;

import java.sql.*;
import java.util.Vector;

public class MySqlDB {
    private boolean ConnectFlag;
    private String URL; //"localhost/kbs";
    private String ID; // "root"
    private String PW; // "1234"


    
    public MySqlDB(){
        ConnectFlag = false;
    }
    
    public MySqlDB(String url, String id, String pw){
        ConnectFlag = ConnectCheck(url, id, pw);

        if(ConnectFlag){
            URL = url;
            ID = id;
            PW = pw;
        }
    }

    public boolean IsConnect(){
        return ConnectFlag;
    }
    
    public boolean ConnectCheck(){
        Connection conn = null;
        boolean retFlag = false;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + URL + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", ID, PW);
            System.out.println("connect... ok");

            retFlag = true;
            ConnectFlag = true;

        }
        catch(ClassNotFoundException e){
            System.out.println("Error " + e);
            System.out.println("Driver loading failed");
        }
        catch(SQLException e){
            System.out.println("Error " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        
        return retFlag;
    }

    public boolean ConnectCheck(String url, String id, String pw){
        Connection conn = null;
        boolean retFlag = false;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", id, pw);
            System.out.println("connect... ok");

            URL = url;
            ID = id;
            PW = pw;
            retFlag = true;
            ConnectFlag = true;
        }
        catch(ClassNotFoundException e){
            System.out.println("Driver loading failed");
        }
        catch(SQLException e){
            System.out.println("Error " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        
        return retFlag;
    }

    public String RunSql(String sql){
        String ret;

        Connection conn = null;
        Statement state = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/kbs";
            conn = DriverManager.getConnection(url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
            System.out.println("connect... ok");

            state = conn.createStatement();

            ResultSet rs = state.executeQuery(sql);
            
            ret = rs.getMetaData().toString();

        }
        catch(ClassNotFoundException e){
            System.out.println("Driver loading failed");
            ret = e.toString();
        }
        catch(SQLException e){
            System.out.println("Error " + e);
            ret = e.toString();
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }

        return ret;
    }

    public String RunSql2(String sql){
        String ret;

        Connection conn = null;
        Statement state = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/kbs";
            conn = DriverManager.getConnection(url + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
            System.out.println("connect... ok");

            state = conn.createStatement();

            int rs = state.executeUpdate(sql);
            
            if(rs == 1)
                ret = "success";
            else
                ret = "fail";

        }
        catch(ClassNotFoundException e){
            System.out.println("Driver loading failed");
            ret = e.toString();
        }
        catch(SQLException e){
            System.out.println("Error " + e);
            ret = e.toString();
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }

        return ret;
    }

    public Vector<String> getTableList(){
        Vector<String> reTemp = new Vector<String>();

        if(!ConnectFlag){
            System.out.println("require ConnectCheck first");
            return null;
        }
                
        Connection conn = null;
        Statement state = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + URL + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", ID, PW);
            state = conn.createStatement();

            // https://bestugi.tistory.com/34 참고
            //
            ResultSet rs = conn.getMetaData().getTables(null, "OWN1", null, new String[]{"TABLE"}); 
            while(rs.next()) { 
                reTemp.add(new String(rs.getString("TABLE_NAME"))); 
            }


        }
        catch(ClassNotFoundException e){
            System.out.println("Driver loading failed");
        }
        catch(SQLException e){
            System.out.println("Error " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        
        return reTemp;
    }

    public SqlTable getTable(String tableName){
        SqlTable reTemp = new SqlTable();

        if(!ConnectFlag){
            System.out.println("require ConnectCheck first");
            return null;
        }
                
        Connection conn = null;
        Statement state = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + URL + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", ID, PW);
            state = conn.createStatement();

            ResultSet rs;

            rs = conn.getMetaData().getColumns(null, "OWN1", tableName, "%");

            int cntcol = 0, cntrow = 0;
            
            while(rs.next()) { 
                cntcol++;
                reTemp.AddHeaderInfo(rs.getString("COLUMN_NAME"), rs.getString("TYPE_NAME"), Integer.toString(rs.getInt("CHAR_OCTET_LENGTH")) , Integer.toString(rs.getInt("COLUMN_SIZE")));
            }
            reTemp.setColSize(cntcol);

            rs = state.executeQuery("select * from " + tableName + ";");
            Vector<String[]> header = reTemp.getHeaderInfo();
            
            
            while(rs.next()){
                String[] data = new String[cntcol];

                for(int i=0; i<cntcol; i++){
                    data[i] = new String(rs.getString(header.elementAt(i)[0]));
                }
                reTemp.AddData(data);
                cntrow++;
            }
            reTemp.setColSize(cntrow);

           

            // https://bestugi.tistory.com/34 참고
            //
            // ResultSet rs = state.executeQuery("show tables");
            // while(rs.next()){
            //     System.out.println("pNo : " + rs.getInt("pNo"));
            //     System.out.println("INT_VALUE : " + rs.getString("INT_VALUE"));
            //     System.out.println("STR_VALUE1 : " + rs.getString("STRING_VALUE1"));
            //     System.out.println("STR_VALUE2 : " + rs.getString("STRING_VALUE2"));
            //     System.out.println("STR_VALUE3 : " + rs.getString("STRING_VALUE3"));
            //     System.out.println();
            //     System.out.println();
            // }

        }
        catch(ClassNotFoundException e){
            System.out.println("Driver loading failed");
        }
        catch(SQLException e){
            System.out.println("Error " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
        
        return reTemp;
    }

    public String getURL(){
        return URL;
    }

    public String getID(){
        return ID;
    }

    public String getPW(){
        return PW;
    }
}
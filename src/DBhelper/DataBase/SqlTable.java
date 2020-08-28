package DBhelper.DataBase;

import java.util.Vector;


public class SqlTable {
    Vector<Vector<String>> Data;
    Vector<String[]> HeaderInfo;
    int colSize, rowSize;

    public SqlTable(){
        Data = new Vector<Vector<String>>();
        HeaderInfo = new Vector<String[]>();
    }

    public void AddHeaderInfo(String COLUMN_NAME, String TYPE_NAME, String CHAR_OCTET_LENGTH, String COLUMN_SIZE){
        String temp[] = new String[4];
        temp[0] = COLUMN_NAME;
        temp[1] = TYPE_NAME;
        temp[2] = CHAR_OCTET_LENGTH;
        temp[3] = COLUMN_SIZE;

        HeaderInfo.add(temp);
    }

    public void AddData(String[] data){
        Vector<String> temp = new Vector<String>();
        for(int i = 0; i<data.length; i++){
            temp.add(data[i]);
        }
            
        Data.add(temp);
    }

    public void AddData(Vector<String> data){
        Data.add(data);
    }




    public void setHeaderInfo(Vector<String[]> header){
        HeaderInfo = header;
    }
    
    public void setHeaderInfo(int index, String[] header){

        if(HeaderInfo.get(index).length != header.length)
            System.out.println("setHeaderInfo Length mismatch");

        for(int i=0; i<header.length; i++)
            HeaderInfo.get(index)[i] = header[i];
        
    }

    public Vector<String[]> getHeaderInfo(){
        return HeaderInfo;
    }

    public String[] getHeaderInfo(int index){
        return HeaderInfo.elementAt(index);
    }

    public Vector<String> getHeaderNames(){
        Vector<String> ret = new Vector<String>(colSize);

        for(int i=0; i<HeaderInfo.size(); i++)
            ret.add("[" + new String(HeaderInfo.get(i)[1]) + "] " + new String(HeaderInfo.get(i)[0]));

        return ret;
    }


    public void setData(Vector<Vector<String>> data){
        Data = data;
    }

    public Vector<Vector<String>> getData(){
        return Data;
    }
    
    public Vector<String> getData(int index){
        return Data.get(index);
    }

    public Vector<String> getDataNames(){ // 현재 맨 앞 값을 가져옴, 기본키를 가져오게 개선 필요
        Vector<String> ret = new Vector<String>(rowSize);

        for(int i=0; i<Data.size(); i++)
            ret.add(new String(Data.get(i).get(0)));

        return ret;
    }

    public void setRowSize(int size){
        rowSize = size;
    }
    
    public int getRowSize(){
        return rowSize;
    }

    public void setColSize(int size){
        colSize = size;
    }
    
    public int getColSize(){
        return colSize;
    }
}
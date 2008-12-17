/*
 * LinkDB.java
 *
 * Created on January 7, 2003, 4:48 PM
 */

package usefulClasses.databaseOperations;  

/**
 *
 * @author  Administrator
 */

import usefulClasses.generalUtilities.*;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;


public class LinkDB extends javax.swing.JFrame{

  //VARIABLE DECLARATION 
	
//	private static final String HOST ="122.166.21.123";
	private static final String HOST ="localhost";
	
	private static final String CONN = "jdbc:mysql://" +HOST+
			"/paawakco_neoinventory?user=paawakco_paawak&password=paawak";
    
    Connection con;
    
    public int no_of_cols=0;
    
    HandleError err = new HandleError();
    
    Statement stat;
    
    String tableName;
    
    String[] allColNames;
    
    public LinkDB(String tableName) {
        this.tableName=tableName;
        getAllColNames();
    }
    
    public LinkDB() {
    	accessDB();
    }
    
    /*public LinkDB(String tableName,String userName, String password) {//constructor
        this.tableName=tableName;
        this.userName = userName;
        this.password = password;
        getAllColNames();
    }   */ 
    
    /*public void accessDB() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=DriverManager.getConnection("jdbc:odbc:sha");
            stat=con.createStatement();
        }//end try
        catch(Exception e) {
            err.displayError("class LinkDB, methd. accessDB() from table "+tableName,e);
        }//end catch
    }//*/
    
    private void accessDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost/neoinventory?user=root&password=agnimitra");
            con=DriverManager.getConnection(CONN);
            stat=con.createStatement();
        }//end try
        catch(Exception e) {
            err.displayError("class LinkDB, methd. accessDB() from table "+tableName,e);
        }//end catch
    }
    
    public Connection getConnection(){
    	accessDB();
        
        return con;
    }
    
    
    public void getAllColNames() {
        try{
            
            accessDB();
            
            String   ss="SELECT * FROM "+tableName;
            ResultSet res = stat.executeQuery(ss);
            ResultSetMetaData md = res.getMetaData();
            no_of_cols=md.getColumnCount();
            allColNames=new String[no_of_cols+1];
            allColNames[0]="null";
            for(int i=1;i<=no_of_cols;i++)
                allColNames[i]=md.getColumnName(i);
            con.close();
        }//end try
        catch(Exception e){
            err.displayError("class LinkDB, methd. getAllColNames() from table "+tableName,e);
                    }//end catch
        
    }
    
    public String addData(int[] colNos, Object[] val) {//whereClause can be an empty String
        
        String ss="";
        if(colNos.length!= val.length)
            JOptionPane.showMessageDialog(this," Value-List not matching with the no. of Columns.\nNo. of columns = "+colNos.length+"\tNo. of values to be inserted = "+val.length+": Make sure that they are equal.","Error in the addData method of LinkDB class using Database Table "+tableName+":",JOptionPane.ERROR_MESSAGE);
        else{//main else
            String names="",values="";
            try{
            for(int i=0;i<val.length;i++){
                names+=allColNames[colNos[i]];
                values+="'"+val[i]+"'";
                if(i!=val.length-1){
                    names+=",";
                    values+=",";
                }//end if
            }//end for
            }//end try
            catch(Exception e){
                err.displayError("class LinkDB, methd. addData() from table "+tableName,e);
                            }//end catch
            
            ss="INSERT INTO  " + tableName + " (" +names+ ") VALUES "+" ("+values+") ";
        }//end main else
        return ss;
        
    }
    
   public String addData(String[] col_Names,Object[] val) {
       
        String ss="";
        if(col_Names.length!= val.length)
            JOptionPane.showMessageDialog(this," Value-List not matching with the no. of Columns.\nNo. of columns = "+col_Names.length+"\tNo. of values to be inserted = "+val.length+": Make sure that they are equal.","Error in the addData method of LinkDB class using Database Table "+tableName+":",JOptionPane.ERROR_MESSAGE);
        else{

            String names="",values="";
            try{
            for(int i=0;i<val.length;i++){
                names+=col_Names[i];
                values+="'"+val[i]+"'";
                if(i!=val.length-1){
                    names+=",";
                    values+=",";
                }//end if
            }//end for
            }//end try
            catch(Exception e){
                err.displayError("class LinkDB, methd. addData() from table "+tableName,e);
                            }//end catch
            
            ss="INSERT INTO  " + tableName + " (" +names+ ") VALUES "+" ("+values+") ";
            
        }
            
       return ss;
   }//end addData    

    public String addDataAllColsBut1st( Object[] val) {//whereClause can be an empty String
        
        String ss="";
        if(no_of_cols-1!= val.length)
        JOptionPane.showMessageDialog(this," Value-List not matching with the no. of Columns.\nNo. of columns = "+(allColNames.length-2)+"\tNo. of values to be inserted = "+val.length+": Make sure that they are equal.","Error in the addDataAllColsBut1st() method of LinkDB class using Database Table "+tableName+":",JOptionPane.ERROR_MESSAGE);
        else{//main else
            String names="",values="";
            try{
            for(int i=0;i<val.length;i++){
                names+=allColNames[i+2];
                values+="'"+val[i]+"'";
                if(i!=val.length-1){
                    names+=",";
                    values+=",";
                }//end if
            }//end for
            }//end try
            catch(Exception e){
                err.displayError("class LinkDB, methd. addDataAllColsBut1st() from table "+tableName,e);
                            }//end catch
            
            ss="INSERT INTO  " + tableName + " (" +names+ ") VALUES "+" ("+values+") ";
        }//end main else
        return ss;
        
    }
    
    public String modifyData( int[] colNos, Object[] val,String whereClause) {
        String  ss ="";
        if(colNos.length!= val.length )
            JOptionPane.showMessageDialog(this," Value-List not matching with the no. of Columns.\nNo. of columns = "+colNos.length+"\tNo. of values to be inserted = "+val.length+": Make sure that they are equal.","Error in the modifyData() method of LinkDB class using Database Table "+tableName+":",JOptionPane.ERROR_MESSAGE);
        else{//main else
           
            String ssM="";
            for(int i=0;i<val.length;i++){
                ssM+=allColNames[colNos[i]]+"='"+val[i]+"'";
                if(i!=val.length-1)
                    ssM+=",";
            }//end for
            
            ss = "UPDATE "+tableName+" SET  " +ssM+" "+whereClause;
        }//end main else
        
        return ss;
    }

    public String modifyData( String[] col_Names, Object[] val,String whereClause) {
        
        String  ss ="";
        if(col_Names.length!= val.length )
            JOptionPane.showMessageDialog(this," Value-List not matching with the no. of Columns.\nNo. of columns = "+col_Names.length+"\tNo. of values to be inserted = "+val.length+": Make sure that they are equal.","Error in the modifyData method of LinkDB class using Database Table "+tableName+":",JOptionPane.ERROR_MESSAGE);
        else{//main else
           
            String ssM="";
            for(int i=0;i<val.length;i++){
                ssM+=col_Names[i]+"='"+val[i]+"'";
                if(i!=val.length-1)
                    ssM+=",";
            }//end for
            
            ss = "UPDATE "+tableName+" SET  " +ssM+" "+whereClause;
        }//end main else
        
        return ss;
        
    }//end modifyData
    
    public String modifyDataAllColsBut1st(  Object[] val,String whereClause) {
        String  ss ="";
        if(allColNames.length-2!= val.length )
            JOptionPane.showMessageDialog(this," Value-List not matching with the no. of Columns.\nNo. of columns = "+(allColNames.length-2)+"\tNo. of values to be inserted = "+val.length+": Make sure that they are equal.","Error in the modifyDataAllColsBut1st() method of LinkDB class using Database Table "+tableName+":",JOptionPane.ERROR_MESSAGE);
        else{//main else
           
            String ssM="";
            for(int i=0;i<val.length;i++){
                ssM+=allColNames[i+2]+"='"+val[i]+"'";
                if(i!=val.length-1)
                    ssM+=",";
            }//end for
            
            ss = "UPDATE "+tableName+" SET  " +ssM+" "+whereClause;
        }//end main else
        
        return ss;
    }
    
    
   public void fillCombo(javax.swing.JComboBox comboName,String colName,String whereClause,String orderBy){
try{
        accessDB();
        String ss = "SELECT "+colName+" FROM "+tableName+" "+ whereClause+" ORDER BY "+orderBy;
        ResultSet res = stat.executeQuery(ss);
        while( res.next() )
                comboName.addItem(res.getString(1));
        con.close();
    }//end try
    catch(Exception e){
        err.displayError("class LinkDB, methd. fillCombo(), combo name:"+comboName+", Database Table: "+tableName,e);
                    }//end catch  
    }//end fillCombo
   
   public void fillCombo(javax.swing.JComboBox comboName,String colName1,String appendMiddle,String colName2,String appendEnd,String whereClause,String orderBy){
try{
        accessDB();
        String ss = "SELECT "+colName1+","+colName2+" FROM "+tableName+" "+ whereClause+" ORDER BY "+orderBy;
        ResultSet res = stat.executeQuery(ss);
        while( res.next() )
            comboName.addItem(res.getString(1).trim()+appendMiddle+res.getString(2).trim()+appendEnd );
        con.close();
    }//end try
    catch(Exception e){
        err.displayError("class LinkDB, methd. fillCombo(), combo name:"+comboName+", Database Table: "+tableName,e);
                    }//end catch  
       
    }//end fillCombo
   
   
   public int queryRow(String whereClause){
       
       int rowTotal=0;
try{
    accessDB();
    
   String ss=" SELECT COUNT(*) FROM "+tableName+" "+whereClause;
   ResultSet res =   stat.executeQuery(ss); 
res.next(); 
try{
    rowTotal=Integer.parseInt(res.getString(1));
}//end try
catch(Exception e){
    err.displayError("class LinkDB, methd. queryRow(), Database Table: "+tableName,e);
    }//end catch

  con.close();
}//end try
catch(java.sql.SQLException e){
    err.displayError("class LinkDB, methd. queryRow(), Database Table: "+tableName,e);
        }
       

return rowTotal;
   }//end queryRow()
   
      //end queryRow()
   
   public Object queryOneEle(String colName,String whereClause){
            
        Object result="";
       try{
           accessDB();
           
           String ss = "SELECT "+colName+"  FROM "+tableName+" "+whereClause;
                      
           ResultSet res = stat.executeQuery(ss);
           
           res.next();
           
           result = ""+res.getString(1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. queryOneEle(), Database Table: "+tableName,e);
           }//end catch
       
         return result;
   
   }//end methd.
   
   public Object queryOneEle(int colNo,String whereClause){
            
        Object result="";
       try{
           accessDB();
           
           String ss = "SELECT "+allColNames[colNo]+"  FROM "+tableName+" "+whereClause;
                      
           ResultSet res = stat.executeQuery(ss);
           
           res.next();
           
           result = ""+res.getString(1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. queryOneEle(), Database Table: "+tableName,e);
           }//end catch
       
         return result;
        
   }//end query   
   
   public Object[] query1Col(int row,int colNo,boolean distinct,String whereClause){
       Object[] result = new Object[row];
       
       for(int i=0;i<row;i++)
           result[i]="null";
       
           String ss="";
           if(distinct)
           ss = "SELECT DISTINCT "+allColNames[colNo]+"  FROM "+tableName+" "+whereClause;
           else
           ss = "SELECT "+allColNames[colNo]+"  FROM "+tableName+" "+whereClause;    
           
       try{
           accessDB();
           ResultSet res = stat.executeQuery(ss);
           
           for(int i=0;res.next();i++)
               result[i] =""+ res.getString(1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. query1Col(), Database Table: "+tableName,e);
           }//end catch

                                            
                      return result;
   }//end query
   
public Object[] query1Col(int row,String colName,boolean distinct,String whereClause){

       Object[] result = new Object[row];
       
       for(int i=0;i<row;i++)
           result[i]="null";
       
           String ss="";
           if(distinct)
           ss = "SELECT DISTINCT "+colName+"  FROM "+tableName+" "+whereClause;
           else
           ss = "SELECT "+colName+"  FROM "+tableName+" "+whereClause;    
           
       try{
           accessDB();
           ResultSet res = stat.executeQuery(ss);
           
           for(int i=0;res.next();i++)
               result[i] =""+ res.getString(1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. query1Col(), Database Table: "+tableName,e);
           }//end catch

                                            
                      return result;

}//end methd.
   
   public Object[][] queryMulCols(int rows,int colNos[],String whereClause){
       Object result[][] = new Object[rows][colNos.length];
       
       String names = "";
            for(int i=0;i<colNos.length;i++){
                names+=allColNames[colNos[i]];
                if(i!=colNos.length-1){
                    names+=",";
                }//end if
                
            }//end for
       
       
       try{
           accessDB();
           String ss = "SELECT "+names+"  FROM "+tableName+" "+whereClause;
           
           ResultSet res = stat.executeQuery(ss);
                     
           for(int i=0;res.next();i++)
               for(int j=0;j<colNos.length;j++)
                   result[i][j] = res.getString(j+1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. queryMulCols(), Database Table: "+tableName,e);
           }//end catch
       
        return result;

   }//end query
   
   public Object[][] queryMulCols(int rows,String[] colNames,String whereClause){

       Object result[][] = new Object[rows][colNames.length];
       
       String names = "";
            for(int i=0;i<colNames.length;i++){
                names+=colNames[i];
                if(i!=colNames.length-1){
                    names+=",";
                }//end if
                
            }//end for
       
       
       try{
           accessDB();
           String ss = "SELECT "+names+"  FROM "+tableName+" "+whereClause;
           
           ResultSet res = stat.executeQuery(ss);
                     
           for(int i=0;res.next();i++)
               for(int j=0;j<colNames.length;j++)
                   result[i][j] = res.getString(j+1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. queryMulCols(), Database Table: "+tableName,e);
           }//end catch
       
        return result;
   
   }//end methd.
   
   public Object[] queryMulEle(String[] colNames,String whereClause){

       Object result[] = new Object[colNames.length];
       
       String names = "";
            for(int i=0;i<colNames.length;i++){
                names+=colNames[i];
                if(i!=colNames.length-1){
                    names+=",";
                }//end if
                
            }//end for
       
       
       try{
           accessDB();
           String ss = "SELECT "+names+"  FROM "+tableName+" "+whereClause;
           
           ResultSet res = stat.executeQuery(ss);
                     res.next();
           for(int i=0;i<colNames.length;i++)
                   result[i] = res.getString(i+1);
          
           con.close();
       }//end try
       catch(Exception e){
           err.displayError("class LinkDB, methd. queryMulEle(), Database Table: "+tableName,e);
           }//end catch
       
        return result;
   
   }//end methd.
   
   public Object[] queryMulEle(int colNos[],String whereClause){
       
       Object result[] = new Object[colNos.length];
       
       String names = "";
            for(int i=0;i<colNos.length;i++){
                names+=allColNames[colNos[i]];
                if(i!=colNos.length-1){
                    names+=",";
                }//end if
                
            }//end for
       
       
       try{
           accessDB();
           String ss = "SELECT "+names+"  FROM "+tableName+" "+whereClause;
           
           ResultSet res = stat.executeQuery(ss);
                     res.next();
           for(int i=0;i<colNos.length;i++)
                   result[i] = res.getString(i+1);
          
           con.close();
       }//end try
       catch(Exception e){
           err.displayError("class LinkDB, methd. queryMulEle(), Database Table: "+tableName,e);
           }//end catch
       
        return result;
       
   }//end queryMulEle()

   public Object[][] queryAllColsBut1st(int rows,String whereClause){
       Object result[][] = new Object[rows][allColNames.length];
       
       String names = "";
            for(int i=0;i<allColNames.length;i++){
                names+=allColNames[i+1];
                if(i!=allColNames.length-1){
                    names+=",";
                }//end if
                
            }//end for
       
       try{
           accessDB();
           String ss = "SELECT "+names+"  FROM "+tableName+" "+whereClause;
           
           ResultSet res = stat.executeQuery(ss);
           
           for(int i=0;res.next();i++)
               for(int j=0;j<allColNames.length;j++)
                   result[i][j] = res.getString(j+1);
           
           con.close();
       }//end try
       catch(java.sql.SQLException e){
           err.displayError("class LinkDB, methd. queryAllColsBut1st(), Database Table: "+tableName,e);
           }//end catch
       
       return result;

   }
   
   public void checkEmpty() {
       int row = queryRow("");
           if(row==0){
               JOptionPane.showMessageDialog(this," Table "+tableName+" in the Database has no entry.\n Make suitable entries in the Table to run this Form.  ","From Database:",JOptionPane.INFORMATION_MESSAGE);
           }//end if
   }//end checkEmpty
   
//end query   

}

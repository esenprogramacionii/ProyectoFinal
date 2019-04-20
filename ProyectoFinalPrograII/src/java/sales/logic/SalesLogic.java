
package sales.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sales.database.DatabaseX;
import sales.objects.SalesObj;

public class SalesLogic extends Logic 
{

    //metodo3, para obtener toda la lista dde clientes
    public ArrayList<SalesObj> getAllSales() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.sales ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<SalesObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strFirstname;
            String strLastname;
            String strDate;
            
            SalesObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strFirstname = CResult.getString("firstname");
                    strLastname = CResult.getString("lastname");
                    strDate = CResult.getString("date");
                    
                    CTemp = new SalesObj(iId, strFirstname, strLastname, strDate);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(SalesLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    //metodo2
    public int insertSalesRows(String p_strFirstname, String p_strLastname, String p_strDate)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.sales(id,firstname,lastname,date) VALUES(0,'"+p_strFirstname+"','"+p_strLastname+"','"+p_strDate+"')";
        
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public int deleteSalesRows(int p_iId) //metodo para borrar clientes 
    {
        int iRows = deleteTableRows(p_iId, "sales");
        return iRows;
    }

    public SalesObj getSalesById(int p_iId) //Seleccionan un cliente usando una condicion 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.sales where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        SalesObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strFirstname;
            String strLastname;
            String strDate;
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strFirstname = CResult.getString("firstname");
                    strLastname = CResult.getString("lastname");
                    strDate = CResult.getString("date");
                    
                    CTemp = new SalesObj(iId, strFirstname, strLastname, strDate);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(SalesLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }

    public int updateSalesRows(int p_iId, String p_strFirstname, String p_strLastname, String p_strDate)//metodo para actualizar rows
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update mydb.sales "
                + "set firstname = '"+p_strFirstname+"',lastname = '"+p_strLastname+"', date = '"+p_strDate+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}

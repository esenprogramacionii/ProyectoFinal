
package Inventory.prografinal.logic;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Inventory.prografinal.database.DatabaseX;
import Inventory.prografinal.objects.SalesObj;

public class SalesLogic extends logic 
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
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.sales(id,firstname,lastname,date) "
                + "VALUES(0,'"+p_strFirstname+"','"+p_strLastname+"','"+p_strDate+"')";
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
    
   //METODO PARA OBTENER ULTIMO ID INSERTADO 
    public int getlastid() {
        DatabaseX database = getDatabase();
        String StrSql = "SELECT LAST_INSERT_ID() as lastid";
        System.out.println(StrSql);
        int lastId = 0;
        ResultSet rs = database.executeQuery(StrSql);
        
        if(rs!=null)
        {

            try {
                while(rs.next())
                {
                    lastId = rs.getInt("lastid");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SalesLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         }

        return lastId;
    
        }
    
   //METODO PARA INSERTAR FILAS EN SALESDETAIL
   public int insertSalesDRows(int p_iID, int p_iProd, int p_iQ)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.salesdetail(id,product,sales,quantity) "
                + "VALUES(0,"+p_iID+","+p_iProd+","+p_iQ+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

}

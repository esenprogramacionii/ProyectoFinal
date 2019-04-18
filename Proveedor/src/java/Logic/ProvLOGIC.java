
package Logic;

import Database.DatabaseX;
import Objects.ProvObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ProvLOGIC extends Logic 
{
    public int insertProv(String p_strName) //esta onda es para ver cuantas rows fueron afectadas
    {
        
        
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.supplier (id, name) "
               + "VALUES(0,'"+p_strName+"');";
        System.out.println(strSql); //esto solo es para ver en el Output que sentencia mande
        int iRows = database.executeNonQueryRows(strSql); //esto es para que solo devuelva las rows que afecto
        return iRows;
    }
    
     //metodo3, para obtener toda la lista de proveedores
    public ArrayList<ProvObj> getAllProv() 
    {
        //select * from mydb.supplier;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.supplier ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<ProvObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            
            
            ProvObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    
                    CTemp = new ProvObj(iId, strName);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProvLOGIC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    public int deleteProvRows(int p_iId) //metodo para borrar provs 
    {
        int iRows = deleteTableRows(p_iId, "supplier");
        return iRows;
    }

    public ProvObj getProvById(int p_iId) //Seleccionan un cliente usando una condicion 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.supplier where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ProvObj CTemp = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    
                    CTemp = new ProvObj(iId, strName);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(ProvLOGIC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
        
    }
     public int updateProvRows(int p_iId, String p_strName)//metodo para actualizar rows
    {
        //update travelsys.client set name = 'fabricio',age = 25 where id = 9;
        DatabaseX database = getDatabase();
        String strSql = "update mydb.supplier "
                + "set name = '"+p_strName+"' "
                + "where id = "+p_iId+" ";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
}


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
    
}

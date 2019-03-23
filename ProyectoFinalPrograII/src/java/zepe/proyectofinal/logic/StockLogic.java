
package zepe.proyectofinal.logic;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zepe.proyectofinal.database.DatabaseX;

public class StockLogic extends Logic
{
    //metodo1: todos los registros country columnas
    //sql: select * from esentravel.country
    public ArrayList<StockObj> getAllCountries()
    {
        //codificar el metodo
        DatabaseX CDatabase = getDatabase();
        String strSql = "select * from esentravel.country";
        ResultSet CResult = CDatabase.executeQuery(strSql);
        ArrayList<CountryObj> CArray = null;
        
        //evaluar el result que venga lleno
        if(CResult!=null)
        {
            try 
            {
                int iId;
                String strName;
                String strCode;
                CountryObj CTemp;
                CArray = new ArrayList<>();
                
                while(CResult.next())
                {
                    iId = CResult.getInt("id"); //id
                    strName = CResult.getString("name"); //name
                    strCode = CResult.getString("code"); //code
                    
                    CTemp = new CountryObj(iId, strName, strCode);
                    
                    //agregando al array un instancia de countryobj
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(TravelLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
    }
}

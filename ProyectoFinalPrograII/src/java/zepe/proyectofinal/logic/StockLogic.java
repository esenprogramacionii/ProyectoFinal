package zepe.proyectofinal.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zepe.proyectofinal.database.DatabaseX;
import zepe.proyectofinal.objects.StockObj;

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
        ArrayList<StockObj> CArray = null;
        
        //evaluar el result que venga lleno
        if(CResult!=null)
        {
            try 
            {
                int iIproduct;
                int iIStore;
                int iQ;
                StockObj CTemp;
                CArray = new ArrayList<>();
                
                while(CResult.next())
                {
                    iIproduct = CResult.getInt("product"); //id
                    iIStore = CResult.getInt("store"); //name
                    iQ = CResult.getInt("quantity"); //code
                    
                    CTemp = new StockObj(iIproduct, iIStore, iQ);
                    
                    //agregando al array un instancia de countryobj
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(StockLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
    }
}


package sales.logic;

import bal.travelsyswebapp.database.DatabaseX;
import bal.travelsyswebapp.objects.StockObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockLogic extends Logic
    
    {
 
    public ArrayList<StockObj> getAllStock() //Nombre del método
    {
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.stock ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<StockObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iStore;
            int iStock;
            
            StockObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("product");
                    iStore = CResult.getInt("store");
                    iStock = CResult.getInt("quantity");
                    
                    CTemp = new StockObj(iId, iStore, iStock);
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

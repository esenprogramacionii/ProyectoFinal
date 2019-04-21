
package sales.logic;

import sales.database.DatabaseX;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SDetailLogic extends Logic

{
    
     public boolean insertdetailBool(int p_Iid, int p_product, int p_quantity, int p_order)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.orderdetail(id,product,quantity,order) "
                + "VALUES(0,"+p_Iid+","+p_product+", "+p_order+" )";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    //metodo2
    public int insertSalesDRows(int p_iID, int p_iProd, int p_iQ)
    {
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.salesdetail(id,product,sales,quantity) "
                + "VALUES(0,"+p_iID+","+p_iProd+","+p_iQ+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////
   public int updateSstock (int p_ID, int p_Store, int p_Quantity)
    {
        DatabaseX database = getDatabase();
    
        String strSql = "UPDATE `mydb`.`stock`"
                + "SET `stock` = stock-"+p_Quantity+" WHERE `productid` = "+p_ID+" AND `storeid` = "+p_Store+" AND stock > 0 LIMIT 1;";
  
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
}

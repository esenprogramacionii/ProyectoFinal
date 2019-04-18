package zepe.proyectofinal.logic;

import zepe.proyectofinal.database.DatabaseX;
import zepe.proyectofinal.objects.DetailObj;
import zepe.proyectofinal.objects.DetailViewObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetailLogic extends Logic

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
    public int insertdetailRows(int p_Iid, int p_product, int p_quantity, int p_order)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
          String strSql = "INSERT INTO mydb.orderdetail(id,product,quantity,orderid) "
                + "VALUES(0,"+p_product+","+p_quantity+", "+p_order+" )";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<DetailObj> getAllDetails() //Nombre del método
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.orderdetail ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<DetailObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            int iproduct;
            int iquantity;
            int iorder;
            
            
            DetailObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    iproduct = CResult.getInt("product");
                    iquantity = CResult.getInt("quantity");
                    iorder = CResult.getInt("orderid");
                    
                    
                    CTemp = new DetailObj(iId, iproduct, iquantity, iorder);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DetailLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
        
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<DetailViewObj> getAllViews() // Para la tabla View
    {
        //select * from travelsys.trip;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.ordetail1 ";  
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<DetailViewObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            int Pid;
            String Pprice;
            int Quant;
            float dtotal;
            int orderid;
            
            DetailViewObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("product name");
                    Pid = CResult.getInt("product id");
                    Pprice = CResult.getString("product price");
                    Quant = CResult.getInt("order size");
                    dtotal = CResult.getInt("order total");
                    orderid = CResult.getInt("orderid");
                    
                    CTemp = new DetailViewObj(iId, strName, Pid, Pprice, Quant, dtotal, orderid);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(DetailLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
    }
    
   ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
}

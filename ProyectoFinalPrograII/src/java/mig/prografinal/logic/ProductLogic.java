
package mig.prografinal.logic;

import mig.prografinal.database.DatabaseX;

public class ProductLogic extends logic
{
    
  public boolean insertProductBool(int p_iId, String p_strName, String p_strBrand, 
            String p_strDescription, int p_intYear, double p_dPrice, 
            int p_iCategory)
    {
        //INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.product(id,pname, brand, description, pyear,price,category) "
                + "VALUES(0,'"+p_strName+"','"+p_strBrand+"','"+p_strDescription+"',"+p_intYear+","+p_dPrice+""
                + ","+p_iCategory+")";
        System.out.println(strSql);
        boolean bsuccess = database.executeNonQueryBool(strSql);
        return bsuccess;
    }
    
    public int insertProductRows(int p_iId, String p_strName, String p_strBrand, 
            String p_strDescription, int p_intYear, double p_dPrice, 
            int p_iCategory)
    {
        
        DatabaseX database = getDatabase();
        String strSql = "INSERT INTO mydb.client(id,pname, brand, description, pyear,price,category) "
                + "VALUES(0,'"+p_strName+"','"+p_strBrand+"','"+p_strDescription+"',"+p_intYear+","+p_dPrice+""
                + ","+p_iCategory+")";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;
    }

    public int insertProductRows(String strName, String strBrand, String strDescription, int iYear, double dPrice, int iCategory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

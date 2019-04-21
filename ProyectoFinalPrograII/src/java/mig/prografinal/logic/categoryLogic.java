/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mig.prografinal.logic;

import mig.prografinal.database.DatabaseX;
import mig.prografinal.objects.categoryObj;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class categoryLogic extends logic {
    
     public ArrayList<categoryObj> getAllCategories() 
    {
        //select * from travelsys.client;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.category ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        ArrayList<categoryObj> CArray = null;
        
        if(CResult!=null)
        {
            int iId;
            String strName;
            
            categoryObj CTemp;
            CArray = new ArrayList<>();
            
            try 
            {
                while(CResult.next())
                {
                    iId = CResult.getInt("id");
                    strName = CResult.getString("name");
                    
                    CTemp = new categoryObj(iId, strName);
                    CArray.add(CTemp);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(storeLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CArray;
    }

    
    public int insertCategoryRows(String p_strName)
    {
        // INSERT INTO travelsys.client(id,name,age) VALUES(0,'pepito',24);
        
    DatabaseX database = getDatabase();
    String strSql = "INSERT INTO mydb.category(id,name) VALUES(0,'"+p_strName+"')";

    System.out.println(strSql);
    int iRows = database.executeNonQueryRows(strSql);
    return iRows;
    
   
    }
    
    
          public int deleteCategoryRows(int p_iId) 
    {

        int iRows = deleteTableRows(p_iId,"category");
        return iRows;
    }
 
    
    public categoryObj getCategoryById(int p_iId) 
    {
        //select * from mydb.store;
        DatabaseX database = getDatabase();
        String strSql = "select * from mydb.category "
                + "where id="+p_iId+" ";
        System.out.println(strSql);
        ResultSet CResult = database.executeQuery(strSql);
        categoryObj CTemp = null;
        
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
                    
                    CTemp = new categoryObj(p_iId, strName);
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(storeLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return CTemp;
    }
    
    public int updateCategoryRows(int p_iId, String p_strName) 
    {
        //update mydb.store set name = 'fabricio';
        DatabaseX database = getDatabase();
        String strSql = "UPDATE mydb.category"
                + " "
                + "SET name = '"+p_strName+"'"
                + "WHERE id = "+p_iId+";";
        System.out.println(strSql);
        int iRows = database.executeNonQueryRows(strSql);
        return iRows;        
    }
}

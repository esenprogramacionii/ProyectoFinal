
package Logic;

import Database.DatabaseX;


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
    
}

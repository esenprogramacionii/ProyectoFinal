
package mig.prografinal.logic;

import mig.prografinal.database.DatabaseX;

// la logic es para guardar los datos de la conexion de la databaseX
public class logic 
{
        private DatabaseX m_CDatabase;

    public logic() 
    {
        setDatabase( createDatabase() );
    }

    public DatabaseX getDatabase() 
    {
        return m_CDatabase;
    }

    private void setDatabase(DatabaseX p_CDatabase) 
    {
        m_CDatabase = p_CDatabase;
    }

    private DatabaseX createDatabase() 
    {
        DatabaseX database = getDatabase();
        if(database == null)
        {
            database = new DatabaseX();
        }
        return database;
    }    
}

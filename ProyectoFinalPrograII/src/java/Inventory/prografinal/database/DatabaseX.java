
package Inventory.prografinal.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseX 
{ 
    // creando las variables de la clase, conector para la base de datos
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb"
                + "?autoReconnect=true"
                + "&useUnicode=true"
                + "&useSSL=false"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "timel";

    
    //para hacer la conexion
    private Connection m_CConnection;
    private Statement m_CStatement;
    private ResultSet m_CResultSet;

    //todo pasa en el constructor, crear la conexion para la base de datos.
    public DatabaseX()
    {
        //creando la conexion
        setConnection( createConnection() );
        //segundo paso crear el statement
        setStatement( createStatement() );
        
    }
    
     //una vez creada la conexion y el statement se hacen los getters y setters de cada uno.

    public Connection getConnection() {
        return m_CConnection;
    }

    public void setConnection(Connection p_CConnection) {
         m_CConnection = p_CConnection;
    }

    public Statement getStatement() {
        return m_CStatement;
    }

    public void setStatement(Statement p_CStatement) {
        m_CStatement = p_CStatement;
    }

    public ResultSet getResultSet() {
        return m_CResultSet;
    }

    public void setResultSet(ResultSet p_CResultSet) {
        m_CResultSet = p_CResultSet;
    }
    
    //Una vez declaradas las variables hay que generar las conexiones y los statements para las consultas
    // de la base de datos 
    
    //Generador de la conexion.
    private Connection createConnection() 
    {
        Connection CConexion = null;
        try 
        {
            Class.forName(DB_DRIVER);
            CConexion =
                    DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CConexion;
    }
        //Generador del Statement
        
       private Statement createStatement() 
    {
        //variables locales o variables de metodo
        Connection CConnection = getConnection();
        Statement stm = null;
        try
        {
            if(!CConnection.isClosed())
            {
                stm = CConnection.createStatement();
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stm;
    }
    
       //Crear el result set que almacenará la información consultada por el conector y el statement.
       public ResultSet executeQuery(String p_strSql)
    {
        Connection con = getConnection();
        Statement stm = getStatement();
        ResultSet result = null;
        
        try 
        {
            if(!con.isClosed()) //Si la conexion es abierta se ejecutará el query creado por el servlet y procesado en el logic
            {
                result = stm.executeQuery(p_strSql);
            }
        } 
        catch (SQLException ex) //Si da error crea la siguiente linea de código
        {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        }
        setResultSet( result );
        
        return result; //retorna el resultado como una expresión.
    }
        //Se hace la consulta del nonquery para retornar el numero de filas que han sido afectadas en la BD
        public int executeNonQueryRows(String p_strSql)
    {
        Connection con = getConnection();
        Statement stm = getStatement();
        int iRows = 0;
        
        try 
        {
            if(!con.isClosed())
            {
                iRows = stm.executeUpdate(p_strSql);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return iRows;
    }
    
        //Retorna el argumento lógico que hace que el statement declarado procese la informacion y ejecute el query.
        public boolean executeNonQueryBool(String p_strSql)
    {
        Connection con = getConnection();
        Statement stm = getStatement();
        boolean iSuccess = false;
        
        try 
        {
            if(!con.isClosed())
            {
                iSuccess = stm.execute(p_strSql);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DatabaseX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return iSuccess;
    }    
} 

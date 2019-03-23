
package mig.prografinal.database;

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
    private static final String DB_URL = "jdbc:mysql://localhost:3306/sakila"
                + "?autoReconnect=true"
                + "&useUnicode=true"
                + "&useSSL=false"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&useLegacyDatetimeCode=false"
                + "&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345";
    
    //para hacer la conexion
    private Connection m_CConnection;
    private Statement m_CStatement;
    private ResultSet m_CResultSet;

    //todo pasa en el constructor
}

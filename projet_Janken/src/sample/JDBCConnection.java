package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
public static final String USER = "p1805110";
public static final String PASSWD = "368226";

public static Statement statement;
public static Connection connection = null;

    public static void openBDD(){
    try {
        //configuration du driver
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //CONNECTION AU SGBD 
        //URL du serveur de BD
        String url = "jdbc:oracle:thin:@iutdoua-oracle.univ-lyon1.fr:1521:orcl";
        //connexion à l’URL en précisant l’utilisateur et 
        // le mot de passe d’accès à la BD
        connection =
                DriverManager.getConnection(url,USER,PASSWD);
        //Création de l'objet gérant les requêtes 
        statement = connection.createStatement();
    } catch (Exception e) {
        System.out.println(e);
    }
    }

    public static ResultSet query(String query) {
        ResultSet result = null;
        if (connection == null) {
            openBDD();
        }
        try{
            result = statement.executeQuery(query);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    return result;
    }
    public static void closeBDD(){
        try {
            //fermeture de la connexion à la BD
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


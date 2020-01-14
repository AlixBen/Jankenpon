package sample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("JanKen!");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        try {
            ResultSet res = JDBCConnection.query("select * from JKP_UTILISATEUR");
            System.out.println("Numéro| Utilisateur | mdp");
            //tant qu'il y a une ligne résultat
            while(res.next())
            {
                System.out.print(res.getInt(1));
                System.out.print("|");
                System.out.print(res.getString("UTILISATEUR"));
                System.out.print("|");
                System.out.println(res.getString("MOT_DE_PASSE"));
            }
            
            
            launch(args);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

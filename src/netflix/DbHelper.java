/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflix;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Poyraz
 */
public class DbHelper {
     private String dbUrl = "jdbc:sqlite:databases\\netflix_ep.db";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(dbUrl);
    }
    public void showErrorMessage(SQLException exception){
        System.out.println("Hata: "+ exception.getMessage());
        System.out.println("Hata kodu: "+exception.getErrorCode());
    }                                       
}


package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexionBD {
    static String driver ="com.mysql.cj.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3308/bd_internet";
    static String user="root";
    static String password="";
    
    protected Connection conn= null;
    
    public conexionBD(){
        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            System.out.println("No funciono el drive");
        } catch (SQLException ex) {
            System.out.println("no se conecto a la base de datos");
        }
        
    }    
    
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

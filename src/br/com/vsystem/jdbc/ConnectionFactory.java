
package br.com.vsystem.jdbc;

import java.sql.*;


public class ConnectionFactory {
    
    public java.sql.Connection getConnection() {
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdvsystem?autoReconnect=true&useSSL=false","root","moedade50");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
}


package br.com.vsystem.jdbc;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
    public java.sql.Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvsystem","root","moedade50");
            
        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }
        
    }
}

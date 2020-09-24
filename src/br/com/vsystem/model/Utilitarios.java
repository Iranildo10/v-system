package br.com.vsystem.model;
import br.com.vsystem.jdbc.ConnectionFactory;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Utilitarios {
    
    private Connection con;
    
    public Utilitarios() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //metodo limparCampos
    public void LimpaTela(JPanel container){
        Component components[] = container.getComponents();
        for(Component component : components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
    
    //Método que pesquisa o endereço atraves do cep
    public String[] buscarCep(String cep) 
    {
        
        
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            //logradouro = array[7];            
            //bairro = array[15];
            //cidade = array[19]; 
            //uf = array[23];
            
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
            return array;
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public String retornaDataBR(){
        
        Date agora = new Date();
        SimpleDateFormat dataBr = new SimpleDateFormat("dd/MM/yyyy hh/mm/ss");
        String dataformatada = dataBr.format(agora);
        
        return dataformatada;
    }
    
    public String retornaDataMundial(){
        
        Date agora = new Date();
        SimpleDateFormat dataM = new SimpleDateFormat("yyyy/MM/dd hh/mm/ss");// hh/mm/ss
        String dataformatada = dataM.format(agora);
        
        return dataformatada;
    }
    
 
    
}

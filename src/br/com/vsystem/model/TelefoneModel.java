
package br.com.vsystem.model;

public class TelefoneModel {
    //Atributos
    private int telefone_id;
    private String tipo_telefone;
    private String telefone;
    private String apagado;
    
    //Getters and Setters

    public int getTelefone_id() {
        return telefone_id;
    }

    public void setTelefone_id(int telefone_id) {
        this.telefone_id = telefone_id;
    }

    public String getTipo_telefone() {
        return tipo_telefone;
    }

    public void setTipo_telefone(String tipo_telefone) {
        this.tipo_telefone = tipo_telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApagado() {
        return apagado;
    }

    public void setApagado(String apagado) {
        this.apagado = apagado;
    }
    
}

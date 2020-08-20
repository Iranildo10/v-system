
package br.com.vsystem.model;

public class TelefoneModel {
    //Atributos
    private int telefone_id;
    private String celular;
    private String telefone;
    private String apagado;
    
    //Getters and Setters

    public int getTelefone_id() {
        return telefone_id;
    }

    public void setTelefone_id(int telefone_id) {
        this.telefone_id = telefone_id;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

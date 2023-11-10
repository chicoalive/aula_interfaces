package modelo.entidades;

public class Veiculo {

    private String modelo;

    // Construtores
    public Veiculo() {
    }

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }

    // Get e Sete - Pegar e modificar
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}

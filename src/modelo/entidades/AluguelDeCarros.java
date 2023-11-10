package modelo.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AluguelDeCarros {

    private LocalDateTime começo;
    private LocalDateTime fim;

    // Associações. Aluguel de carros está associado a Fatura e a Veiculo. 
    private Veiculo veiculo;
    private Fatura fatura;

    // Construtor
    public AluguelDeCarros() {
    }

    public AluguelDeCarros(LocalDateTime começo, LocalDateTime fim, Veiculo veiculo) {
        this.começo = começo;
        this.fim = fim;
        this.veiculo = veiculo;
        //this.fatura = fatura;
    }

    // Get e Sete - Pegar e modificar
    

    public LocalDateTime getComeço() {
        return começo;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void setComeço(LocalDateTime começo) {
        this.começo = começo;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }
    
    
}

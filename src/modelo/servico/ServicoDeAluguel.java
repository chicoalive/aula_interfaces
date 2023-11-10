package modelo.servico;

import java.time.Duration;
import modelo.entidades.AluguelDeCarros;
import modelo.entidades.Fatura;

public class ServicoDeAluguel {

    private Double precoPorHora;
    private Double precoPorDia;

    // Associações
    private TaxaServico taxaServico;

    // Construtor
    public ServicoDeAluguel(Double precoPorHora, Double preçoPorDia, BrazilTaxaServico taxaServico) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = preçoPorDia;
        this.taxaServico = taxaServico;
    }

    // Get e Set - Pegar e Modificar
    public Double getPrecoPorHora() {
        return precoPorHora;
    }

    public Double getPreçoPorDia() {
        return precoPorDia;
    }

    public TaxaServico getTaxaServico() {
        return taxaServico;
    }

    public void setPrecoPorHora(Double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public void setPreçoPorDia(Double preçoPorDia) {
        this.precoPorDia = preçoPorDia;
    }

    public void setTaxaServico(BrazilTaxaServico taxaServico) {
        this.taxaServico = taxaServico;
    }

    // Métodos 
    public void processamentoFatura(AluguelDeCarros aluguelDeCarros) {

        // Esse método encontra a duração por hora. .toHours duração em horas .toMinutes para minutos
        double minutos = Duration.between(aluguelDeCarros.getComeço(), aluguelDeCarros.getFim()).toMinutes();
        double horas = minutos / 60;

        double pagamentoBasico;
        if (horas <= 12) {
            // O Math.ceil arredonda o numero para cima
            pagamentoBasico = precoPorHora * Math.ceil(horas);
        } else {
            pagamentoBasico = precoPorDia * Math.ceil(horas / 24);
        }

        double taxa = taxaServico.taxa(pagamentoBasico);
        
        aluguelDeCarros.setFatura(new Fatura(pagamentoBasico, taxa));
    }

}

package modelo.entidades;

public class Fatura {

    private Double pagamentoBasico;
    private Double taxaImposto;

    //Construtor
    public Fatura() {
    }

    public Fatura(Double pagamentoBasico, Double taxaImposto) {
        this.pagamentoBasico = pagamentoBasico;
        this.taxaImposto = taxaImposto;
    }

    // Get e Set - Pegar e modificar
    public Double getPagamentoBasico() {
        return pagamentoBasico;
    }

    public Double getTaxaImposto() {
        return taxaImposto;
    }

    public void setPagamentoBasico(Double pagamentoBasico) {
        this.pagamentoBasico = pagamentoBasico;
    }

    public void setTaxaImposto(Double taxaImposto) {
        this.taxaImposto = taxaImposto;
    }

    // Método
    // Pagamento Total. É usado o get, pois se eu mudar a lógica/regra do TaxaImposto, não preciso alterar todo o código.
        public Double getTotalPagamento() {
        return getPagamentoBasico() + getTaxaImposto();
    }

}

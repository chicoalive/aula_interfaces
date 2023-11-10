package modelo.servico;

public class BrazilTaxaServico implements TaxaServico {
    
    // Preciso dizer que o Brazil Taxa ira implementar a interface taxa

    public double taxa(double quantidade) {
        if (quantidade <= 100) {
            return quantidade * 0.2;
        } else {
            return quantidade * 0.15;
        }
    }
}

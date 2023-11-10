package aplicacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import modelo.entidades.AluguelDeCarros;
import modelo.entidades.Veiculo;
import modelo.servico.BrazilTaxaServico;
import modelo.servico.ServicoDeAluguel;

public class Programa {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Para ler dados do tipo time
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Bem vindo a Chico Alive soluções veiculares");
        System.out.println("Digite os dados para aluguel do carro: ");
        System.out.print("Modelo do veiculo: ");
        String modelo = teclado.nextLine();
        System.out.print("Qual a data da retirada do veiculo: dd/MM/yyyy hh:mm: ");
        // Quando forem datas, devemos usar o LocalDateTime!
        LocalDateTime comeco = LocalDateTime.parse(teclado.nextLine(), fmt);
        System.out.print("Qual a data da entrega do veiculo: dd/MM/yyyy hh:mm: ");
        // Quando forem datas, devemos usar o LocalDateTime!
        LocalDateTime fim = LocalDateTime.parse(teclado.nextLine(), fmt);

        // Modelo é uma String digitada pelo usuário, porém na classe Aluguel de Carros é uma associação com a classe veiculos
        // Então eu preciso instanciar um veiculo
        AluguelDeCarros aluguelDeCarros = new AluguelDeCarros(comeco, fim, new Veiculo(modelo));

        System.out.print("Preço por hora de alguel: ");
        double precoPorHora = teclado.nextDouble();
        System.out.print("Preço por dia de alguel: ");
        double precoPorDia = teclado.nextDouble();

        // Preciso instanciar o BrazilTaxaServiço, pois também é uma classe.
        ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorHora, precoPorDia, new BrazilTaxaServico());
        servicoDeAluguel.processamentoFatura(aluguelDeCarros);

        System.out.println("::::Fatura::::");
        System.out.println("Pagamento Básico: " + aluguelDeCarros.getFatura().getPagamentoBasico());
        System.out.println("Imposto: " + aluguelDeCarros.getFatura().getTaxaImposto());
        System.out.println("Pagamento total: " + aluguelDeCarros.getFatura().getTotalPagamento());

        teclado.close();

    }

}

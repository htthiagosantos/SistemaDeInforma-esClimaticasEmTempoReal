package ProjectoClima;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println();
        System.out.println("   SISTEMA DE INFORMAÇÕES CLIMÁTICAS    ");
        System.out.println();
        System.out.println(" [1] Buscar Clima por Cidade");
        System.out.println(" [0] Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

    public String lerOpcao() {
        return scanner.nextLine().trim();
    }

    public String pedirNomeCidade() {
        System.out.print("\nDigite o nome da cidade: ");
        return scanner.nextLine().trim();
    }

    public void exibirDadosClimaticos(DadosClimaticos clima) {
        String dataFormatada = formatarDataBr(clima.getDataHora());

        System.out.println();
        System.out.println(" Clima em " + clima.getCidade() + ", " + clima.getPais());
        System.out.println();
        System.out.println(" Data/Hora           : " + dataFormatada);
        System.out.println(" Temperatura Atual   : " + clima.getTemperatura() + "°C (Sensação: " + clima.getSensacaoTermica() + "°C)");
        System.out.println(" Condição do Tempo   : " + clima.getCondicaoTempo());
        System.out.println(" Umidade             : " + clima.getUmidade() + "%");
        System.out.println(" Veclodidade do Vento: " + clima.getVelocidadeVento() + " km/h");
        System.out.println(" Pressão Atemosférica: " + clima.getPressaoAtmosferica() + " mb");
        System.out.println();
    }


    private String formatarDataBr(String dataOriginal) {
        try {
            DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
            LocalDateTime dataHora = LocalDateTime.parse(dataOriginal, formatoEntrada);
            return dataHora.format(formatoSaida);
        } catch (Exception e) {
            return dataOriginal;
        }
    }

    public void exibirMensagemErro(String mensagem) {
        System.out.println("\n[!] " + mensagem);
    }

    public void exibirMensagemDespedida() {
        System.out.println("\nEncerrando o programa... Até logo!");
    }

    public void fecharScanner() {
        scanner.close();
    }
}
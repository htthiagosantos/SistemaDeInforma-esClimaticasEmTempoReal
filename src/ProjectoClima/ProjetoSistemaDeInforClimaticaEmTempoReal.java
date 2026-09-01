package ProjectoClima;

public class ProjetoSistemaDeInforClimaticaEmTempoReal {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        WeatherService weatherService = new WeatherService();
        boolean executando = true;

        while (executando) {
            view.exibirMenu();
            String opcao = view.lerOpcao();

            switch (opcao) {
                case "1":
                    String cidade = view.pedirNomeCidade();
                    if (cidade.isEmpty()) {
                        view.exibirMensagemErro("O nome da cidade não pode ser vazio.");
                    } else {
                        try {
                            String jsonResposta = weatherService.buscarDadosJson(cidade);
                            DadosClimaticos clima = WeatherMapper.paraDTO(jsonResposta);
                            view.exibirDadosClimaticos(clima);
                        } catch (CidadeNaoEncontradaException e) {
                            view.exibirMensagemErro(e.getMessage());
                        } catch (ConexaoApiException e) {
                            view.exibirMensagemErro(e.getMessage());
                        } catch (Exception e) {
                            view.exibirMensagemErro("Erro inesperado: " + e.getMessage());
                        }
                    }
                    break;

                case "0":
                    executando = false;
                    view.exibirMensagemDespedida();
                    break;

                default:
                    view.exibirMensagemErro("Opção inválida! Tente novamente.");
                    break;
            }
        }

        view.fecharScanner();
    }
}
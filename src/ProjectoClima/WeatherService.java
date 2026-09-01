package ProjectoClima;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

public class WeatherService {

    public String buscarDadosJson(String cidade) throws CidadeNaoEncontradaException, ConexaoApiException {
        String apikey = System.getenv("WEATHER_API_KEY");
        
        if (apikey == null || apikey.trim().isEmpty()) {
            throw new IllegalStateException("A variável de ambiente 'WEATHER_API_KEY' não foi configurada!");
        }
        
        String cidadeSemAcento = Normalizer.normalize(cidade, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        
        String formatarNomeCidade = URLEncoder.encode(cidadeSemAcento, StandardCharsets.UTF_8);
        String apiURL = "http://api.weatherapi.com/v1/current.json?key=" + apikey 
                + "&q=" + formatarNomeCidade 
                + "&lang=pt";
        
        try {
            HttpRequest request = HttpRequest.newBuilder()
                      .uri(URI.create(apiURL))
                      .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            String jsonResposta = response.body();

            // Valida se o retorno indica cidade não encontrada
            if (jsonResposta.contains("\"code\":1006")) {
                throw new CidadeNaoEncontradaException("Localização '" + cidade + "' não foi encontrada.");
            }

            return jsonResposta;

        } catch (CidadeNaoEncontradaException e) {
            throw e; // Repassa a exceção de negócio para ser tratada na tela
        } catch (Exception e) {
            // Empacota falhas de rede ou I/O em uma exceção de conexão
            throw new ConexaoApiException("Falha na comunicação com o serviço de clima.", e);
        }
    }
}
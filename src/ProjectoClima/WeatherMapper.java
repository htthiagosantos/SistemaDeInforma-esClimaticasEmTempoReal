package ProjectoClima;

import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

public class WeatherMapper {

    // Dicionário de traduções de inglês para português
    private static final Map<String, String> TRADUCOES = new HashMap<>();

    static {
        TRADUCOES.put("Sunny", "Ensolarado");
        TRADUCOES.put("Clear", "Céu Limpo");
        TRADUCOES.put("Partly cloudy", "Parcialmente Nublado");
        TRADUCOES.put("Cloudy", "Nublado");
        TRADUCOES.put("Overcast", "Encoberto");
        TRADUCOES.put("Mist", "Névoa");
        TRADUCOES.put("Patchy rain possible", "Possibilidade de Chuva Isolada");
        TRADUCOES.put("Light rain", "Chuva Leve");
        TRADUCOES.put("Moderate rain", "Chuva Moderada");
        TRADUCOES.put("Heavy rain", "Chuva Forte");
        TRADUCOES.put("Thundery outbreaks possible", "Possibilidade de Trovoadas");
    }

    public static DadosClimaticos paraDTO(String jsonString) {
        JSONObject dadosJson = new JSONObject(jsonString);
        JSONObject current = dadosJson.getJSONObject("current");
        JSONObject location = dadosJson.getJSONObject("location");

        String condicaoIngles = current.getJSONObject("condition").getString("text");
        
        // Busca a tradução. Se a palavra não estiver no mapa, mantém o texto original em inglês.
        String condicaoPt = TRADUCOES.getOrDefault(condicaoIngles, condicaoIngles);

        return new DadosClimaticos(
            location.getString("name"),
            location.getString("country"),
            current.getString("last_updated"),
            current.getDouble("temp_c"),
            current.getDouble("feelslike_c"),
            condicaoPt, // Passa a condição já traduzida
            current.getInt("humidity"),
            current.getDouble("wind_kph"),
            current.getDouble("pressure_mb")
        );
    }
}
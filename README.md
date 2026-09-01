# 🌤️ Sistema de Informação Climática em Tempo Real

Aplicação Java desenvolvida para consultar e exibir informações meteorológicas em tempo real de qualquer cidade, consumindo uma API REST externa de clima.

## 🚀 Funcionalidades

- **Consulta em Tempo Real:** Busca temperatura, condição do tempo, umidade e outras métricas climáticas.
- **Tratamento de Exceções:** Mensagens amigáveis para cidades não encontradas ou falhas de conexão com a API.
- **Interface via Console:** Interação simples e direta no terminal.
- **Arquitetura Organizada:** Separação clara de responsabilidades entre serviços de API, mapeamento de dados e interface do usuário.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java (JDK 17+)
- **Consumo de API:** `java.net.http.HttpClient`
- **Manipulação de JSON:** Jackson / Gson / Org.JSON


## 🔑 Configuração da Chave de API (API Key)

> ⚠️ **IMPORTANTE:** Para que a aplicação funcione corretamente, é necessário obter uma chave de API gratuita no provedor de clima utilizado (ex: OpenWeatherMap / WeatherAPI) e configurá-la no projeto.

### Passos para configurar:

1. Acesse o site do seu provedor de clima (ex: [OpenWeatherMap](https://openweathermap.org/api) ou [WeatherAPI](https://www.weatherapi.com/)) e crie uma conta gratuita.
2. Gere a sua **API Key** no painel de controle.
3. No arquivo `WeatherService.java`, insira a sua chave na constante responsável ou configure-a como uma variável de ambiente:

## 📁 Estrutura do Projeto

```text
src/ProjectoClima/
├── CidadeNaoEncontradaException.java  # Exceção para busca de cidade inválida
├── ConexaoApiException.java           # Exceção para falhas na requisição/API
├── ConsoleView.java                  # Interface de usuário no terminal
├── DadosClimaticos.java               # Modelo/DTO de dados climáticos
├── WeatherService.java                # Serviço de comunicação HTTP com a API
├── WeatherMapper.java                 # Mapeador da resposta JSON para o modelo
└── ProjetoSistemaDeInforClimaticaEmTempoReal.java # Classe principal (main)

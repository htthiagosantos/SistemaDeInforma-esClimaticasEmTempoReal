package ProjectoClima;

public class ConexaoApiException extends Exception {
    public ConexaoApiException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
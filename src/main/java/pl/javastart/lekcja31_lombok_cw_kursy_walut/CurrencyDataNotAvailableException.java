package pl.javastart.lekcja31_lombok_cw_kursy_walut;

public class CurrencyDataNotAvailableException extends RuntimeException {
    public CurrencyDataNotAvailableException() {
        super("Nie udało się pobrać kursów walut");
    }
}

package pl.javastart.lekcja31_lombok_cw_kursy_walut;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // wsparcie kontrolera
public class ErrorControllerAdvice {

// jak wystapi wyjatek to zwroci strone z bledem
    @ExceptionHandler(CurrencyDataNotAvailableException.class)
    public String handleException() {
        return "nodata";
    }
}

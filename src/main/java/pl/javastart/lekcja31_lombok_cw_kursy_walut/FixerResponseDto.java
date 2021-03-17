package pl.javastart.lekcja31_lombok_cw_kursy_walut;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

@Data //getery setery
public class FixerResponseDto {

//    obiekt responsa

    private boolean success;
    private long timestamp;
    private String base;
    private LocalDate date;
    private Map<String, BigDecimal> rates;


//    odpowiednik nizej
//
//    {
//        "success": true,
//            "timestamp": 1615996929,
//            "base": "EUR",
//            "date": "2021-03-17",
//            "rates": {
//        "AED": 4.371359,
//                "AFN": 91.937437,
//                "ALL": 123.176085,
//                "AMD": 628.018902
}

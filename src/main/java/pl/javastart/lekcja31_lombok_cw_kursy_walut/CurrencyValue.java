package pl.javastart.lekcja31_lombok_cw_kursy_walut;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data //getery setery z lomboka
public class CurrencyValue {

    private String name;
    private BigDecimal value;
}

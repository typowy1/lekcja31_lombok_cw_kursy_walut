package pl.javastart.lekcja31_lombok_cw_kursy_walut;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final FixerService fixerService;

    public HomeController(FixerService fixerService) {
        this.fixerService = fixerService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<CurrencyValue> currencyValues = fixerService.getCurrencyValues();
        model.addAttribute("currencyValues", currencyValues);
        return "home";
    }
}

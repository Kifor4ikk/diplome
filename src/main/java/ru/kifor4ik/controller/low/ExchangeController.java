package ru.kifor4ik.controller.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.ExchangeRateEntity;
import ru.kifor4ik.service.low.ExchangeRateServiceLow;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/low/exchange/")
public class ExchangeController {

    @Autowired
    private ExchangeRateServiceLow exchangeRateService;

    @PostMapping("/")
    public ExchangeRateEntity create(@RequestBody ExchangeRateEntity item) throws SQLException {
        return exchangeRateService.create(item);
    }

    @GetMapping("/{id}")
    public ExchangeRateEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return exchangeRateService.getById(id);
    }

    @PutMapping("/")
    public ExchangeRateEntity update(@RequestBody ExchangeRateEntity item) throws SQLException {
        return exchangeRateService.update(item);
    }

    @DeleteMapping("/")
    public ExchangeRateEntity delete(@RequestParam int id) throws SQLException {
        return exchangeRateService.delete(id);
    }

}

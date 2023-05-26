package ru.kifor4ik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.ExchangeRateEntity;
import ru.kifor4ik.service.ExchangeRateService;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/low/exchange/")
public class ExchangeController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @PostMapping("/")
    public ExchangeRateEntity create(@RequestBody ExchangeRateEntity item) throws Exception {
        return exchangeRateService.create(item);
    }

    @GetMapping("/{id}")
    public ExchangeRateEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return exchangeRateService.getById(id);
    }

    @PutMapping("/")
    public ExchangeRateEntity update(@RequestBody ExchangeRateEntity item) throws Exception {
        return exchangeRateService.update(item);
    }

    @DeleteMapping("/")
    public ExchangeRateEntity delete(@RequestParam int id) throws SQLException {
        return exchangeRateService.delete(id);
    }

}

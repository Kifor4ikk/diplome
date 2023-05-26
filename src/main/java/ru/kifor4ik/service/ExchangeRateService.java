package ru.kifor4ik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.ExchangeRateEntity;
import ru.kifor4ik.repository.ExchangeRateRepository;
import ru.kifor4ik.service.low.AbstractLowService;

import java.sql.SQLException;

@Component
public class ExchangeRateService extends AbstractLowService<ExchangeRateRepository, ExchangeRateEntity> {


    ExchangeRateRepository exchangeRateRepository;
    @Autowired
    public ExchangeRateService(ExchangeRateRepository repository) {
        super(repository);
        this.exchangeRateRepository = repository;
    }



    public ExchangeRateEntity getByCode(String code) throws SQLException {
        return exchangeRateRepository.getByCode(code);
    }

}

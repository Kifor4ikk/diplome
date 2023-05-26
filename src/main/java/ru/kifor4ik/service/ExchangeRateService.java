package ru.kifor4ik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.ExchangeRateEntity;
import ru.kifor4ik.repository.ExchangeRateRepository;
import ru.kifor4ik.service.low.AbstractLowService;

@Component
public class ExchangeRateService extends AbstractLowService<ExchangeRateRepository, ExchangeRateEntity> {

    @Autowired
    public ExchangeRateService(ExchangeRateRepository repository) {
        super(repository);
    }

}

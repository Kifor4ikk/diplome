package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.ExchangeRateEntity;
import ru.kifor4ik.repository.ExchangeRateRepository;

@Component
public class ExchangeRateServiceLow extends AbstractLowService<ExchangeRateRepository, ExchangeRateEntity> {

    @Autowired
    public ExchangeRateServiceLow(ExchangeRateRepository repository) {
        super(repository);
    }

}

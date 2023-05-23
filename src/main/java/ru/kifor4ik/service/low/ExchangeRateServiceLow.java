package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kifor4ik.domain.ExchangeRateToBynEntity;
import ru.kifor4ik.repository.ExchangeRateRepository;

public class ExchangeRateServiceLow extends AbstractLowService<ExchangeRateRepository, ExchangeRateToBynEntity> {

    @Autowired
    public ExchangeRateServiceLow(ExchangeRateRepository repository) {
        super(repository);
    }

}

package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.CardEntity;
import ru.kifor4ik.repository.CardRepository;

@Component
public class CardServiceLow extends AbstractLowService<CardRepository, CardEntity> {

    @Autowired
    public CardServiceLow(CardRepository repository) {
        super(repository);
    }


}

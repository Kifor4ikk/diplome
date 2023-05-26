package ru.kifor4ik.service.medium;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.CardEntity;
import ru.kifor4ik.repository.AbonentRepository;
import ru.kifor4ik.repository.CardRepository;

@Component
public class CardServiceMedium extends AbstractMediumService<CardRepository, CardEntity> {

    public CardServiceMedium(CardRepository repository) {
        super(repository);
    }
}

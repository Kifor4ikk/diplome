package ru.kifor4ik.service.hard;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.CardEntity;
import ru.kifor4ik.repository.prepStatRepo.CardRepositoryPrepState;
@Component
public class CardHardService extends AbstractHardService<CardRepositoryPrepState, CardEntity>{
    public CardHardService(CardRepositoryPrepState repository) {
        super(repository);
    }
}

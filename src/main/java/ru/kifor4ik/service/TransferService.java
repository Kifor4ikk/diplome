package ru.kifor4ik.service;

import ru.kifor4ik.domain.TransferEntity;
import ru.kifor4ik.repository.TransferRepository;
import ru.kifor4ik.service.low.AbstractLowService;

public class TransferService extends AbstractLowService<TransferRepository, TransferEntity> {

    public TransferService(TransferRepository repository) {
        super(repository);
    }
}

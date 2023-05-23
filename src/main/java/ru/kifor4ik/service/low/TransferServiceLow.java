package ru.kifor4ik.service.low;

import ru.kifor4ik.domain.TransferEntity;
import ru.kifor4ik.repository.TransferRepository;

public class TransferServiceLow extends AbstractLowService<TransferRepository, TransferEntity> {

    public TransferServiceLow(TransferRepository repository) {
        super(repository);
    }
}

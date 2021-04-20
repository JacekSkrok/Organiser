package pl.jacek.repository.impl;

import pl.jacek.model.ParticipantEntity;
import pl.jacek.repository.AbstractRepository;

public class ParticipantRepository extends AbstractRepository<ParticipantEntity, Integer> {
    @Override
    protected Class<ParticipantEntity> getPersistentClass() {
        return ParticipantEntity.class;
    }
}

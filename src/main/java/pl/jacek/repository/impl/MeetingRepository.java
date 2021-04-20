package pl.jacek.repository.impl;

import pl.jacek.model.MeetingEntity;
import pl.jacek.repository.AbstractRepository;

public class MeetingRepository extends AbstractRepository<MeetingEntity, Integer> {
    @Override
    protected Class<MeetingEntity> getPersistentClass() {
        return MeetingEntity.class;
    }
}

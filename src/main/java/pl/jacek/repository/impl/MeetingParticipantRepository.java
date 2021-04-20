package pl.jacek.repository.impl;

import pl.jacek.model.MeetingParticipantEntity;
import pl.jacek.repository.AbstractRepository;

public class MeetingParticipantRepository extends AbstractRepository<MeetingParticipantEntity, Integer> {
    @Override
    protected Class<MeetingParticipantEntity> getPersistentClass() {
        return MeetingParticipantEntity.class;
    }
}

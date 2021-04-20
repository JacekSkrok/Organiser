package pl.jacek.repository.impl;

import org.apache.commons.lang3.StringUtils;
import pl.jacek.model.RoleEntity;
import pl.jacek.repository.AbstractRepository;
import pl.jacek.repository.EntityManagerHelper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class RoleRepository extends AbstractRepository<RoleEntity, Integer> {
    @Override
    protected Class<RoleEntity> getPersistentClass() {
        return RoleEntity.class;
    }

    public RoleEntity findByAbbr(String abbr) {
        if (StringUtils.isBlank(abbr)) {
            return null;
        }
        CriteriaBuilder criteriaBuilder = EntityManagerHelper.entityManager().getCriteriaBuilder();
        CriteriaQuery<RoleEntity> criteriaQuery = criteriaBuilder.createQuery(RoleEntity.class);
        Root<RoleEntity> roles = criteriaQuery.from(RoleEntity.class);
        criteriaQuery.where(
                criteriaBuilder.equal(
                        criteriaBuilder.lower(
                                roles.<String>get("abbr")
                        ),
                        abbr.toLowerCase())
        );
        return getFirstResultOrNull(
                EntityManagerHelper.entityManager().createQuery(criteriaQuery).getResultList()
        );
    }

}

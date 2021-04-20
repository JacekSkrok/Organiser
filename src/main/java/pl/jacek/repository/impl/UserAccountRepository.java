package pl.jacek.repository.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import pl.jacek.api.model.RegisterUserRequest;
import pl.jacek.exceptions.ValidationException;
import pl.jacek.model.UserAccountEntity;
import pl.jacek.repository.AbstractRepository;
import pl.jacek.repository.EntityManagerHelper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.Date;

public class UserAccountRepository extends AbstractRepository<UserAccountEntity, Integer> {

    @Override
    protected Class<UserAccountEntity> getPersistentClass() {
        return UserAccountEntity.class;
    }

    public UserAccountEntity findByEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        CriteriaBuilder criteriaBuilder = EntityManagerHelper.entityManager().getCriteriaBuilder();
        CriteriaQuery<UserAccountEntity> criteriaQuery = criteriaBuilder.createQuery(UserAccountEntity.class);
        Root<UserAccountEntity> userAccounts = criteriaQuery.from(UserAccountEntity.class);
        criteriaQuery.where(
                criteriaBuilder.equal(
                        criteriaBuilder.lower(
                                userAccounts.<String>get("email")
                        ),
                        email.toLowerCase())
                );
        return getFirstResultOrNull(
                EntityManagerHelper.entityManager().createQuery(criteriaQuery).getResultList()
        );
    }


}

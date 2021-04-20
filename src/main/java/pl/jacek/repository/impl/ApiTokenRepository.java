package pl.jacek.repository.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import pl.jacek.exceptions.ApiException;
import pl.jacek.model.ApiTokenEntity;
import pl.jacek.model.UserAccountEntity;
import pl.jacek.repository.AbstractRepository;
import pl.jacek.repository.EntityManagerHelper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class ApiTokenRepository extends AbstractRepository<ApiTokenEntity, Integer> {

    @Override
    protected Class<ApiTokenEntity> getPersistentClass() {
        return ApiTokenEntity.class;
    }

    public static ApiTokenEntity findbyAccessToken(String token) {
        if(StringUtils.isBlank(token)) {
            return null;
        }
        CriteriaBuilder criteriaBuilder = EntityManagerHelper.entityManager().getCriteriaBuilder();
        CriteriaQuery<ApiTokenEntity> criteriaQuery = criteriaBuilder.createQuery(ApiTokenEntity.class);
        Root<ApiTokenEntity> tokens = criteriaQuery.from(ApiTokenEntity.class);
        criteriaQuery.where(
                criteriaBuilder.equal(
                        criteriaBuilder.lower(tokens.<String>get("access_token")),
                        token.toLowerCase()
                ),
                criteriaBuilder.greaterThanOrEqualTo(
                        tokens.<Date>get("valid_to"),
                        new Date()
                )
        );
        List<ApiTokenEntity> results = EntityManagerHelper.entityManager().createQuery(criteriaQuery).getResultList();
        if (results == null) {
            return null;
        }
        if (results.isEmpty()) {
            return null;
        }
        return results.get(0);
    }

    public ApiTokenEntity generateApiToken(UserAccountEntity userAccountEntity) throws ApiException {
        if(userAccountEntity == null) {
            throw new ApiException("Undefined user account...");
        }
        ApiTokenEntity apiTokenEntity = new ApiTokenEntity();
        apiTokenEntity.setCreated(new Date());
        apiTokenEntity.setModified(new Date());
        apiTokenEntity.setAccessToken(
                DigestUtils.sha256Hex(
                        RandomStringUtils.randomAlphanumeric(255)
                )
        );
        apiTokenEntity.setRefreshToken(
                DigestUtils.sha256Hex(
                        RandomStringUtils.randomAlphanumeric(255)
                )
        );
        apiTokenEntity.setUserAccountEntity(userAccountEntity);
        apiTokenEntity.setValidTo(
                DateUtils.addMinutes(new Date(), 30)
        );
        EntityManagerHelper.startTransaction();
        merge(apiTokenEntity);
        EntityManagerHelper.commitTransaction();
        return apiTokenEntity;
    }
}

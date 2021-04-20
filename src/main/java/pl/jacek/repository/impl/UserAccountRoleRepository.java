package pl.jacek.repository.impl;

import pl.jacek.exceptions.ValidationException;
import pl.jacek.model.RoleEntity;
import pl.jacek.model.UserAccountEntity;
import pl.jacek.model.UserAccountRoleEntity;
import pl.jacek.repository.AbstractRepository;
import pl.jacek.repository.EntityManagerHelper;

import java.sql.Timestamp;
import java.util.Date;

public class UserAccountRoleRepository extends AbstractRepository<UserAccountRoleEntity, Integer> {
    @Override
    protected Class<UserAccountRoleEntity> getPersistentClass() {
        return UserAccountRoleEntity.class;
    }

    public void assignUserToRole(UserAccountEntity userAccountEntity, RoleEntity roleEntity) throws ValidationException {
        if (roleEntity == null) {
            throw new ValidationException("role");
        }
        if (userAccountEntity == null) {
            throw new ValidationException("UserAccount");
        }
        UserAccountRoleEntity userAccountRoleEntity = new UserAccountRoleEntity();
        userAccountRoleEntity.setCreated((Timestamp) new Date());
        userAccountRoleEntity.setModified((Timestamp) new Date());
        EntityManagerHelper.startTransaction();
        merge(userAccountRoleEntity);
        EntityManagerHelper.commitTransaction();
    }
}

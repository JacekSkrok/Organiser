package pl.jacek.model;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import pl.jacek.exceptions.ValidationException;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_account", schema = "organiser_app", catalog = "")
public class UserAccountEntity {
    private int id;
    private Timestamp created;
    private Timestamp modified;
    private String nickName;
    private String email;
    private String passHash;
    private String passSalt;
    private Integer deleted;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Basic
    @Column(name = "modified")
    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "pass_hash")
    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Basic
    @Column(name = "pass_salt")
    public String getPassSalt() {
        return passSalt;
    }

    public void setPassSalt(String passSalt) {
        this.passSalt = passSalt;
    }

    @Basic
    @Column(name = "deleted")
    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccountEntity that = (UserAccountEntity) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (passHash != null ? !passHash.equals(that.passHash) : that.passHash != null) return false;
        if (passSalt != null ? !passSalt.equals(that.passSalt) : that.passSalt != null) return false;
        if (deleted != null ? !deleted.equals(that.deleted) : that.deleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passHash != null ? passHash.hashCode() : 0);
        result = 31 * result + (passSalt != null ? passSalt.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        return result;
    }

    public boolean validatePass(String password) throws ValidationException {
        if (StringUtils.isBlank(password)) {
            throw new ValidationException("Password is empty");
        }
        return generatePassHash(password, this.passSalt).equalsIgnoreCase(this.passHash);
    }

    private String generatePassHash(String password, String salt) throws ValidationException {
        if (StringUtils.isBlank(password)) {
            throw new ValidationException("Password is empty");
        }
        if (StringUtils.isBlank(salt)) {
            throw new ValidationException("Salt is empty");
        }
        return DigestUtils.sha256Hex(
                String.format(
                        "%s%s",password, salt
                )
        );
    }
}

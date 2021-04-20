package pl.jacek.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "api_token", schema = "organiser_app", catalog = "")
public class ApiTokenEntity {
    private int id;
    private Timestamp created;
    private Timestamp modified;
    private String accessToken;
    private String refreshToken;
    private Timestamp validTo;
    private UserAccountEntity userAccountEntity;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    public UserAccountEntity getUserAccountEntity() { return this.userAccountEntity; }

    public void setUserAccountEntity(UserAccountEntity userAccountEntity) { this.userAccountEntity = userAccountEntity; }

    @Basic
    @Column(name = "created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = (Timestamp) created;
    }

    @Basic
    @Column(name = "modified")
    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = (Timestamp) modified;
    }

    @Basic
    @Column(name = "access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Basic
        @Column(name = "valid_to")
    public Timestamp getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = (Timestamp) validTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiTokenEntity that = (ApiTokenEntity) o;

        if (id != that.id) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (modified != null ? !modified.equals(that.modified) : that.modified != null) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (refreshToken != null ? !refreshToken.equals(that.refreshToken) : that.refreshToken != null) return false;
        if (validTo != null ? !validTo.equals(that.validTo) : that.validTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (modified != null ? modified.hashCode() : 0);
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (refreshToken != null ? refreshToken.hashCode() : 0);
        result = 31 * result + (validTo != null ? validTo.hashCode() : 0);
        return result;
    }
}

package io.github.app;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "languages")
class Lang {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private Integer id;
    private String WELCOME_MSG;
    private String code;

    /**
     *  For Hibernate(JPA) usage
     */
    @SuppressWarnings("unused")
    public Lang() {}

    public Lang(Integer id, String welcomeMsg, String code) {
        this.id = id;
        this.WELCOME_MSG = welcomeMsg;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public String getWelcomeMsg() {
        return WELCOME_MSG;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.WELCOME_MSG = welcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

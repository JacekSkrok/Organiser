package pl.jacek.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static final EntityManagerHelper instance = new EntityManagerHelper();

    private EntityManagerFactory factory;
    private ThreadLocal<EntityManager> localManager;

    public static EntityManagerHelper get() {
        return instance;
    }

    private EntityManagerHelper() {
        factory = Persistence.createEntityManagerFactory("manager");
        localManager = new ThreadLocal<>();
    }

    public static synchronized EntityManager entityManager() {
        EntityManager em = get().localManager.get();
        if (em == null) {
            em = get().factory.createEntityManager();
            get().localManager.set(em);
        }
        return em;
    }

    public static synchronized void closeEntityManager() {
        EntityManager em = get().localManager.get();
        if (em != null) {
            em.close();
            get().localManager.set(null);
        }
    }

    public static synchronized void startTransaction() {
        if(!entityManager().getTransaction().isActive()) {
            entityManager().getTransaction().begin();
        }
    }

    public static synchronized void commitTransaction() {
        if(!entityManager().getTransaction().isActive()) {
            entityManager().getTransaction().commit();
        }
    }

    public static synchronized void rollbackTransaction() {
        if(!entityManager().getTransaction().isActive()) {
            entityManager().getTransaction().rollback();
        }
    }
}

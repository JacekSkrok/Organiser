package io.github.app.todo;

import io.github.app.HibernateUtil;
import io.github.app.lang.Lang;

import java.util.List;
import java.util.Optional;

public class TodoRepository {
    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Todo", Todo.class).list();

        transaction.commit();
        session.close();
        return result;

    }
    public Optional<Lang> findByID(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = Optional.ofNullable(session.get(Lang.class, id));

        transaction.commit();
        session.close();
        return result;
    }

    public Todo toggleTodo(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(Todo.class, id);
        result.setStatus(!result.isStatus());

        transaction.commit();
        session.close();
        return result;
    }

    public Todo addTodo(Todo newTodo) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.persist(newTodo);

        transaction.commit();
        session.close();
        return newTodo;
    }

    public void deleteTodo(Integer id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var junkTodo = session.load(Todo.class, id);
        session.delete(junkTodo);


        transaction.commit();
        session.close();
    }

}

package com.javaguru.shoppinglist;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ShoppingCartRepository implements AbstractShoppingCartRepository  {
    private final SessionFactory sessionFactory;

    public ShoppingCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


@Override
    public Long save(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart.getId();
    }

@Override
    public Optional<ShoppingCart> findById(Long id) {
        ShoppingCart shoppingCart = (ShoppingCart)sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(shoppingCart);
    }

@Override
    public List<ShoppingCart> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class).list();
    }
@Override
    public void delete(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().delete(shoppingCart);

    }
}



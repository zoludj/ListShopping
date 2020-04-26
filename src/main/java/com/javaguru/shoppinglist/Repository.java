package com.javaguru.shoppinglist;

import com.javaguru.shoppinglist.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.Optional;

@org.springframework.stereotype.Repository
@Transactional

public class Repository implements AbstractRepository {


    private final SessionFactory sessionFactory;

    public Repository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public Long save(Product product) {
       sessionFactory.getCurrentSession().save(product);
        return product.getId();

    }

    @Override
    public void deleteProductById(Product product) {

    }

    @Override
    public Optional<Product> findProductById(Long id) {
        Product product = (Product)sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
        return Optional.ofNullable(product);
    }

    @Override
    public boolean existsByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from Product p where p.name=:name";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setString("name",name)
                .setMaxResults(1)
                .uniqueResult();

    }

    @Override
    public Optional<Product> findProductByName(String name) {
        Product product = (Product)sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return Optional.ofNullable(product);

    }
    public void delete(Product product){
        sessionFactory.getCurrentSession().delete(product);
    }
}

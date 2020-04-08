package com.javaguru.shoppinglist;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


@Component


public class Repository implements AbstractRepository {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Product save(Product product) {
        String query = "insert into products (name, info, price, discount) values (" +
                "?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, product.getName());
                    ps.setString(2, product.getInfo());
                    ps.setBigDecimal(3, product.getPrice());
                    ps.setBigDecimal(4, product.getDiscount());
                    return ps;
                },
                keyHolder);
        product.setId(keyHolder.getKey().longValue());
        return product;

    }


    @Override
    public Optional<Product> findProductById(Long id) {
        String query = "select * from products where id=" + id;
        List<Product> products = jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class));
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsByName(String name) {
        String query = "SELECT CASE WHEN count(*)> 0 " +
                "THEN true ELSE false END " +
                "FROM products p where p.name=" + name;
        return jdbcTemplate.queryForObject(query, Boolean.class);
    }

    @Override
    public Optional<Product> findProductName(String name) {
        return Optional.empty();

    }
}

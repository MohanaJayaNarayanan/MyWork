package com.ecommerce.product.xyz.repository.impl;

import com.ecommerce.product.xyz.exception.DataRetrievalException;
import com.ecommerce.product.xyz.model.SearchCriteria;
import com.ecommerce.product.xyz.repository.model.Brand;
import com.ecommerce.product.xyz.repository.model.Product;
import com.ecommerce.product.xyz.repository.SearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchRepositoryImpl implements SearchRepository {

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<Product> getProductOnCriteria(SearchCriteria searchCriteria) {
        List<Product> productOnCriteria = null;

        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Product> query = cb.createQuery(Product.class);
            Root<Product> productRoot = query.from(Product.class);
            List<Predicate> predicateList = new ArrayList<Predicate>();

            if(!StringUtils.isEmpty(searchCriteria.getBrand())) {
                Join<Product, Brand> brandProjectJoin = productRoot.join("brand",JoinType.INNER);
                predicateList.add(cb.equal(brandProjectJoin.get("brand_name"),searchCriteria.getBrand()));
            }
            if(!StringUtils.isEmpty(searchCriteria.getColour())) {
                predicateList.add(cb.equal(productRoot.get("colour"),searchCriteria.getColour()));
            }
            if(searchCriteria.getPrice() !=0) {
                predicateList.add(cb.equal(productRoot.get("price"),searchCriteria.getPrice()));
            }
            if(!StringUtils.isEmpty(searchCriteria.getSize())) {
                predicateList.add(cb.equal(productRoot.get("size"),searchCriteria.getSize()));
            }
            query.where(cb.and(predicateList.toArray(new Predicate[predicateList.size()])));

            productOnCriteria = entityManager.createQuery(query).getResultList();

        }catch(Exception e)
        {
            throw new DataRetrievalException(e.getMessage());
        }
        return productOnCriteria;
    }
}

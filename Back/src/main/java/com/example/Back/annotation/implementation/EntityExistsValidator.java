package com.example.Back.annotation.implementation;


import com.example.Back.annotation.EntityExists;
import com.example.Back.handler.PreventSaveException;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntityExistsValidator implements ConstraintValidator<EntityExists, Object> {
    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> entityClass;
    private String message;
    private String propertyName;
    @Override
    public void initialize(EntityExists constraintAnnotation) {
        entityClass = constraintAnnotation.entityClass();
        propertyName = constraintAnnotation.propertyName();
        this.message = constraintAnnotation.message();
    }

    @Override
    @SneakyThrows
    public boolean isValid(Object propertyValue, ConstraintValidatorContext context) {
        if (propertyValue == null || entityClass == null || propertyName == null) {
            throw new PreventSaveException(message);
        }
        if(propertyName.contains("id")){
            return validateForId(Long.valueOf(propertyValue.toString()), context);
        }else {
            return validateForProperty(propertyValue.toString(), context);
        }

    }

    public boolean validateForId(Long entityId, ConstraintValidatorContext context) throws PreventSaveException {
        if(entityManager.find(entityClass, entityId) != null) return Boolean.TRUE;
        else throw new PreventSaveException(message);
    }

    public boolean validateForProperty(String propertyValue, ConstraintValidatorContext context) throws PreventSaveException {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<?> root = query.from(entityClass);
        query.select(cb.count(root));
        query.where(cb.equal(root.get(propertyName), propertyValue));

        Long count = entityManager.createQuery(query).getSingleResult();

        if (count == 0) {
            throw new PreventSaveException(message);
        }

        return true;
    }
}


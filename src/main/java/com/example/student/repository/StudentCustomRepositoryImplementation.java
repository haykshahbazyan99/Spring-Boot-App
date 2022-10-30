package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentCustomRepositoryImplementation implements StudentCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Student> findByNameAndCity(String name, String city) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();

        Root<Student> student = cq.from(Student.class);

        Predicate namePredicate = cb.equal(student.get("name"), name);
        Predicate cityPredicate = cb.equal(student.get("city"), city);

        cq.where(namePredicate, cityPredicate);

        TypedQuery<Student> query = entityManager.createQuery(cq);

        return query.getResultList();

    }
}

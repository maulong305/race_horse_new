package com.bluebottle.racehorse.repository;

import com.bluebottle.racehorse.model.Horse;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class HorseRepositoryImpl implements HorseRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Horse> findAllByTrainerId(Long id) {
//        String jpql = "select h from Horse h " +
//                "inner join h.accounts a " +
//                "inner join Trainer t on t.account = a " +
//                "where t.id = :trainerId";
        List<String> jpqls = new ArrayList<>();
        jpqls.add("select h from Horse h ");
        jpqls.add("inner join h.accounts a ");
        jpqls.add("inner join Trainer t on t.account = a ");
        jpqls.add("where t.id = :trainerId");
        String jpql = jpqls.stream().reduce("",(current, element) -> current + element);

        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
        query.setParameter("trainerId", id);
        return query.getResultList();
    }

    @Override
    public List<Horse> findAllByTrainerIdAndName(Long id, String name, Pageable pageable) {
//        String jpql = "select h from Horse h " +
//                "inner join h.accounts a " +
//                "inner join Trainer t on t.account = a " +
//                "where t.id = :trainerId ";
//
//            jpql += "and h.name like : horseName";

            List<String> jpqls = new ArrayList<>();
            jpqls.add("select h from Horse h ");
            jpqls.add("inner join h.accounts a ");
            jpqls.add("inner join Trainer t on t.account = a ");
            jpqls.add("where t.id = :trainerId ");
            jpqls.add("and h.name like : horseName");
            String jpql = jpqls.stream().reduce("", (current, element) -> current + element);

        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
        query.setParameter("trainerId", id);
        String str = String.format("%%%s%%", name);
        query.setParameter("horseName",str);
        return query.getResultList();
    }

    @Override
    public List<Horse> findAllByFoaled(Long id, String year, Pageable pageable) {
        Integer pageIndex = pageable.getPageNumber();
        Integer pageSize = pageable.getPageSize();
//        String jpql = "select h from Horse h " +
//                "inner join h.accounts a " +
//                "inner join Trainer t on t.account = a " +
//                "where t.id = :trainerId " +
//                "and year(h.foaled) = :horseFoaled";

        List<String> jpqls = new ArrayList<>();
        jpqls.add("select h from Horse h ");
        jpqls.add("inner join h.accounts a ");
        jpqls.add("inner join Trainer t on t.account = a ");
        jpqls.add("where t.id = :trainerId ");
        jpqls.add("and year(h.foaled) = :horseFoaled");

        String jpql = jpqls.stream().reduce("", (current, element) -> current + element);

        TypedQuery<Horse> query = entityManager.createQuery(jpql, Horse.class);
        query.setFirstResult(pageIndex * pageSize);
        query.setMaxResults(pageSize);
        query.setParameter("trainerId", id);
        query.setParameter("horseFoaled", Integer.valueOf(year));
        return query.getResultList();
    }
}

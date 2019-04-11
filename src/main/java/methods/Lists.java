package methods;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import Entities.Departament;
import Entities.Employee;

public class Lists {
  final static String EMP = "employ";
  
  public static List<Employee> listallEmployees() {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMP);
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emp = cq.from(Employee.class);
    cq.select(emp);
    TypedQuery<Employee> tp = em.createQuery(cq);
    List<Employee> results = tp.getResultList();

    em.close();
    emf.close();

    return results;
  }

  public static List<Departament> listAllDepartaments() {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(EMP);
    EntityManager em = emf.createEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Departament> cq = cb.createQuery(Departament.class);
    Root<Departament> emp = cq.from(Departament.class);
    cq.select(emp);
    TypedQuery<Departament> tp = em.createQuery(cq);
    List<Departament> results = tp.getResultList();

    em.close();
    emf.close();

    return results;
  }
  
  
}

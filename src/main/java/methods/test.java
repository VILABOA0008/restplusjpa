package methods;

//ONLY FOR TESTING
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import Entities.Proyects;
import Entities.Proyects_;

public class test {
  public static void main(String args[]) {


    
    testing();
    
    
    
  }
 
  
  public static void testing(){
    Methods m=new Methods();
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
    
    Float num=432f;
    CriteriaBuilder cb=em.getCriteriaBuilder();
    CriteriaQuery<Proyects> q=cb.createQuery(Proyects.class);
    Root<Proyects> c=q.from(Proyects.class);
    ParameterExpression<Float> pexp = cb.parameter(Float.class, "num");
    q.select(c).where(cb.gt(c.get(Proyects_.ANUAL_COST),pexp));
    
    TypedQuery<Proyects> query = em.createQuery(q);
    query.setParameter("num", num);
      List<Proyects> results = query.getResultList();
   
    results.forEach(n->System.err.println(n.getId()+"  "+n.getAnual_cost()));
    
    
    
    
    /*






   // ParameterExpression<String> p = cb.parameter(String.class);
  //  query.setParameter(p, "66");




    TypedQuery<Proyects> q = em.createQuery("SELECT p FROM Proyects p", Proyects.class);
    List<Proyects> proys = q.getResultList();
    
    TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
    List<Employee> emps = query.getResultList();
    em.getTransaction().begin();
    
    proys.forEach(
        n->n.setAnual_cost((float)emps.stream()
            .filter(a->a.getProy().contains(n)) 
            .mapToDouble(Employee::getSalary) 
            .sum()*12));   
    
    em.getTransaction().commit();
    proys.forEach(n->System.out.println(n.getAnual_cost()));
*/
      }
  }
  


/*

CriteriaBuilder cb=em.getCriteriaBuilder();
CriteriaQuery<Proyects> q=cb.createQuery(Proyects.class);
Root<Proyects> c=q.from(Proyects.class);
q.select(c);

TypedQuery<Proyects> query = em.createQuery(q);
  List<Proyects> results = query.getResultList();

results.forEach(n->System.err.println(n.getId()+"  "+n.getAnual_cost()));

*/
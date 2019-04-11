package samples;

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

public class Samples {

  public static void parameters(    Float num) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
    

    CriteriaBuilder cb=em.getCriteriaBuilder();
    CriteriaQuery<Proyects> q=cb.createQuery(Proyects.class);
    Root<Proyects> c=q.from(Proyects.class);
    ParameterExpression<Float> pexp = cb.parameter(Float.class, "num");
    q.select(c).where(cb.gt(c.get("anual_cost"),pexp));
    
    TypedQuery<Proyects> query = em.createQuery(q);
    query.setParameter("num", num);
      List<Proyects> results = query.getResultList();
   
    results.forEach(n->System.err.println(n.getId()+"  "+n.getAnual_cost()));
    
    
    
  }
  
}

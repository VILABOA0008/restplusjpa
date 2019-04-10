package user;

//ONLY FOR TESTING
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.Departament;
import Entities.Employee;
import Entities.Proyects;

public class test {
  public static void main(String args[]) {

projectcosts(4);
    //testing();
     // createemployee(); 
      //listdeps();
      //System.out.println("sdsdsdsdsdsdsd");      
      //listemployees();
    
  }
  
  public static void projectcosts(int id_pro) {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
    
    TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
    List<Employee> emps = query.getResultList();
    
    Proyects p=em.find(Proyects.class,id_pro);
    
    //LAMBDA WORKING NOT IMPLEMENTED
    double sal=emps
        .stream()
        .filter(a->a.getProy().contains(p))
        .mapToDouble(Employee::getSalary)
        .sum();



    
  }
  
  
  public static void testing(){
    Methods m=new Methods();
    
   
    
    
    // m.asignEmployeeToProyect(4, 87);
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
   
  }
  
  
  public static void createtdep() {
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();    
    Departament d=new Departament("sales");
    try {
    em.getTransaction().begin();
    em.persist(d);
    em.getTransaction().commit();

    }catch(javax.persistence.RollbackException ex) {
        System.out.println(ex.getMessage());
    }

    
    em.close();
    emf.close();   
    
    
  }
  
  public static void listemployees() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
    List<Employee> results = query.getResultList();

    results.forEach(n->{System.out.print("\n"+n.getId()+"  name: "+n.getName());
    if(n.getDept()!=null) {System.out.print("  dept:"+n.getDept().getName());}});
    results.get(0).getName();
    
    em.close();
    emf.close();  
  }
  
  public static void listdeps() {
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();     
       
    TypedQuery<Departament> query = em.createQuery("SELECT p FROM Departament p", Departament.class);
    List<Departament> results = query.getResultList();
    results.forEach((n)->System.out.println(n.getName()));
    
    
    em.close();
    emf.close();  
  }
  
  public static void createemployee() {
    
    
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("employ");
    EntityManager em=emf.createEntityManager();    
    Employee d=new Employee("nuw",42,1212);
    
    try {
    em.getTransaction().begin();
    em.persist(d);
    em.getTransaction().commit();

    }catch(javax.persistence.RollbackException ex) {
        System.out.println(ex.getMessage());
    }

    
    em.close();
    emf.close();   
    
    
  }

}

/*
TypedQuery<Employee> query = em.createQuery("SELECT p FROM Employee p", Employee.class);
List<Employee> results = query.getResultList();
TypedQuery<Departament> que = em.createQuery("SELECT p FROM Departament p", Departament.class);
List<Departament> resdep = que.getResultList();
int c=0;
int id_dep=2;
while(c<2) {
  
  for(Employee e:results) {
    if(e.getDept()==null) {c=0;
    for(int i=0;i<resdep.size();i++) {

      if(Math.random()>0.7) {id_dep=resdep.get(i).getId_dep();break;}
      if(i==resdep.size()-1) {i=0;}
    }
    
    m.asignEmployee(e.getId(), id_dep);
    }

  }c++;
  System.out.println(c+"  reper");
}

*/
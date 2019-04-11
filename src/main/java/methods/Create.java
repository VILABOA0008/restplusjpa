package methods;

import Entities.Departament;
import Entities.Employee;

public class Create {
  final static String EMP = "employ";
  

  public static int createEmployee(String name, int age, float salary) {

    Employee emp = new Employee(name, age, salary);
    Employee aux = (Employee) others.save(emp);

    return aux.getId();
  }

  public static int creaateDepartament(String name) {
    Departament dept = new Departament(name);
    Departament aux = (Departament) others.save(dept);

    return aux.getId_dep();
  }
}

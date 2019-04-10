<html>
<body>
  <form action="./create_departament.jsp" method="post">
    <p>
      DEPARTAMENT ID <input type="text" name="id_dep">
      EMPLOYEE ID <input type="text" name="id_emp">
      <button type="submit" formaction="./rest/serv/dept/asignemp">ASIGN EMPLOYEE</button>
    </p>
    <button formaction="./rest/serv/emp/listall">VIEW EMPLOYEES</button>
    <button formaction="./rest/serv/dept/listall" >VIEW DEPARTAMENTS</button>
  </form>
</body>
</html>



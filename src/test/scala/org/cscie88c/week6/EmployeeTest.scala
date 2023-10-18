package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class EmployeeTest extends StandardTest {
  "Employee" should {
 
    "have a default sort order" in {
      val employees = List(new Employee("Aaron", 30, 100000), new Employee("Bob", 30, 200000))
      val defaultSortedEmployees = Employee.defaultSortEmployees(employees)
      defaultSortedEmployees shouldBe(List(Employee("Aaron", 30, 100000), Employee("Bob", 30, 200000)))
    }

    "sort employees by salary" in {
      val employees = List(Employee("Aaron", 30, 100000),Employee("Bob", 30, 200000))
      val salarySortedEmployees = Employee.sortEmployeesBySalary(employees)
      salarySortedEmployees shouldBe(List(Employee("Bob", 30, 200000), Employee("Aaron", 30, 100000)))
    }
  }
}

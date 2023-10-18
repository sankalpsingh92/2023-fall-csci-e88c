package org.cscie88c.week6

final case class Employee(name: String, age: Int, salary: Int)

object Employee {

  implicit val employeeOrdering: Ordering[Employee] = new Ordering[Employee] {
    def compare(e1 :Employee, e2 :Employee) = (e1.name compare e2.name)
  }

  def defaultSortEmployees(employees: List[Employee]): List[Employee] = employees.sorted


  object SalaryOrdering extends Ordering[Employee] {
    def compare(e1 :Employee, e2 :Employee) = (e1.salary compare e2.salary) * (-1)
  }

  def sortEmployeesBySalary(employees: List[Employee]): List[Employee] = employees.sorted(SalaryOrdering)
  
  implicit val employeeAddableTypeclass: AddableTypeclass[Employee] = new AddableTypeclass[Employee] {
    def addTwoValues(e1: Employee, e2: Employee): Employee = new Employee(e1.name + "," + e2.name, e1.age + e2.age, e1.salary + e2.salary)
  }
  
}

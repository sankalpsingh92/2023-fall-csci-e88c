package org.cscie88c.week6

import org.cscie88c.testutils.{ StandardTest }

class AddableTypeclassTest extends StandardTest {
  
  "AddableAggregator" should {
    "sum a list of integers" in {
      val integers = List(1,2,3,4)
      AddableAggregator.sumWithAddable(integers) shouldBe(10)
    }
    "sum a list of booleans" in {
      val booleans1 = List(true,true,true,false)
      AddableAggregator.sumWithAddable(booleans1) shouldBe(true)

      val booleans2 = List(false,false,false,false)
      AddableAggregator.sumWithAddable(booleans2) shouldBe(false)
    }
    "sum a list of employees" in {
      val employees = List(Employee("ken",25,80000), Employee("burns",35,90000))
      AddableAggregator.sumWithAddable(employees) shouldBe(Employee("ken,burns",60,170000))
    }
  }
}

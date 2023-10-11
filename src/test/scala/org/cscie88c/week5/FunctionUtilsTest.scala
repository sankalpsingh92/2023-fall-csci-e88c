package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import FunctionUtils.CustomerTransaction

// run using: sbt "testOnly org.cscie88c.week5.FunctionUtilsTest"
class FunctionUtilsTest extends StandardTest {
  "FunctionUtils" when {
    // Problem 1 unit tests
    "calling colorToCode" should {
      "return the correct value for white" in {
        FunctionUtils.colorToCode("White") shouldBe(255,255,255)
      }
      "return the correct value for lime" in {
        FunctionUtils.colorToCode("lime") shouldBe(0,255,0)
      }
    }

    "calling fizzBuzzString" should {
      "return the correct value" in {
        FunctionUtils.fizzBuzzString(9) shouldBe("Fizz")
        FunctionUtils.fizzBuzzString(10) shouldBe("Buzz")
        FunctionUtils.fizzBuzzString(15) shouldBe("FizzBuzz")
        FunctionUtils.fizzBuzzString(7) shouldBe("7")
      }
    }

    "calling fizzBuzz" should {
      "return the correct value" in {
        FunctionUtils.fizzBuzz(15) shouldBe(List("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13",  "14", "FizzBuzz"))
      }
    }
    
    "calling tanDegrees" should {
      "verify the partial function tanDegrees is not defined at 90 and -90 degrees" in {
        FunctionUtils.tanDegrees.isDefinedAt(90) shouldBe(false)
        FunctionUtils.tanDegrees.isDefinedAt(-90) shouldBe(false)
      }
    }

    "calling totalHighValueTransactions" should {
      "verify that only high value transactions are included in the sum" in {
        val ct1 = new CustomerTransaction("1","10-11-2023",101)
        val ct2 = new CustomerTransaction("2","10-11-2023",99)
        val ct3 = new CustomerTransaction("3","10-11-2023",102)
        val ct4 = new CustomerTransaction("4","10-11-2023",98)

        FunctionUtils.totalHighValueTransactions(List(ct1,ct2,ct3,ct4)) shouldBe(203)
      }
    }

    "calling flip2" should {
      "function flip2 with math.pow" in {
        FunctionUtils.flip2(math.pow)(5,2) shouldBe(32.0)
      }
    }

     "calling sampleList" should {
      "sampleList using a list of Int values and a list of String values" in {
        FunctionUtils.sampleList(List(1,2,3,4,5,6,7)) shouldBe(List(1,2,3,4,5))
        FunctionUtils.sampleList(List("one","two")) shouldBe(List("one", "two"))
        FunctionUtils.sampleList(List("1","2","3","4","5","6")) shouldBe(List("1","2","3","4","5"))
      }
    }

    // Bonus unit tests
  }

}

package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class FunctionUtilsTest extends StandardTest {

   "FunctionUtils" when {
    "calling applyNtimes" should {
      "return the correct value" in {
        def add5(x: Int) = x + 5
        FunctionUtils.applyNtimes(3)(0)(add5) shouldBe(15)
         
        FunctionUtils.applyNtimes(4)(0)((i : Int) => i + 5) shouldBe(20)
        FunctionUtils.applyNtimes(2)(1)((i : Int) => i + 1) shouldBe(3)
      }

      "return the correct value for myPositivePower" in {
        FunctionUtils.myPositivePower(2, 3) shouldBe(8)
      }
    
    }

    "calling deferredExecutor" should {
      "return the correct value for mydeferredExecutor with add5" in {
        def add5(x: Int) = x + 5
        val myDeferredFunction = FunctionUtils.deferredExecutor("CPU Pool")(add5) 
        val result = myDeferredFunction(4)

        result shouldBe(9)
      }
    
    }

    // write unit tests for other functions here
  }
 
}

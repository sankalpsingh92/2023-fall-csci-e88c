package org.cscie88c.week4

import org.cscie88c.testutils.{StandardTest}

class TrigUtilsTest extends StandardTest {
  
  "TrigUtils" when {
    "calling sin" should {
      "return the correct value for 90" in {
        TrigUtils.sinDegrees(90.0) shouldBe(1.0)
      }
       "return the correct value for 0" in {
        TrigUtils.sinDegrees(0.0) shouldBe(0.0)
      }
    
    }
    "calling cos" should {
      "return the correct value for 90" in {
        TrigUtils.cosDegrees(90.0) shouldEqual 0.0 +- 0.00001
      }
       "return the correct value for 0" in {
        TrigUtils.cosDegrees(0.0) shouldBe(1.0)
      }
    
    }
    "calling squared" should {
      "return the squared value" in {
        TrigUtils.squared(2.0) shouldBe(4.0)
      }    
    }
  }
}

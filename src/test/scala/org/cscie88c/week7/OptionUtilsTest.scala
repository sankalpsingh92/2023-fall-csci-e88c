package org.cscie88c.week7

import org.cscie88c.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class OptionUtilsTest extends StandardTest {
  "OptionUtils" when {
    "calling fileCharCount" should {
      "return the correct number of characters in a valid file" in {
        OptionUtils.fileCharCount("data/dirty-retail-data-sample.csv") shouldBe(Success(195))
      }
    }
    "calling charCountString" should {
      "The string returned for the file data/dirty-retail-data-sample.csv is <number of characters: 195>" in {
        OptionUtils.charCountAsString("data/dirty-retail-data-sample.csv") shouldBe("number of characters: 195")
      }
      "The string returned for the non existing filename data/dirty-retail-data-sample.csv-x is <error opening file>" in {
        OptionUtils.charCountAsString("data/dirty-retail-data-sample.csv-x") shouldBe("error opening file")
      }
    }
  }

}

package org.cscie88c.week7

import org.cscie88c.testutils.{ StandardTest }
import scala.util.{Try, Success, Failure}

class CustomerTransactionTest extends StandardTest {
  "CustomerTransaction" should {
    "unit tests for CustomerTransaction.apply method from 1.1" in {
      // add unit tests below
      CustomerTransaction.apply("id1,customer-A,84.5") shouldBe(Some(CustomerTransaction("id1","customer-A",84.5)))
      CustomerTransaction.apply("id1,customer-A,84.5x") shouldBe(None)
    }
     "test for readFromCSVFile verifying that 5 valid customer records are read from the file data/dirty-retail-data-sample.csv" in {
      // add unit tests below
      CustomerTransaction.readFromCSVFile("data/dirty-retail-data-sample.csv") shouldBe(List(CustomerTransaction("CS5295","11-Feb-13",35.0), CustomerTransaction("CS4768","15-Mar-15",39.0), CustomerTransaction("CS1217","16-Nov-11",99.0), CustomerTransaction("CS1850","20-Nov-13",78.0), CustomerTransaction("CS2724","06-Feb-12",93.0)))
    }
  }

}

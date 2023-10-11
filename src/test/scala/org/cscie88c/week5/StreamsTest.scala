package org.cscie88c.week5

import org.cscie88c.testutils.{ StandardTest }
import Streams.Dog

class StreamsTest extends StandardTest {

  // Bonus problem unit tests
  "calling healthyDogs" should {
      "Verify the function by taking a sample of 5 dogs from the infinite stream of dogs" in {
        val listOfDogs = Streams.dogs.take(5)
        val listOfHealthyDogs = listOfDogs.toList.filter(d => d.hasCurrentShots)

        Streams.healthyDogs(listOfDogs).toList shouldBe(listOfHealthyDogs)

      }
    }

    "calling averageHealthyAge" should {
      "Verify the function by taking a sample of 5 dogs from the infinite stream of dogs" in {
        val listOfDogs = Streams.dogs.take(5)
        val averageHealthyAgeOfDogs = listOfDogs.toList.filter(d => d.hasCurrentShots).size / 5.0

        Streams.averageHealthyAge(listOfDogs, 5) shouldBe(averageHealthyAgeOfDogs)

      }
    }
}

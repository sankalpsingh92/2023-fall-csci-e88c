package org.cscie88c.week7

import org.cscie88c.testutils.{FuturesTest}
import scala.concurrent.Future

class FutureUtilsTest extends FuturesTest {
  
  "Any future function" should {
    "return a future assertion" in {
      def futureAdd2(x: Int) = Future(x + 2)
      futureAdd2(5).map { x =>
        x shouldBe 7
      }
    }
  }

  "FutureFunctions" when {
    "calling creditScoreAPI" should {
      "return a credit score greater than 300" in {
        val userIdsList = (1 to 1000).toList
        val creditScores: Future[List[Int]] = Future.traverse(userIdsList) { id => 
          // call credit score API for each user id in the ids list
          FutureUtils.creditScoreAPI(id).map {  score => 
            score
          }
        }
        creditScores.map {scoresList => 
          scoresList.filter(score => score > 300 && score < 800) shouldBe(scoresList)
        }
      }
    }

     "calling futureFactorial" should {
      "test for futureFactorial verifying that the result of futureFactorial(4) is Future(Success(24))" in {
        // add unit tests below
       FutureUtils.futureFactorial(4).map { x =>
        x shouldBe(24)
       }
      }
    }

    "calling futurePermutations" should {
      "test for futurePermutations" in {
        // add unit tests below
       FutureUtils.futurePermuations(4, 2).map { x =>
        x shouldBe(12)
       }
      }
    }

    "calling asyncAverageCreditScore" should {
      "unit test for asyncAverageCreditScore verifying that the average score is greater than 300 and less than 800" in {
        // add unit tests below
       FutureUtils.asyncAverageCreditScore((1 to 1000).toList).map { averageScore =>
        (averageScore > 300 && averageScore < 800) shouldBe(true)
       }
      }
    }

  }
}

package org.cscie88c.week7

import scala.concurrent.{Future}
import scala.util.{Try, Success, Failure}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Random
import scala.collection.parallel.CollectionConverters._

object FutureUtils {
  
  val rnd = new Random()

  def creditScoreAPI(applicantId: Int): Future[Int] = Future {
    rnd.between(301, 800)
  }

  def printCreditScore(applicantId: Int): Unit = {
    creditScoreAPI(applicantId).onComplete {
      case Success(value) => s"The credit score for ${applicantId} is: ${value}"
      case Failure(exception) =>  s"Cannot get credit score for ${applicantId} at this time"
    }
  }

  def passedCreditCheck(applicantId: Int): Future[Boolean] = {
    creditScoreAPI(applicantId).map { score =>
      if (score > 600) {
       true
      } else {
        false
      }
    }
  }

  def futureFactorial(n: Int): Future[Int] = Future {
    (1 to n).toList.reduce((num1, num2) => num1 * num2)
  }

  def futurePermuations(n: Int, r: Int): Future[Int] = {
    for {
      numerator <- futureFactorial(n)
      denominator <- futureFactorial(n - r)
    } yield {
      numerator / denominator
    }
  }

  def asyncAverageCreditScore(idList: List[Int]): Future[Double] = {
    val creditScores: Future[List[Int]] = Future.traverse(idList) { id => 
      // call credit score API for each user id in the ids list
      FutureUtils.creditScoreAPI(id).map {  score => 
        score
      }
    }

    creditScores.map(scores => {
      scores.reduce((score1, score2) => score1 + score2).toDouble / scores.size.toDouble
    })

  }

  def slowMultiplication(x: Long, y: Long): Long = {
    Thread.sleep(1000)
    x * y
  }

  def concurrentFactorial(n: Long): Long = {
    (1 to n.toInt).toList.map(x => x.toLong).par.reduce((num1, num2) => slowMultiplication(num1,num2))
  
  }

  def sequentialFactorial(n: Long): Long = {
    (1 to n.toInt).toList.map(x => x.toLong).reduce((num1, num2) => slowMultiplication(num1,num2))
  }

}

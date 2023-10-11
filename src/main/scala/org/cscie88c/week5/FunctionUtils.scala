package org.cscie88c.week5

import scala.math

object FunctionUtils {

  case class CustomerTransaction(customerId: String,transactionDate: String,transactionAmount: Double)

  // Problem 1
  def colorToCode(color: String): (Int, Int, Int) = color.toLowerCase match {
    case "black" => (0,0,0)
    case "white" =>  (255,255,255)
    case "red" => (255,0,0)
    case "lime" => (0,255,0)
    case "blue" => (0,0,255)
    case "yellow" => (255,255,0)
  }

  def fizzBuzzString(n: Int): String = n match {
    case n if (n%5 == 0) && (n%3 == 0) => "FizzBuzz"
    case n if (n%3 == 0)  => "Fizz"
    case n if (n%5 == 0)  => "Buzz"
    case _  => n.toString()
  }

  def fizzBuzz(n: Int): List[String] = (1 to n).toList.map(fizzBuzzString)

  // Problem 2
  def tanDegrees: PartialFunction[Double, Double] = {
    new PartialFunction[Double, Double] {
      override def apply(args: Double) : Double = {
        val degree = (args % 360 + 360) % 360
        val radian = (math.Pi*degree)/180.0
        math.tan(radian)
      }
      override def isDefinedAt(x: Double) : Boolean = {
         val degree = (x % 360.0 + 360.0) % 360
        (degree != 90.0) && (degree !=  270.0)
      }
    }
  }

  def totalHighValueTransactions(transactionList: List[CustomerTransaction]): Double = {
    val highValueTransaction: PartialFunction [CustomerTransaction, Double] = {
      case ct if ct.transactionAmount > 100 => ct.transactionAmount 
    }

    transactionList.collect(highValueTransaction).sum
  }

    def totalHighValueTransactionsFilterMapimplementation(transactionList: List[CustomerTransaction]): Double = {

    transactionList.filter(ct => ct.transactionAmount>100.0).map(ct => ct.transactionAmount).sum

  }

  // Problem 3
  def flip2[A, B, C](f: (A, B) => C): (B, A) => C = {
    (B, A) => {
      f(A,B)
    }
  }

  def sampleList[A](l : List[A]) : List[A] = {
    l.take(5)
  }

def deferredExecutor[A, B](name: String)(f: A => B): A => B = {
  (a: A) => {
    println(s"running on deferred executor ${name} with value ${a}")
    f(a)
  }
}

}

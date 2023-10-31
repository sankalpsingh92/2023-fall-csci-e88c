package org.cscie88c.week8

import com.typesafe.scalalogging.LazyLogging
import scala.util.{Try, Success, Failure}
import scala.io.Source

// run using: sbt "runMain org.cscie88c.week8.SimpleApp1 <args>"
object SimpleApp1 extends LazyLogging {
  
  def lineStreamFromFile(fileName: String): Option[LazyList[String]] =
    Try {
      LazyList.from(Source.fromResource(fileName).getLines())
    }.toOption
  
  def monthLines(month: String)(lines: LazyList[String]): LazyList[String] = {
      lines.filter(x  => 
        try {
          x.split(",").apply(1).split("-").apply(1) == month
      } catch {
        case _  => false
      }
      )
  }
      
  def main(args: Array[String]): Unit = {
    val fileName = args(0)
    val month = args(1)

    val lines = lineStreamFromFile(fileName)

    lines match {
      case None => println(s"No Transactions found for ${month}")
      case Some(value) => println(s"Transactions in ${month}: ${monthLines(month)(value).size}")
    }
  }

}

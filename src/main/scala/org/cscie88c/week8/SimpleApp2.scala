package org.cscie88c.week8

import com.typesafe.scalalogging.LazyLogging
import scala.util.{Try, Success, Failure}
import scala.io.Source
import org.cscie88c.config.{ConfigUtils}
import pureconfig.generic.auto._

// write case class here

case class SimpleApp2Config(fileName: String, month: String)

// run with: sbt "runMain org.cscie88c.week8.SimpleApp2"
object SimpleApp2 extends LazyLogging{

  val CONF_PATH = "org.cscie88c.simple-app-2"
  

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
    val conf = ConfigUtils.loadAppConfig[SimpleApp2Config](CONF_PATH)
    
    val fileName = conf.fileName
    val month = conf.month

    val lines = lineStreamFromFile(fileName)

    lines match {
     case None => println(s"No Transactions found for ${month}")
     case Some(value) => println(s"Transactions in ${month}: ${monthLines(month)(value).size}")
    }
  }
}

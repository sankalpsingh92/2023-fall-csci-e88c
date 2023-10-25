package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

object OptionUtils {
  
  def fileCharCount(fileName: String): Try[Long] = Try {
    val resource = Source.fromResource(fileName)
    val lines = resource.getLines().toList
    val linecnt = lines.size
    lines.map(l => l.size).reduce((l1, l2) => l1 + l2) + linecnt
  }

  def charCountAsString(fileName: String): String = {
    try {
      fileCharCount(fileName)
    } match {
      case Success(value) => s"number of characters: ${value}"
      case Failure(exception) => "error opening file"
    }
  }

  def lineStreamFromFile(fileName: String): Option[LazyList[String]] = Try {
    val resource = Source.fromResource(fileName)
    val lines : LazyList[String] = LazyList(resource.getLines().toList :_*)
    lines
  }.toOption
}

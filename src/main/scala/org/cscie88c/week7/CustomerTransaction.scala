package org.cscie88c.week7

import scala.io.Source
import scala.util.{Try, Success, Failure}

final case class CustomerTransaction(
  customerId: String,
  transactionDate: String,
  transactionAmount: Double
)

object CustomerTransaction {
  // add companion object methods below
  def apply(csvString: String): Option[CustomerTransaction] = Try {
    val fields = csvString.split(",")
    val customerId = fields.apply(0)
    val transactionDate = fields.apply(1)
    val transactionAmount = fields.apply(2).toDouble
    new CustomerTransaction(customerId, transactionDate, transactionAmount)
  }.toOption

  def readFromCSVFile(fileName: String): List[CustomerTransaction] = {
    val resource = Source.fromResource(fileName)
    val lines = resource.getLines().toList
    lines.map(customerTransaction => CustomerTransaction(customerTransaction)).filter(customerTransaction => customerTransaction != None).map(x => x.get).toList
  }
}
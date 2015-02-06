package com.company.tables

import com.company.models.Customer

import scala.slick.driver.JdbcProfile

class CustomersTable(implicit val profile: JdbcProfile) extends ModelTable {
  import profile.simple._

  class Customers(tag: Tag) extends AbstractModelTable[Customer](tag, "customers") {
    def name = column[String]("name", O.NotNull, O.Length(255, true))
    def * = (name, id.?) <> (Customer.tupled, Customer.unapply _)
  }

  val query = TableQuery[Customers]

}

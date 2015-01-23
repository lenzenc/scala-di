package com.company.tables

import com.company.models.Customer

import scala.slick.driver.JdbcProfile

class CustomersTable(implicit val driver: JdbcProfile) extends Table {
  import profile.simple._

  def query = TableQuery[Customers]

  class Customers(tag: Tag) extends ModelTable[Customer](tag, "customers") {
    def name = column[String]("name", O.NotNull, O.Length(255, true))
    def * = (name, id.?) <> (Customer.tupled, Customer.unapply _)
  }

}

package com.company.tables

import com.company.config.database.DBProfile
import com.company.models.Customer

import scala.slick.driver.JdbcProfile

class CustomersTable(val driver: JdbcProfile) extends ModelTable with DBProfile {
  import profile.simple._

  class Customers(tag: Tag) extends AbstractModelTable[Customer](tag, "customers") {
    def name = column[String]("name", O.NotNull, O.Length(255, true))
    def * = (name, id.?) <> (Customer.tupled, Customer.unapply _)
  }

  val query = TableQuery[Customers]

}

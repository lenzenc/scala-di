package com.company.tables.slick

import com.company.models.Customer

import scala.slick.driver.JdbcProfile

class CustomerTable(val driver: JdbcProfile) extends DataTable {
  import profile.simple._

  lazy val table = TableQuery[Customers]

  class Customers(tag: Tag) extends Table[Customer](tag, "customers") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def name = column[String]("name", O.NotNull, O.Length(255, true))
    def * = (name, id) <> (Customer.tupled, Customer.unapply _)
  }

}

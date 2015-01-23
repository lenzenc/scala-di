package com.company.tables.slick

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.models.Customer

trait CustomerTable extends TableSupport { self: DatabaseProfile =>
  import profile.simple._

  def customersTable = TableQuery[Customers]

  class Customers(tag: Tag) extends ModelTable[Customer](tag, "customers") {
    def name = column[String]("name", O.NotNull, O.Length(255, true))
    def * = (name, id.?) <> (Customer.tupled, Customer.unapply _)
  }

}

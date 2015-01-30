package com.company.context

import com.company.config.database.DBProfile
import com.company.tables.{UsersTable, CustomersTable}

trait TablesModule { this: DBProfile =>
  import profile.simple._

  protected implicit lazy val customersTable = new CustomersTable
  protected implicit lazy val usersTable = new UsersTable

  def createTables(implicit session: Session) = {
    customersTable.create
    usersTable.create
  }

}

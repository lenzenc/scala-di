package com.company.context

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.tables.{UsersTable, CustomersTable}

trait TablesModule { self: DatabaseProfile =>
  import profile.simple._

  protected implicit lazy val customersTable = new CustomersTable
  protected implicit lazy val usersTable = new UsersTable

  protected lazy val tables = customersTable.query.ddl ++ usersTable.query.ddl

}

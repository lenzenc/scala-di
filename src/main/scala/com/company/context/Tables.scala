package com.company.context

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.tables.slick.{CustomerTable, UserTable}

trait Tables extends CustomerTable with UserTable { self: DatabaseProfile =>
  import profile.simple._

  protected lazy val tables = customersTable.ddl ++ usersTable.ddl

}

package com.company.context

import com.company.config.database.DBProfile
import com.company.tables.{UsersTable, CustomersTable}

trait TablesModule { this: DBProfile =>
  import profile.simple._

  protected lazy val customersTable = new CustomersTable(driver)
  protected lazy val usersTable = new UsersTable(customersTable, driver)

  private val tables = List(
    customersTable,
    usersTable
  )

  def createTables(implicit session: Session) = for (t <- tables) try { t.create } catch { case _: Exception => true }

  def dropTables(implicit session: Session) = for (t <- tables) try { t.drop } catch { case _: Exception => true }

}

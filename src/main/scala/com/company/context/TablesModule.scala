package com.company.context

import com.company.config.database.DBProfile
import com.company.tables.{UsersTable, CustomersTable}

import scala.slick.driver.JdbcProfile

trait TablesModule extends DBProfile {
  import profile.simple._

  protected lazy val customersTable = new CustomersTable
  protected lazy val usersTable = new UsersTable(customersTable)

  private val tables = List(
    customersTable,
    usersTable
  )

  def createTables(implicit session: Session) = for (t <- tables) try { t.create } catch { case _: Exception => true }

  def dropTables(implicit session: Session) = for (t <- tables) try { t.drop } catch { case _: Exception => true }

}

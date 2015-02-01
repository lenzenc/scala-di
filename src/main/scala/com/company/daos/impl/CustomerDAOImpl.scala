package com.company.daos.impl

import com.company.SortOrder
import com.company.SortOrder._
import com.company.config.database.DBProfile
import com.company.daos.CustomerDAO
import com.company.models.Customer
import com.company.tables.CustomersTable

import scala.slick.driver.JdbcProfile

class CustomerDAOImpl(
  val customersTable: CustomersTable,
  val driver: JdbcProfile)
  extends CustomerDAO with DBProfile
{
  import profile.simple._

  def findAll(sortOrder: SortOrder = SortOrder.ASC)(implicit s: Session): List[Customer] = {
    customersTable.query.sortBy(
      sortOrder match {
        case SortOrder.ASC => _.name.asc
        case SortOrder.DESC => _.name.desc
      }
    ).list
  }

  def findByPK(pk: Long)(implicit s: Session): Option[Customer] = customersTable.query.filter(_.id === pk).firstOption

}

package com.company.daos.impl

import com.company.SortOrder
import com.company.SortOrder._
import com.company.daos.CustomerDAO
import com.company.models.Customer

import scala.slick.driver.JdbcProfile

class CustomerDAOImpl(implicit val driver: JdbcProfile) extends CustomerDAO {
  import profile.simple._

  def findAll(sortOrder: SortOrder = SortOrder.ASC)(implicit s: Session): List[Customer] = {
    customersTable.sortBy(
      sortOrder match {
        case SortOrder.ASC => _.name.asc
        case SortOrder.DESC => _.name.desc
      }
    ).list
  }

  def findByPK(pk: Long)(implicit s: Session): Option[Customer] = customersTable.filter(_.id === pk).firstOption

  val customersTable = TableQuery[Customers]

  class Customers(tag: Tag) extends ModelTable[Customer](tag, "customers") {
    def name = column[String]("name", O.NotNull, O.Length(255, true))
    def * = (name, id.?) <> (Customer.tupled, Customer.unapply _)
  }

}

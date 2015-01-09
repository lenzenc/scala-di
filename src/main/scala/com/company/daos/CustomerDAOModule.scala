package com.company.daos

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.models.Customer
import com.company.tables.slick.CustomerTable
import com.company.SortOrder
import com.company.SortOrder._

trait CustomerDAOModule { self: CustomerTable with DatabaseProfile =>
  import profile.simple._

  def customerDAO: CustomerDAO

  trait CustomerDAO {

    def findAll(sortOrder: SortOrder = SortOrder.ASC)(implicit s: Session): List[Customer]

    def findByPK(pk: Long)(implicit s: Session): Option[Customer]

  }

  class CustomerDAOImpl extends CustomerDAO {

    def findAll(sortOrder: SortOrder = SortOrder.ASC)(implicit s: Session): List[Customer] = {
      customersTable.sortBy(
        sortOrder match {
          case SortOrder.ASC => _.name.asc
          case SortOrder.DESC => _.name.desc
        }
      ).list
    }

    def findByPK(pk: Long)(implicit s: Session): Option[Customer] = customersTable.filter(_.id === pk).firstOption

  }

}

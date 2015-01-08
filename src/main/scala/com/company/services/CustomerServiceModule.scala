package com.company.services

import com.company.config.database.slick.DatabaseFactory
import com.company.daos.CustomerDAOModule
import com.company.models.Customer
import com.company.SortOrder
import com.company.SortOrder._

trait CustomerServiceModule { self: CustomerDAOModule with DatabaseFactory =>

  def customerService: CustomerService

  trait CustomerService {

    def list: Seq[Customer]

    def get(pk: Long): Option[Customer]

  }

  class CustomerServiceImpl() extends  CustomerService {

    private lazy val db = database()

    def list: Seq[Customer] = db.withSession { implicit session =>
        customerDAO.findAll(SortOrder.ASC)
    }

    def get(pk: Long): Option[Customer] = db.withSession { implicit session =>
      customerDAO.findByPK(pk)
    }

  }

}

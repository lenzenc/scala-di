package com.company.services

import com.company.config.database.slick.SessionFactory
import com.company.daos.CustomerDAOModule
import com.company.models.Customer
import com.company.SortOrder

trait CustomerServiceModule { self: CustomerDAOModule with SessionFactory =>

  def customerService: CustomerService

  trait CustomerService {

    def list: List[Customer]

    def get(pk: Long): Option[Customer]

  }

  class CustomerServiceImpl() extends  CustomerService {

    def list: List[Customer] = inSession { implicit session =>
      customerDAO.findAll(SortOrder.ASC)
    }

    def get(pk: Long): Option[Customer] = inSession { implicit session =>
      customerDAO.findByPK(pk)
    }

  }

}

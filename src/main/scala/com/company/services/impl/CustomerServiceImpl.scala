package com.company.services.impl

import com.company.config.database.slick.DBFactory
import com.company.daos.CustomerDAO
import com.company.models.Customer
import com.company.services.CustomerService

class CustomerServiceImpl(customerDAO: CustomerDAO, dBFactory: DBFactory) extends CustomerService {

  private lazy val db = dBFactory.database()

  def list(): Seq[Customer] = db.withSession { implicit session => customerDAO.findAll() }

}

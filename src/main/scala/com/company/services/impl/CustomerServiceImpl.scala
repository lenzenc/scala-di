package com.company.services.impl

import com.company.SortOrder
import com.company.config.database.{DB, SessionFactory}
import com.company.daos.CustomerDAO
import com.company.models.Customer
import com.company.services.CustomerService

class CustomerServiceImpl(
  implicit val customerDAO: CustomerDAO,
  implicit val sessionFactory: SessionFactory)
  extends CustomerService with DB
{

  import sessionFactory._

  def list: List[Customer] = inSession { implicit session =>
    customerDAO.findAll(SortOrder.ASC)
  }

  def get(pk: Long): Option[Customer] = inSession { implicit session =>
    customerDAO.findByPK(pk)
  }

}

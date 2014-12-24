package com.company.daos.impl

import com.company.daos.CustomerDAO
import com.company.models.Customer
import com.company.tables.slick.CustomerTable

import scala.slick.driver.JdbcProfile

class CustomerDAOImpl(val driver: JdbcProfile, customers: CustomerTable) extends CustomerDAO {
  import profile.simple._

  def findAll()(implicit s: Session): Seq[Customer] = customers.table.list

}

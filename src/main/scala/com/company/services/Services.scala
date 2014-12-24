package com.company.services

import com.company.config.database.slick.DBSupport
import com.company.daos.impl.CustomerDAOImpl
import com.company.services.impl.CustomerServiceImpl
import com.company.tables.slick.Tables

trait Services extends Tables with DBSupport {

  protected val customerDAO = new CustomerDAOImpl(driver, customers)

  val customerService = new CustomerServiceImpl(customerDAO, dbFactory)

}

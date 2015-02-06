package com.company.context

import com.company.config.database.DB
import com.company.services.impl.{UserServiceImpl, CustomerServiceImpl}

trait ServicesModules extends DAOsModule with DB {

  protected lazy val customerService = new CustomerServiceImpl(customerDAO)
  protected lazy val userService = new UserServiceImpl(userDAO)

}

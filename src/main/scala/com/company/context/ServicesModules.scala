package com.company.context

import com.company.config.database.{DBProfile, DB}
import com.company.services.impl.{UserServiceImpl, CustomerServiceImpl}

trait ServicesModules extends DAOsModule { this: DB with DBProfile =>

  protected lazy val customerService = new CustomerServiceImpl(customerDAO, sessionFactory)
  protected lazy val userService = new UserServiceImpl(userDAO, sessionFactory)

}

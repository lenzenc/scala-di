package com.company.context

import com.company.config.database.DBProfile
import com.company.daos.{CustomerDAO, UserDAO}
import com.company.daos.impl.{UserDAOImpl, CustomerDAOImpl}

trait DAOsModule extends TablesModule { this: DBProfile =>

  protected implicit lazy val customerDAO: CustomerDAO = new CustomerDAOImpl
  protected implicit lazy val userDAO: UserDAO = new UserDAOImpl

}

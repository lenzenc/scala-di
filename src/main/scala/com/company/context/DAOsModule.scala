package com.company.context

import com.company.config.database.DBProfile
import com.company.daos.{CustomerDAO, UserDAO}
import com.company.daos.impl.{UserDAOImpl, CustomerDAOImpl}

trait DAOsModule extends TablesModule with DBProfile {

  protected lazy val customerDAO: CustomerDAO = new CustomerDAOImpl(customersTable)
  protected lazy val userDAO: UserDAO = new UserDAOImpl(usersTable)

}

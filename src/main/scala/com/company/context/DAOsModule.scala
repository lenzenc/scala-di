package com.company.context

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.daos.{CustomerDAO, UserDAO}
import com.company.daos.impl.{UserDAOImpl, CustomerDAOImpl}

trait DAOsModule extends TablesModule with DatabaseProfile {

  implicit protected lazy val customerDAO: CustomerDAO = new CustomerDAOImpl
  implicit protected lazy val userDAO: UserDAO = new UserDAOImpl

}

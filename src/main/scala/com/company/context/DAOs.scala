package com.company.context

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.daos.{CustomerDAOModule, UserDAOModule}

trait DAOs extends CustomerDAOModule with UserDAOModule with Tables with DatabaseProfile {

  lazy val customerDAO: CustomerDAO = new CustomerDAOImpl
  lazy val userDAO: UserDAO = new UserDAOImpl

}

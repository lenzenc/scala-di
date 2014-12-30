package com.company.context

import com.company.config.database.slick.DatabaseFactory
import com.company.services.{CustomerServiceModule, UserServiceModule}

trait Services extends CustomerServiceModule with UserServiceModule with DatabaseFactory with DAOs {

  lazy val customerService = new CustomerServiceImpl
  lazy val userService = new UserServiceImpl

}

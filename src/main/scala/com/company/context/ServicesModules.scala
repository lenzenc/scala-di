package com.company.context

import com.company.config.database.slick.SessionFactory
import com.company.services.{CustomerServiceModule, UserServiceModule}

trait ServicesModules extends CustomerServiceModule with UserServiceModule with SessionFactory with DAOsModule {

  lazy val customerService = new CustomerServiceImpl
  lazy val userService = new UserServiceImpl

}

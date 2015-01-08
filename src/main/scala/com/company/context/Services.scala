package com.company.context

import com.company.config.database.slick.SessionFactory
import com.company.services.{CustomerServiceModule, UserServiceModule}

trait Services extends CustomerServiceModule with UserServiceModule with SessionFactory with DAOs {

  lazy val customerService = new CustomerServiceImpl
  lazy val userService = new UserServiceImpl

}

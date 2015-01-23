package com.company.context

import com.company.config.database.slick.SessionFactory
import com.company.services.impl.{UserServiceImpl, CustomerServiceImpl}

trait ServicesModules extends DAOsModule {

  protected implicit def sessionFactory: SessionFactory

  protected implicit lazy val customerService = new CustomerServiceImpl
  protected implicit lazy val userService = new UserServiceImpl

}

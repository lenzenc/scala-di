package com.company

import com.company.config.database._
import com.company.context.AppModule

trait Application extends AppModule with DB with H2DBProfile {

  protected implicit lazy val sessionFactory: SessionFactory = new ConfigSessionFactory(driver)

}

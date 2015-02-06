package com.company

import com.company.config.Configuration
import com.company.config.database._
import com.company.config.database.ds.BoneCPDataSourceFactory
import com.company.context.AppModule

trait Application extends AppModule with DB with H2DBProfile {

  lazy val config = Configuration.load
  lazy val dataSourceFactory = new BoneCPDataSourceFactory(config)

  protected lazy val sessionFactory: SessionFactory = new ConfigSessionFactory(
    dataSourceFactory,
    config)

}

package com.company.config.database

trait H2DB extends DB with H2DBProfile {

  protected lazy val sessionFactory: SessionFactory = new H2SessionFactory

}

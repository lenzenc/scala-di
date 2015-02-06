package com.company.config.database

trait H2DB extends DB with H2DBProfile {

  protected implicit lazy val sessionFactory: SessionFactory = new H2SessionFactory

}

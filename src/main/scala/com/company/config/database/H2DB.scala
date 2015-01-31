package com.company.config.database

trait H2DB extends DB with H2DBProfile {

  protected implicit def sessionFactory: SessionFactory = new H2SessionFactory

}

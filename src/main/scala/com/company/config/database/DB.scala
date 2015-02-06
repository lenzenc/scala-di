package com.company.config.database

trait DB {

  protected implicit val sessionFactory: SessionFactory

}

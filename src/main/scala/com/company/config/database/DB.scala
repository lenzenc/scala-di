package com.company.config.database

trait DB {

  protected implicit def sessionFactory: SessionFactory

}

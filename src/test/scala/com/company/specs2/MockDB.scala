package com.company.specs2

import com.company.config.database.{H2DBProfile, SessionFactory, DB}

trait MockDB extends DB {

  lazy val sessionFactory: SessionFactory = new MockedSessionFactory with H2DBProfile

}
package com.company.specs2

import com.company.config.database.{H2DBProfile, SessionFactory, DB}

trait MockDB extends DB with H2DBProfile {

  lazy val sessionFactory: SessionFactory = new MockedSessionFactory

}
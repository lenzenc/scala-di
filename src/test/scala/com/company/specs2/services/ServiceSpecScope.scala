package com.company.specs2.services

import com.company.specs2.{MockDB, SpecScope}
import org.specs2.mock.Mockito

import scala.slick.driver.JdbcDriver

trait ServiceSpecScope extends SpecScope with MockDB with Mockito {

  protected implicit lazy val driver = JdbcDriver

  protected implicit lazy val session = sessionFactory.createSession(sessionFactory.defaultDBName)

}
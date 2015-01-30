package com.company.specs2.services

import com.company.config.database.DatabaseProfile
import com.company.specs2.{MockedSessionFactory, SpecScope}
import org.specs2.mock.Mockito

import scala.slick.driver.JdbcDriver

trait ServiceSpecScope extends SpecScope with MockedSessionFactory with DatabaseProfile with Mockito {

  protected lazy val driver = JdbcDriver

  protected implicit lazy val session = createSession(defaultDBName)

}
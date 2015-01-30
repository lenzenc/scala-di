package com.company.specs2.http.apis

import com.company.config.database.DatabaseProfile
import com.company.http.JsonImplicits
import com.company.specs2.{MockedSessionFactory, SpecScope}

import scala.slick.driver.JdbcDriver

trait APISpecScope extends SpecScope with JsonImplicits with MockedSessionFactory with DatabaseProfile {

  protected lazy val driver = JdbcDriver

}

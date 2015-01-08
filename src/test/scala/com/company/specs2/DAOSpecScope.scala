package com.company.specs2

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.context.Tables

import scala.slick.driver.{H2Driver, JdbcProfile}

trait DAOSpecScope extends SpecScope with Tables with DatabaseProfile {

  protected lazy val driver: JdbcProfile = H2Driver

}

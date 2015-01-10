package com.company.specs2.daos

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.context.TablesModule
import com.company.specs2.SpecScope

import scala.slick.driver.{H2Driver, JdbcProfile}

trait DAOSpecScope extends SpecScope with TablesModule with DatabaseProfile {

  protected lazy val driver: JdbcProfile = H2Driver

}

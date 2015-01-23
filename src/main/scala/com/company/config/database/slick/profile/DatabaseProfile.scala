package com.company.config.database.slick.profile

import scala.slick.driver.{H2Driver, JdbcProfile}

trait DatabaseProfile {

  protected def driver: JdbcProfile

  protected lazy val profile: JdbcProfile = driver

}

trait H2DatabaseProfile extends DatabaseProfile {

  protected def driver: JdbcProfile = H2Driver

}

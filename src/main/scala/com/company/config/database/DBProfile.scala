package com.company.config.database

import scala.slick.driver.{H2Driver, JdbcProfile}

trait DBProfile {

  protected def driver: JdbcProfile

  protected implicit lazy val profile: JdbcProfile = driver

}

trait H2DBProfile extends DBProfile {

  protected lazy val driver: JdbcProfile = H2Driver

}

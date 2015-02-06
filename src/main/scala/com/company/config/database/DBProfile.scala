package com.company.config.database

import scala.slick.driver.{H2Driver, JdbcProfile}

trait DBProfile {

  protected implicit val profile: JdbcProfile

}

trait H2DBProfile extends DBProfile {

  protected implicit lazy val profile: JdbcProfile = H2Driver

}

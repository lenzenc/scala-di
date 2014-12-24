package com.company.config.database.slick

import scala.slick.driver.JdbcProfile

trait DBProfile {

  def driver: JdbcProfile

  lazy val profile = driver

}

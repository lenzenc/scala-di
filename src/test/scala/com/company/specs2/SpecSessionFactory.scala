package com.company.specs2

import com.company.config.database.slick.SessionFactory
import com.company.config.database.slick.profile.DatabaseProfile

import scala.slick.driver.{H2Driver, JdbcProfile}

trait SpecSessionFactory extends SessionFactory { self: DatabaseProfile =>

  protected lazy val driver: JdbcProfile = H2Driver

  import profile.simple._

  protected lazy val db = Database.forURL("jdbc:h2:mem:specs2;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")

  protected def database(databaseName:String): Database = db

}

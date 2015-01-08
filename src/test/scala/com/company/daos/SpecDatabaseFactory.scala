package com.company.daos

import com.company.config.database.slick.DatabaseFactory

import scala.slick.driver.{H2Driver, JdbcProfile}

trait SpecDatabaseFactory extends DatabaseFactory {

  protected lazy val driver: JdbcProfile = H2Driver

  import profile.simple._

  protected def database(databaseName:String = defaultDBName): Database = {
    Database.forURL("jdbc:h2:mem:specs2;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
  }

}

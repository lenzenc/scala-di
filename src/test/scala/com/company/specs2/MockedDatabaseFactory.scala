package com.company.specs2

import com.company.config.database.slick.DatabaseFactory
import org.specs2.mock.Mockito

import scala.slick.driver.H2Driver

trait MockedDatabaseFactory extends DatabaseFactory with Mockito {

  protected lazy val driver = H2Driver

  import profile.simple._

  protected def database(databaseName:String = defaultDBName): Database = {
    Database.forURL("jdbc:h2:mem:specs2;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
  }

}



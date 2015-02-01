package com.company.config.database

class H2SessionFactory(url: String = "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1") extends SessionFactory with H2DBProfile {
  import profile.simple._

  protected def database(databaseName:String): Database = Database.forURL(url, driver = "org.h2.Driver")

}
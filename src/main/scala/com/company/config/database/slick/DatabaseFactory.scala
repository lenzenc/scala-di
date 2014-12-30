package com.company.config.database.slick

import com.company.config.database.slick.profile.DatabaseProfile

trait DatabaseFactory extends DatabaseProfile {
  import profile.simple._

  protected val defaultDBName = "default"

  protected def database(databaseName:String = defaultDBName): Database

}

package com.company

import com.company.config.Configuration
import com.company.config.database.slick.{SeededDatabaseInitializer, ConfigDatabaseFactory}
import com.company.config.database.slick.profile.H2DatabaseProfile
import com.company.context.AppContext

trait Application extends AppContext with ConfigDatabaseFactory with H2DatabaseProfile with SeededDatabaseInitializer {

  override def configuration = Configuration.load

}

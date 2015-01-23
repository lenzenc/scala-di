package com.company

import com.company.config.Configuration
import com.company.config.database.slick.{SessionFactory, ConfigSessionFactory}
import com.company.config.database.slick.profile.{DatabaseProfile, H2DatabaseProfile}
import com.company.context.AppModule

trait Application extends AppModule with SessionFactory with DatabaseProfile {

//  override def configuration = Configuration.load

}

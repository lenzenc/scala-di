package com.company

import com.company.config.Configuration
import com.company.config.database.slick.ConfigSessionFactory
import com.company.config.database.slick.profile.H2DatabaseProfile
import com.company.context.AppContext

trait Application extends AppContext with ConfigSessionFactory with H2DatabaseProfile {

  override def configuration = Configuration.load

}

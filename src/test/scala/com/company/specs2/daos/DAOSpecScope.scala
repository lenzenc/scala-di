package com.company.specs2.daos

import com.company.config.database.H2DBProfile
import com.company.context.TablesModule
import com.company.specs2.SpecScope

import scala.slick.driver.{H2Driver, JdbcProfile}

trait DAOSpecScope extends SpecScope with TablesModule with H2DBProfile {

}

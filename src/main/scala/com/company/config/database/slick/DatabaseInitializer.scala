package com.company.config.database.slick

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.context.Tables

trait DatabaseInitializer extends Tables with DatabaseProfile { self: DatabaseFactory =>
  import profile.simple._

  def initDB() = {
    database().withSession { implicit session =>
      dropDB
      createDB
      seedDB
    }
  }

  protected def createDB()(implicit s: Session) = {
    tables.create
  }

  protected def dropDB()(implicit s: Session) = {
    try { tables.drop } catch { case _: Exception => true }
  }

  protected def seedDB()(implicit s: Session) = {}

}

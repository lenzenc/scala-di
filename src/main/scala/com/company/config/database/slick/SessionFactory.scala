package com.company.config.database.slick

import com.company.config.database.slick.profile.DatabaseProfile

trait SessionFactory { self: DatabaseProfile =>
  import profile.simple._

  protected val defaultDBName = "default"

  def createSession(databaseName: String = defaultDBName): Session = database(databaseName).createSession

  def inSession[T](f: Session => T, databaseName: String = defaultDBName): T = {
    val s = createSession(databaseName)
    database(databaseName).withTransaction { implicit session =>
      f(s)
    }
  }

  def inTransaction[T](f: Session => T, databaseName: String = defaultDBName): T = {
    val s = createSession(databaseName)
    database(databaseName).withSession { implicit session =>
      f(s)
    }
  }

  protected def database(databaseName:String): Database

}

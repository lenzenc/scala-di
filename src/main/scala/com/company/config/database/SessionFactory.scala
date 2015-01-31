package com.company.config.database

trait SessionFactory { this: DBProfile =>
  import profile.simple._

  val defaultDBName = "default"

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

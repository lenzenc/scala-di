package com.company.specs2

import com.company.config.database.{DBProfile, SessionFactory}
import org.specs2.mock.Mockito

import scala.slick.driver.JdbcProfile

class MockedSessionFactory(implicit val profile: JdbcProfile) extends SessionFactory with Mockito {
  import profile.simple._

  protected lazy val db = mock[Database]
  protected lazy val mockSession = mock[Session]

  override def createSession(dbName: String): Session = mockSession

  override def inSession[T](f: Session => T, databaseName: String = defaultDBName): T = {
   f(mockSession)
  }

  override def inTransaction[T](f: Session => T, databaseName: String = defaultDBName): T = {
    f(mockSession)
  }

  protected def database(databaseName:String): Database = db

}

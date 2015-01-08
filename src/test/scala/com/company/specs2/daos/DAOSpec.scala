package com.company.specs2.daos

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.context.Tables
import com.company.specs2.SpecSessionFactory
import org.specs2.execute.{AsResult, Result}
import org.specs2.mock.Mockito
import org.specs2.mutable.{Before, Specification}
import org.specs2.specification.AroundExample

trait DAOSpec
  extends Specification
  with Tables
  with Mockito
  with SpecSessionFactory
  with DatabaseProfile
  with Before
  with AroundExample
{
  sequential
  import profile.simple._

  protected implicit lazy val session = createSession()

  def before = {
    try { tables.drop } catch { case _: Exception => true }
    tables.create
  }

  def around[T : AsResult](t: => T): Result = {
    session.withTransaction { try  AsResult(t) finally session.rollback }
  }

}

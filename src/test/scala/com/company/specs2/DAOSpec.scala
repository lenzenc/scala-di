package com.company.specs2

import com.company.context.Tables
import com.company.daos.SpecDatabaseFactory
import org.specs2.execute.{Result, AsResult}
import org.specs2.mock.Mockito
import org.specs2.mutable.{Before, Specification}
import org.specs2.specification.AroundExample

trait DAOSpec
  extends Specification
  with Tables
  with Mockito
  with SpecDatabaseFactory
  with Before
  with AroundExample
{
  sequential
  import profile.simple._

  protected implicit lazy val session = database(defaultDBName).createSession

  def before = {
    try { tables.drop } catch { case _: Exception => true }
    tables.create
  }

  def around[T : AsResult](t: => T): Result = {
    session.withTransaction { try  AsResult(t) finally session.rollback }
  }

}

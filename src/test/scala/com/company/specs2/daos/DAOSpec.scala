package com.company.specs2.daos

import com.company.config.database.H2DB
import com.company.context.TablesModule
import org.specs2.execute.{AsResult, Result}
import org.specs2.mock.Mockito
import org.specs2.mutable.{Before, Specification}
import org.specs2.specification.AroundExample

trait DAOSpec
  extends Specification
  with TablesModule
  with Mockito
  with Before
  with AroundExample
  with H2DB
{
  sequential

  protected implicit lazy val session = sessionFactory.createSession()

  def before = {
    dropTables
    createTables
  }

  def around[T : AsResult](t: => T): Result = {
    session.withTransaction { try  AsResult(t) finally session.rollback }
  }

}

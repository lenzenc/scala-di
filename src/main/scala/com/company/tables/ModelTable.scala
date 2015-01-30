package com.company.tables

import com.company.config.database.DBProfile
import com.company.tables.ext.TableSupport

trait ModelTable extends TableSupport { this: DBProfile =>
  import profile.simple._

  def query: TableQuery[_ <: AbstractModelTable[_]]

  def create(implicit session: Session) = query.ddl.create

  def drop(implicit session: Session) = query.ddl.drop

}

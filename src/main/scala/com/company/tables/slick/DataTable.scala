package com.company.tables.slick

import com.company.config.database.slick.DBProfile

trait DataTable extends DBProfile {
  import profile.simple._

  def table: TableQuery[_ <: Table[_]]

  def create()(implicit s: Session) = table.ddl.create

  def drop()(implicit s: Session) = table.ddl.drop

}

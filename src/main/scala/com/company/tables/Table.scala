package com.company.tables

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.tables.slick.TableSupport

trait Table extends DatabaseProfile with TableSupport {
  import profile.simple._

  def query: TableQuery

}

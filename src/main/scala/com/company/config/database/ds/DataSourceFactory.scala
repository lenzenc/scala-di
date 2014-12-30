package com.company.config.database.ds

import javax.sql.DataSource

trait DataSourceFactory {

  def get(name: String): DataSource

}

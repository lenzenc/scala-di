package com.company.config.database.ds

import javax.sql.DataSource

import com.company.config.Configuration

abstract class ConfigDataSourceFactory(config: Configuration) extends DataSourceFactory {

  protected val dbConfig = config.getConfig("db").getOrElse(Configuration.empty)
  protected val dbs: Set[String] = dbConfig.subKeys
  protected val dataSources: Map[String, DataSource] = dbs.map { dbName => (dbName, create(dbName)) }.toMap

  def get(name: String): DataSource = {
    dataSources get name match {
      case Some(value) => value
      case None => throw new RuntimeException(s"Unable to find DataSource for database config $name")
    }
  }

  protected def create(name: String): DataSource

  protected def error(name: String, message: String) = throw new RuntimeException(s"DataSource: $name - $message")

}

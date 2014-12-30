package com.company.config.database.slick

import com.company.config.Configuration
import com.company.config.database.ds.{BoneCPDataSourceFactory, DataSourceFactory}

trait ConfigDatabaseFactory extends DatabaseFactory {
  import profile.simple._

  protected def configuration: Configuration = Configuration.load
  protected val dataSourceFactory: DataSourceFactory = new BoneCPDataSourceFactory(configuration)
  private lazy val dbConfig = configuration.getConfig("db").getOrElse(Configuration.empty)
  protected val dbs: Set[String] = dbConfig.subKeys
  protected val databases: Map[String, Database] = dbs.map { dbName => (dbName, create(dbName)) }.toMap

  def database(databaseName:String = defaultDBName): Database = {
    databases get databaseName match {
      case Some(value) => value
      case None => throw new RuntimeException(s"No matching Database found for: $databaseName")
    }

  }

  protected def create(dbName: String): Database = {
    Database.forDataSource(dataSourceFactory.get(dbName))
  }

}
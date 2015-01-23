package com.company.config.database.slick

import com.company.config.Configuration
import com.company.config.database.ds.{BoneCPDataSourceFactory, DataSourceFactory}
import com.company.config.database.slick.profile.DatabaseProfile

trait ConfigSessionFactory extends SessionFactory { self: DatabaseProfile =>
  import profile.simple._

  protected def configuration: Configuration = Configuration.load
  protected val dataSourceFactory: DataSourceFactory = new BoneCPDataSourceFactory(configuration)
  private lazy val dbConfig = configuration.getConfig("db").getOrElse(Configuration.empty)
  protected val dbs: Set[String] = dbConfig.subKeys
  protected val databases: Map[String, Database] = dbs.map { dbName => (dbName, create(dbName)) }.toMap

  protected def create(dbName: String): Database = {
    Database.forDataSource(dataSourceFactory.get(dbName))
  }

  protected def database(databaseName:String = defaultDBName): Database = databases get databaseName match {
    case Some(value) => value
    case None => throw new RuntimeException(s"No matching Database found for: $databaseName")
  }

}
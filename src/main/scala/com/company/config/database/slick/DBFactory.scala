package com.company.config.database.slick

trait DBFactory extends DBProfile {

  val defaultDBName = "default"

  def database(databaseName:String = defaultDBName): profile.simple.Database

}

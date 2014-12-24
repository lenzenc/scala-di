package com.company

import com.company.config.database.slick.{DBSupport, DBProfile, DBFactory}
import com.company.daos.impl.CustomerDAOImpl
import com.company.models.Customer
import com.company.services.Services
import com.company.services.impl.CustomerServiceImpl
import com.company.tables.slick.{Tables, CustomerTable}

import scala.slick.driver.{JdbcProfile, H2Driver}

object Server extends App {

  println("Running this experiment application...")
  val application = new Application

  val db = application.dbFactory.database()

  import application.profile.simple._

  db.withSession { implicit session =>
    application.create()
    application.customers.table ++= Seq(
      Customer("Customer A"),
      Customer("Customer B"),
      Customer("Customer C")
    )
  }

  println(application.customerService.list)

}

class Application extends Services with H2DBProfile {

  def dbFactory: DBFactory = new DBFactory with H2DBProfile {
    import profile.simple._

    override def database(databaseName: String): Database = Database.forURL(
      "jdbc:h2:mem:test1;DB_CLOSE_DELAY=-1",
      driver = "org.h2.Driver")

  }

}

trait H2DBProfile extends DBProfile {
  def driver = H2Driver
}
/*
  configuration
  createSchema
  dropSchema
  services?
 */
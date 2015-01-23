package com.company

import com.company.config.database.slick.ConfigSessionFactory
import com.company.config.database.slick.profile.H2DatabaseProfile
import com.company.http.HttpBoot
import com.company.models.{User, Customer}
import spray.routing.Route

object Server extends App with HttpBoot {
  
  // TODO: Add reusable ID table logic
  // TODO: Add reusable create/update date table logic
  // TODO: Add reusable ID, create/update date to model classes
  // TODO: Create traits with implemented CRUD operations
  // TODO: Create reusable insert that copied auto-generated identify back into inserted model
  // TODO: Make sure all needed classes/traits can be re-used and extended in other projects
  // TODO: Add better error handling for the user case where a model is not found for a given identifier
  // TODO: Add support for https://github.com/brettwooldridge/HikariCP DataSources

  lazy val app = new Application with ConfigSessionFactory with H2DatabaseProfile {

    implicit lazy val sessionFactory: SessionFactory =

    import profile.simple._

    val customersAutoInc = customersTable returning customersTable.map(_.id) into {
      case (c, id) => c.copy(id = Some(id))
    }

    val usersAutoInc = usersTable returning usersTable.map(_.id) into {
      case (u, id) => u.copy(id = Some(id))
    }

    def initDB = {

      inSession { implicit session =>

        tables.create

        val customer1 = customersAutoInc.insert(Customer("Customer One"))
        val customer2 = customersAutoInc.insert(Customer("Customer Two"))
        val customer3 = customersAutoInc.insert(Customer("Customer Three"))

        val user1 = usersAutoInc.insert(User("John", "Smith", customer1.id.get))
        val user2 = usersAutoInc.insert(User("Bob", "Smith", customer1.id.get))
        val user3 = usersAutoInc.insert(User("Joe", "Blow", customer2.id.get))
        val user4 = usersAutoInc.insert(User("Steve", "Martin", customer3.id.get))

      }

    }

  }

  protected lazy val routes: Route = app.apisRoutes

  app.initDB

}
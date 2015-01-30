package com.company

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
  // TODO: protected val dataSourceFactory: DataSourceFactory = new BoneCPDataSourceFactory(configuration) in ConfigSessionFactory should be a mixin

  lazy val app = new Application {

    import profile.simple._
    import sessionFactory._

//    val customersAutoInc = customersTable returning customersTable.map(_.id) into {
//      case (c, id) => c.copy(id = Some(id))
//    }
//
//    val usersAutoInc = usersTable returning usersTable.map(_.id) into {
//      case (u, id) => u.copy(id = Some(id))
//    }

    def initDB = {

      inSession { implicit session =>

        createTables

        val customer1 = customersTable.query.insert(Customer("Customer One", Some(1)))
        val customer2 = customersTable.query.insert(Customer("Customer Two", Some(2)))
        val customer3 = customersTable.query.insert(Customer("Customer Three", Some(3)))

        val user1 = usersTable.query.insert(User("John", "Smith", 1, Some(1)))
        val user2 = usersTable.query.insert(User("Bob", "Smith", 1, Some(2)))
        val user3 = usersTable.query.insert(User("Joe", "Blow", 2, Some(3)))
        val user4 = usersTable.query.insert(User("Steve", "Martin", 3, Some(4)))

      }

    }

  }

  protected lazy val routes: Route = app.apisRoutes

  app.initDB

}
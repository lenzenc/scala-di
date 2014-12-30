package com.company.config.database.slick

import com.company.models.{User, Customer}

trait SeededDatabaseInitializer extends DatabaseInitializer with DatabaseFactory {
  import profile.simple._

  val customersAutoInc = customers returning customers.map(_.id) into {
    case (c, id) => c.copy(id = id)
  }

  val usersAutoInc = users returning users.map(_.id) into {
    case (u, id) => u.copy(id = id)
  }

  protected override def seedDB()(implicit s: Session) = {
    super.seedDB()

    val customer1 = customersAutoInc.insert(Customer("Customer One"))
    val customer2 = customersAutoInc.insert(Customer("Customer Two"))
    val customer3 = customersAutoInc.insert(Customer("Customer Three"))

    val user1 = usersAutoInc.insert(User("John", "Smith", customer1.id.get))
    val user2 = usersAutoInc.insert(User("Bob", "Smith", customer1.id.get))
    val user3 = usersAutoInc.insert(User("Joe", "Blow", customer2.id.get))
    val user4 = usersAutoInc.insert(User("Steve", "Martin", customer3.id.get))

  }

  initDB()

}

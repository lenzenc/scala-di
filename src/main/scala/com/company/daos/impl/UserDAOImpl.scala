package com.company.daos.impl

import com.company.daos.UserDAO
import com.company.models.User

import scala.slick.driver.JdbcProfile

class UserDAOImpl(implicit val driver: JdbcProfile) extends UserDAO {
  import profile.simple._

  def usersTable = TableQuery[Users]

//  class Users(tag: Tag) extends ModelTable[User](tag, "users") {
//    val firstName = column[String]("first_name", O.NotNull, O.Length(255, varying = true))
//    val lastName = column[String]("last_name", O.NotNull, O.Length(255, varying = true))
//    val customerID = column[Long]("customer_id", O.NotNull)
//    def * = (firstName, lastName, customerID, id.?) <> (User.tupled, User.unapply _)
//    def customerFK = foreignKey("USER_CUSTOMER_FK", customerID, customersTable)(
//      r => r.id,
//      onUpdate = ForeignKeyAction.NoAction,
//      onDelete = ForeignKeyAction.NoAction
//    )
//  }

}

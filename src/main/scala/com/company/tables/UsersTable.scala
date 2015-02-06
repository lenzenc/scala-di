package com.company.tables

import com.company.models.User

import scala.slick.driver.JdbcProfile

class UsersTable(val customersTable: CustomersTable)(implicit val profile: JdbcProfile) extends ModelTable {
  import profile.simple._

  class Users(tag: Tag) extends AbstractModelTable[User](tag, "users") {
    val firstName = column[String]("first_name", O.NotNull, O.Length(255, varying = true))
    val lastName = column[String]("last_name", O.NotNull, O.Length(255, varying = true))
    val customerID = column[Long]("customer_id", O.NotNull)
    def * = (firstName, lastName, customerID, id.?) <> (User.tupled, User.unapply _)
    def customerFK = foreignKey("USER_CUSTOMER_FK", customerID, customersTable.query)(
      r => r.id,
      onUpdate = ForeignKeyAction.NoAction,
      onDelete = ForeignKeyAction.NoAction
    )
  }

  val query = TableQuery[Users]

}

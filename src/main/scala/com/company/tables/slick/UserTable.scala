package com.company.tables.slick

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.models.User

trait UserTable { self: CustomerTable with DatabaseProfile =>
  import profile.simple._

  def users = TableQuery[Users]

  class Users(tag: Tag) extends Table[User](tag, "users") {
    val id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    val firstName = column[String]("first_name", O.NotNull, O.Length(255, varying = true))
    val lastName = column[String]("last_name", O.NotNull, O.Length(255, varying = true))
    val customerID = column[Long]("customer_id", O.NotNull)
    def * = (firstName, lastName, customerID, id) <> (User.tupled, User.unapply _)
    def customerFK = foreignKey("USER_CUSTOMER_FK", customerID, customers)(
      r => r.id.get,
      onUpdate = ForeignKeyAction.NoAction,
      onDelete = ForeignKeyAction.NoAction
    )
  }

}

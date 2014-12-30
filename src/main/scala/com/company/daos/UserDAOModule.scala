package com.company.daos

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.models.User
import com.company.tables.slick.UserTable

trait UserDAOModule { self: UserTable with DatabaseProfile =>
  import profile.simple._

  def userDAO: UserDAO

  trait UserDAO {

    def findAllByCustomerID(customerID: Long)(implicit s: Session): Seq[User]

    def findByPk(pk: Long)(implicit session: Session): Option[User]
  }

  class UserDAOImpl extends UserDAO {

    def findAllByCustomerID(customerID: Long)(implicit s: Session): Seq[User] = {
      users.filter(_.customerID === customerID).list
    }

    def findByPk(pk: Long)(implicit session: Session): Option[User] = users.filter(_.id === pk).firstOption

  }

}

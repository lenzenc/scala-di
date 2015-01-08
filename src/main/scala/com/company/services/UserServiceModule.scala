package com.company.services

import com.company.config.database.slick.DatabaseFactory
import com.company.daos.UserDAOModule
import com.company.models.User

trait UserServiceModule { self: UserDAOModule with DatabaseFactory =>

  def userService: UserService

  trait UserService {

    def list(customerID: Long): Seq[User]

    def get(pk: Long): Option[User]

  }

  class UserServiceImpl extends UserService {

    private lazy val db = database()

    def list(customerID: Long): Seq[User] = {
      db.withSession { implicit session =>
        userDAO.findAllByCustomerID(customerID)
      }
    }

    def get(pk: Long): Option[User] = db.withSession { implicit session =>
      userDAO.findByPK(pk)
    }

  }

}

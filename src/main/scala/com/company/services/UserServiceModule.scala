package com.company.services

import com.company.config.database.slick.SessionFactory
import com.company.daos.UserDAOModule
import com.company.models.User

trait UserServiceModule { self: UserDAOModule with SessionFactory =>

  def userService: UserService

  trait UserService {

    def list(customerID: Long): List[User]

    def get(pk: Long): Option[User]

  }

  class UserServiceImpl extends UserService {

    def list(customerID: Long): List[User] = inSession { implicit session => userDAO.findAllByCustomerID(customerID) }

    def get(pk: Long): Option[User] = inSession { implicit session => userDAO.findByPK(pk) }

  }

}

package com.company.services.impl

import com.company.config.database.{DB, SessionFactory}
import com.company.daos.UserDAO
import com.company.models.User
import com.company.services.UserService

class UserServiceImpl(val userDAO: UserDAO)(implicit val sessionFactory: SessionFactory) extends UserService {
  import sessionFactory._

  def list(customerID: Long): List[User] = inSession { implicit session => userDAO.findAllByCustomerID(customerID) }

  def get(pk: Long): Option[User] = inSession { implicit session => userDAO.findByPK(pk) }

}

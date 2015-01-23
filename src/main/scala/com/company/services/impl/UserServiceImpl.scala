package com.company.services.impl

import com.company.daos.UserDAO
import com.company.models.User
import com.company.services.{AbstractService, UserService}

class UserServiceImpl(implicit val userDAO: UserDAO) extends AbstractService with UserService {
  import sessionFactory._

  def list(customerID: Long): List[User] = inSession { implicit session => userDAO.findAllByCustomerID(customerID) }

  def get(pk: Long): Option[User] = inSession { implicit session => userDAO.findByPK(pk) }

}

package com.company.daos

import com.company.models.User

import scala.slick.jdbc.JdbcBackend

trait UserDAO { self: JdbcBackend =>

  def findAllByCustomerID(customerID: Long)(implicit s: Session): List[User]

  def findByPK(pk: Long)(implicit session: Session): Option[User]

}

package com.company.daos

import com.company.models.User

trait UserDAO extends DAO {
  import profile.simple._

  def findAllByCustomerID(customerID: Long)(implicit s: Session): List[User]

  def findByPK(pk: Long)(implicit session: Session): Option[User]

}

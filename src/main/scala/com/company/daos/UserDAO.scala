package com.company.daos

import com.company.config.database.DBProfile
import com.company.models.User

trait UserDAO extends DAO { this: DBProfile =>
  import profile.simple._

  def findAllByCustomerID(customerID: Long)(implicit s: Session): List[User]

  def findByPK(pk: Long)(implicit session: Session): Option[User]

}

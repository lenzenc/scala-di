package com.company.daos.impl

import com.company.config.database.DBProfile
import com.company.daos.UserDAO
import com.company.models.User
import com.company.tables.UsersTable

import scala.slick.driver.JdbcProfile

class UserDAOImpl(
  val usersTable: UsersTable,
  val driver: JdbcProfile)
  extends UserDAO with DBProfile
{
  import profile.simple._

  def findAllByCustomerID(customerID: Long)(implicit s: Session): List[User] = {
    usersTable.query.filter(_.customerID === customerID).list
  }

  def findByPK(pk: Long)(implicit session: Session): Option[User] = usersTable.query.filter(_.id === pk).firstOption

}

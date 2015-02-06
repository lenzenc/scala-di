package com.company.services

import com.company.config.database.DB
import com.company.models.User

trait UserService extends DB {

  def list(customerID: Long): List[User]

  def get(pk: Long): Option[User]

}

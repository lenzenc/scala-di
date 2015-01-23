package com.company.services

import com.company.models.User

trait UserService extends Service {

  def list(customerID: Long): List[User]

  def get(pk: Long): Option[User]

}

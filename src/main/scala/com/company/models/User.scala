package com.company.models

import com.company.models.ModelSupport._

case class User(
  firstName: String,
  lastName: String,
  customerID: Long,
  id: Option[Long] = None
 ) extends Model[User]

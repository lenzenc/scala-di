package com.company.services

import com.company.config.database.DB
import com.company.models.Customer

trait CustomerService { this: DB =>

  def list: List[Customer]

  def get(pk: Long): Option[Customer]

}

package com.company.services

import com.company.models.Customer

trait CustomerService extends Service {

  def list: List[Customer]

  def get(pk: Long): Option[Customer]

}

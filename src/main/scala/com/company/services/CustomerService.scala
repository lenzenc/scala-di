package com.company.services

import com.company.models.Customer

trait CustomerService {

  def list(): Seq[Customer]

}

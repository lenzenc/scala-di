package com.company.models

import com.company.models.ModelSupport._

case class Customer(name: String, id: Option[Long] = None) extends Model[Customer]

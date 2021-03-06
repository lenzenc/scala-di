package com.company.http

import com.company.models.{User, Customer}
import spray.httpx.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait JsonImplicits extends DefaultJsonProtocol with SprayJsonSupport {

  implicit val formatCustomer = jsonFormat2(Customer)
  implicit val formatUser = jsonFormat4(User)

}

package com.company.http.apis

import com.company.http.JsonImplicits
import com.company.services.CustomerService
import spray.routing._

class CustomerAPI(val customerService: CustomerService) extends Directives with JsonImplicits {

  val routes: Route = {
    get {
      path("customers") {
        complete {
          customerService.list
        }
      } ~
        path("customers" / LongNumber) { pk =>
          complete {
            customerService.get(pk).getOrElse(sys.error(s"Unable to find customer with pk: $pk"))
          }
        }
    }
  }

}

package com.company.http.apis

import com.company.http.JsonImplicits
import com.company.services.CustomerServiceModule
import spray.routing.{Route, Directives}

trait CustomerAPIModule { self: CustomerServiceModule =>

  object CustomerAPI extends Directives with JsonImplicits {

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

}

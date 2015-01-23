package com.company.http.apis

import com.company.http.JsonImplicits
import com.company.services.UserService
import spray.routing._

class UserAPI(implicit val userService: UserService) extends Directives with JsonImplicits {

  val routes: Route = {
    get {
      path("users") {
        parameters('customerID.as[Long]) { customerID =>
          complete {
            userService.list(customerID)
          }
        }
      } ~
        path("users" / LongNumber) { pk =>
          complete {
            userService.get(pk).getOrElse(sys.error(s"Unable to find user with pk: $pk"))
          }
        }
    }
  }

}

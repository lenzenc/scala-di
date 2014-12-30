package com.company.context

import com.company.http.apis.{CustomerAPIModule, UserAPIModule}
import spray.routing.{Route, RouteConcatenation}

trait APIs extends CustomerAPIModule with UserAPIModule with Services with RouteConcatenation {

  lazy val apisRoutes: Route = CustomerAPI.routes ~ UserAPI.routes

}

package com.company.context

import com.company.http.apis.{CustomerAPIModule, UserAPIModule}
import spray.routing.{Route, RouteConcatenation}

trait APIsModule extends CustomerAPIModule with UserAPIModule with ServicesModules with RouteConcatenation {

  lazy val apisRoutes: Route = CustomerAPI.routes ~ UserAPI.routes

}

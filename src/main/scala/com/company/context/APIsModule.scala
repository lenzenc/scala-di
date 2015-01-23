package com.company.context

import com.company.http.apis.{UserAPI, CustomerAPI}
import spray.routing.{Route, RouteConcatenation}

trait APIsModule extends ServicesModules with RouteConcatenation {

  protected lazy val customerAPI = new CustomerAPI
  protected lazy val userAPI = new UserAPI

  lazy val apisRoutes: Route = customerAPI.routes ~ userAPI.routes

}

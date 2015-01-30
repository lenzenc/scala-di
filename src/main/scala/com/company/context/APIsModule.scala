package com.company.context

import com.company.config.database.{DBProfile, DB}
import com.company.http.apis.{UserAPI, CustomerAPI}
import spray.routing.{Route, RouteConcatenation}

trait APIsModule extends ServicesModules with RouteConcatenation { this: DB with DBProfile =>

  protected lazy val customerAPI = new CustomerAPI
  protected lazy val userAPI = new UserAPI

  lazy val apisRoutes: Route = customerAPI.routes ~ userAPI.routes

}

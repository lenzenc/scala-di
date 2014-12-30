package com.company

import com.company.http.HttpBoot
import spray.routing.Route

object Server extends App with HttpBoot with Application {

  protected lazy val routes: Route = apisRoutes

}
package com.company.http

import akka.actor.{ActorLogging, Actor}
import spray.routing._

class HttpRouter(route: Route) extends Actor with HttpService with ActorLogging {

  implicit def actorRefFactory = context

  def receive: Receive = {
    runRoute(route)
  }

}

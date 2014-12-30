package com.company.http

import akka.actor.{Props, ActorRefFactory, ActorSystem}
import akka.io.IO
import spray.can.Http
import spray.routing.Route

trait HttpBoot {

  protected def routes: Route
  protected val host: String = "0.0.0.0"
  protected val port: Int = 8080

  implicit lazy val system = ActorSystem("default-dispatcher")
  lazy val actorRefFactory: ActorRefFactory = system

  val router = system.actorOf(Props(new HttpRouter(routes)))

  IO(Http)(system) ! Http.Bind(router, host, port = port)
  sys.addShutdownHook(system.shutdown())

}

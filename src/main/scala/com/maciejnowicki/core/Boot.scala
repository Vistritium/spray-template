package com.maciejnowicki.core


import akka.actor.{ActorSystem, Props}
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import com.typesafe.scalalogging.StrictLogging
import spray.can.Http

object Boot extends App with StrictLogging{

  implicit val system = ActorSystem("app")

  val service = system.actorOf(Props[AppControllers], "mainService")

  implicit val timeout = Timeout(5 seconds)

  logger.info("binding to " + Config.port)
  IO(Http) ? Http.Bind(service, interface = "0.0.0.0", port = Config.port)

}

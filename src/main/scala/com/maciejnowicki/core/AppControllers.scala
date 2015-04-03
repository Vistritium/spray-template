package com.maciejnowicki.core

import akka.actor.Actor
import akka.actor.Actor.Receive

class AppControllers extends Actor with ResourcesController{
  def actorRefFactory = context

  override def receive: Receive = runRoute(resourceRoute)
}

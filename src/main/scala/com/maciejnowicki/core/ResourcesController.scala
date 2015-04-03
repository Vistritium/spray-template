package com.maciejnowicki.core

import com.typesafe.scalalogging.StrictLogging
import spray.routing.HttpService

trait ResourcesController extends HttpService with StrictLogging {

  val resourceRoute =
    pathPrefix("res") {
      get {
        unmatchedPath {
          remaining => {
            getFromResource("public/" + remaining)
          }
        }
      }
    } ~ path("") {
      get {
        getFromResource("public/views/main.html")
      }
    }

}

package com.maciejnowicki.core

import com.typesafe.config.{ConfigException, ConfigFactory}
import com.typesafe.scalalogging.StrictLogging

object Config extends StrictLogging{

   val config = ConfigFactory.load()

   val port = config.getInt("app.port")

 }

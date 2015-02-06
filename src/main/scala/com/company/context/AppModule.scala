package com.company.context

import com.company.config.database.{DBProfile, DB}

trait AppModule extends APIsModule with ServicesModules { this: DB =>

}

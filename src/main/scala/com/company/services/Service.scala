package com.company.services

import com.company.config.database.slick.SessionFactory

trait Service {

  protected def sessionFactory: SessionFactory

}

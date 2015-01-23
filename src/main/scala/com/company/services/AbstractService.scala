package com.company.services

import com.company.config.database.slick.SessionFactory

abstract class AbstractService(implicit val sessionFactory: SessionFactory) extends Service {


}

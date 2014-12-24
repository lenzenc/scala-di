package com.company.daos

import com.company.daos.slick.DAO
import com.company.models.Customer

trait CustomerDAO extends DAO {
  import profile.simple._

  def findAll()(implicit s: Session): Seq[Customer]

}

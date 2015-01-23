package com.company.daos

import com.company.SortOrder
import com.company.SortOrder._
import com.company.models.Customer

trait CustomerDAO extends DAO{
  import profile.simple._

  def findAll(sortOrder: SortOrder = SortOrder.ASC)(implicit s: Session): List[Customer]

  def findByPK(pk: Long)(implicit s: Session): Option[Customer]

}

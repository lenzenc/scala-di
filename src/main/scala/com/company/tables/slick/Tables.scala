package com.company.tables.slick

import com.company.config.database.slick.DBProfile

trait Tables extends DBProfile {
  import profile.simple._

  lazy val customers = new CustomerTable(driver)

  def create()(implicit s: Session) = all.map(_.create)

  def drop()(implicit s: Session) = all.map(_.drop)

  private def all = Seq(
    customers
  )

}

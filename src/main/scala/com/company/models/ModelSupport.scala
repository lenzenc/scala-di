package com.company.models

trait ModelSupport {

  trait Identifiable[ID <: Identifiable[ID]] {

    type IdType

    def id: Option[ID#IdType]

  }

  abstract class AbstractModel[M <: Identifiable[M], ID] extends Identifiable[M] {
    type IdType = ID
  }

  type Model[M <: Identifiable[M]] = AbstractModel[M, Long]

}

object ModelSupport extends ModelSupport

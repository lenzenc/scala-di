package com.company.tables.ext

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.models.ModelSupport._

trait TableSupport { self: DatabaseProfile =>
  import profile.simple._

  trait IDColumn[ID] { self: Table[_] =>

    def idColumnName = "id"
    def idColumnOptions = List(O.PrimaryKey, O.AutoInc, O.NotNull)

    def id: Column[ID]

  }

  abstract class ModelTable[M <: Identifiable[M]](
    tag: Tag,
    schemaName: Option[String],
    tableName: String)(implicit val idColType: BaseColumnType[M#IdType])
    extends Table[M](tag, schemaName, tableName)
    with IDColumn[M#IdType]
  {

    def this(tag: Tag, tableName: String)(implicit mapping: BaseColumnType[M#IdType]) = this(tag, None, tableName)

    def id = column[M#IdType](idColumnName, idColumnOptions : _*)

  }

}
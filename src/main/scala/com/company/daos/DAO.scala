package com.company.daos

import com.company.config.database.slick.profile.DatabaseProfile
import com.company.tables.slick.TableSupport

trait DAO extends DatabaseProfile with TableSupport {

}

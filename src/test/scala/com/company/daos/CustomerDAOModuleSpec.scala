package com.company.daos

import com.company.SortOrder
import com.company.models.Customer
import com.company.specs2.daos.{DAOSpec, DAOSpecScope}

class CustomerDAOModuleSpec extends DAOSpec {
  import profile.simple._

  trait MainScope extends DAOSpecScope with CustomerDAOModule {

    val customerDAO = new CustomerDAOImpl

  }

  trait UnOrderedCustomers {
    customersTable ++= Seq(
      Customer("Customer B"),
      Customer("Customer A"),
      Customer("Customer C")
    )
  }

  ".findAll" should {

    "by default return a list of ASC ordered customers" in new MainScope with UnOrderedCustomers {
      val customers = customerDAO.findAll()
      customers must not(beNull)
      customers.size must_== 3
      customers.map(_.name) must contain(exactly("Customer A", "Customer B", "Customer C").inOrder)
    }
    "allow to be ordered by ascending order" in new MainScope with UnOrderedCustomers {
      val customers = customerDAO.findAll(SortOrder.ASC)
      customers must not(beNull)
      customers.size must_== 3
      customers.map(_.name) must contain(exactly("Customer A", "Customer B", "Customer C").inOrder)
    }
    "allow to be ordered by descending order" in new MainScope with UnOrderedCustomers {
      val customers = customerDAO.findAll(SortOrder.DESC)
      customers must not(beNull)
      customers.size must_== 3
      customers.map(_.name) must contain(exactly("Customer C", "Customer B", "Customer A").inOrder)
    }

  }

  ".findByPK" should {

    "return an Option containing the expected customer for the given PK" in new MainScope {

      val customerA = Customer("Customer A", Some(1))
      customersTable.forceInsert(customerA)

      val customer = customerDAO.findByPK(customerA.id.get)
      customer must not(beNull)
      customer must beSome[Customer]
      customer.get.name must_== customerA.name

    }
    "return on Option of None if no customer is found for a given PK" in new MainScope {

      val customer = customerDAO.findByPK(-1)
      customer must not(beNull)
      customer must beNone

    }

  }

}

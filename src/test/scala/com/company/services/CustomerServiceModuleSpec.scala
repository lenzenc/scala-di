package com.company.services

import com.company.SortOrder
import com.company.context.TablesModule
import com.company.daos.CustomerDAOModule
import com.company.models.Customer
import com.company.specs2.services.{ServiceSpecScope, ServiceSpec}

class CustomerServiceModuleSpec extends ServiceSpec {

  trait MainScope extends ServiceSpecScope with CustomerServiceModule with CustomerDAOModule with TablesModule {

    val customerDAO: CustomerDAO = mock[CustomerDAO]
    val customerService = new CustomerServiceImpl

  }

  ".list" should {

    "return a list of expected customers" in new MainScope {
      val customerList = List(Customer("Customer A", Some(1)))
      customerDAO.findAll(SortOrder.ASC) returns customerList
      val customers = customerService.list
      there was one(customerDAO).findAll(SortOrder.ASC)
      customers must containTheSameElementsAs(customerList)
    }

  }

  ".get(pk: Long)" should {

    "return a Customer for a given customerID" in new MainScope {
      val expectedCustomer = Customer("Customer A", Some(1))
      customerDAO.findByPK(1) returns Some(expectedCustomer)
      val customer = customerService.get(1)
      there was one(customerDAO).findByPK(1)
      customer.get must_== expectedCustomer
    }

    "return None if no Customer exists for a given customerID" in new MainScope {
      customerDAO.findByPK(1) returns None
      val customer = customerService.get(1)
      there was one(customerDAO).findByPK(1)
      customer must beNone
    }

  }

}

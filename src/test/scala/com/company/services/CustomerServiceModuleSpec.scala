package com.company.services

import com.company.SortOrder
import com.company.context.Tables
import com.company.daos.CustomerDAOModule
import com.company.models.Customer
import com.company.specs2.{ServiceSpecScope, ServiceSpec}

class CustomerServiceModuleSpec extends ServiceSpec {

  trait MainScope extends ServiceSpecScope with CustomerServiceModule with CustomerDAOModule with Tables {

    val customerDAO: CustomerDAO = mock[CustomerDAO]
    val customerService = new CustomerServiceImpl

  }

  ".list" should {

    "return a list of expected customers" in new MainScope {
      val customerList = Seq(Customer("Customer A", Some(1)))
      customerDAO.findAll(SortOrder.ASC) returns customerList
      val customers = customerService.list
      there was one(customerDAO).findAll(SortOrder.ASC)
      customers must containTheSameElementsAs(customerList)
    }

  }

}
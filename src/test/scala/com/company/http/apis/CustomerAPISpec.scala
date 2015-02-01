package com.company.http.apis

import com.company.models.Customer
import com.company.services.CustomerService
import com.company.specs2.http.apis.{APISpecScope, APISpec}
import spray.http.StatusCodes._

class CustomerAPISpec extends APISpec {

  trait MainScope extends APISpecScope {

    val customerService = mock[CustomerService]
    val api = new CustomerAPI(customerService)

  }

  "GET: /customers" should {

    "return a list of customers" in new MainScope {
      val customers = List(Customer("Customer A", Some(1)))
      customerService.list returns customers

      Get("/customers") ~> api.routes ~> check {
        there was one(customerService).list
        status must_== OK
        responseAs[List[Customer]] must_== customers
      }
    }

  }

  "GET: /customers/ID" should {

    "return a Customer for a customer pk" in new MainScope {
      val customer = Customer("Customer A", Some(1))
      customerService.get(1) returns Some(customer)

      Get("/customers/1") ~> api.routes ~> check {
        there was one(customerService).get(1)
        status must_== OK
        responseAs[Customer] must_== customer
      }
    }

    "return a 500 error if no customer exists for a given pk" in new MainScope {
      customerService.get(1) returns None

      Get("/customers/1") ~> api.routes ~> check {
        there was one(customerService).get(1)
        status must_== InternalServerError
      }
    }

  }

}

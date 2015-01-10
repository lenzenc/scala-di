package com.company.http.apis

import com.company.context.DAOsModule
import com.company.models.{Customer, User}
import com.company.services.UserServiceModule
import com.company.specs2.http.apis.{APISpecScope, APISpec}
import spray.http.StatusCodes._

class UserAPIModuleSpec extends APISpec {

  trait MainScope extends APISpecScope with UserAPIModule with UserServiceModule with DAOsModule {

    val userService = mock[UserService]

  }

  "GET: /users?customerID=ID" should {

    "return a list of Users for a given customer pk" in new MainScope {
      val customer = Customer("Customer A", Some(1))
      val users = List(User("Bob", "Smith", customer.id.get, Some(5)))
      userService.list(customer.id.get) returns users

      Get("/users?customerID=" + customer.id.get) ~> UserAPI.routes ~> check {
        there was one(userService).list(customer.id.get)
        status must_== OK
        responseAs[List[User]] must_== users
      }
    }

    "return an empty list of Users if no Users exists for a given customer pk" in new MainScope {
      val users = List()
      userService.list(1) returns users

      Get("/users?customerID=1") ~> UserAPI.routes ~> check {
        there was one(userService).list(1)
        status must_== OK
        responseAs[List[User]] must beEmpty
      }
    }

  }

  "GET: /users/ID" should {

    "return a User for a user pk" in new MainScope {
      val customer = Customer("Customer A", Some(1))
      val user = User("Bob", "Smith", customer.id.get, Some(5))
      userService.get(user.id.get) returns Some(user)

      Get("/users/" + user.id.get) ~> UserAPI.routes ~> check {
        there was one(userService).get(user.id.get)
        status must_== OK
        responseAs[User] must_== user
      }
    }

    "return a 500 error if no user exists for a given pk" in new MainScope {
      userService.get(1) returns None

      Get("/users/1") ~> UserAPI.routes ~> check {
        there was one(userService).get(1)
        status must_== InternalServerError
      }
    }

  }

}
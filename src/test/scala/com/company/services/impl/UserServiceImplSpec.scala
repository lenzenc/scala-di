package com.company.services.impl

import com.company.daos.UserDAO
import com.company.models.User
import com.company.specs2.services.{ServiceSpec, ServiceSpecScope}

class UserServiceImplSpec extends ServiceSpec {

  trait MainScope extends ServiceSpecScope {

    val userDAO = mock[UserDAO]
    val userService = new UserServiceImpl(userDAO)

  }

  ".list(customerID: Long)" should {

    "return a list of expected Users for a given customerID" in new MainScope {
      val userList = List(User("Bob", "Smith", 1, Some(1)))
      userDAO.findAllByCustomerID(1) returns userList
      val users = userService.list(1)
      there was one(userDAO).findAllByCustomerID(1)
      userList must containTheSameElementsAs(userList)
    }

    "return an empty list of Users if there are no Users for a given customerID" in new MainScope {
      val userList = List()
      userDAO.findAllByCustomerID(1) returns userList
      val users = userService.list(1)
      there was one(userDAO).findAllByCustomerID(1)
      userList must beEmpty
    }

  }

  ".get(pk: Long)" should {

    "should return a User for a given userID" in new MainScope {
      val expectedUser = User("Bob", "Smith", 1, Some(1))
      userDAO.findByPK(1) returns Some(expectedUser)
      val user = userService.get(1)
      there was one(userDAO).findByPK(1)
      user.get must_== expectedUser
    }

    "should return None if no User exists for a given userID" in new MainScope {
      userDAO.findByPK(1) returns None
      val user = userService.get(1)
      there was one(userDAO).findByPK(1)
      user must beNone
    }

  }

}

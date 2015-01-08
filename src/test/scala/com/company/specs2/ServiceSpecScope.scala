package com.company.specs2

trait ServiceSpecScope extends SpecScope with MockedDatabaseFactory {
  import profile.simple._

  protected implicit lazy val session: Session = database().createSession

}
package org.piro84.performance.petclinic.request

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck

/**
 * Contains requests related to visits.
 */
object VisitRequest {

  def extractIdFromUrl(): String = {
    val urlElements="/${visitLink}".split("/")
    urlElements(urlElements.length - 1)
  }
  
  
  val NavigateToNewVisitForm = {
    exec(http("Navigate to the new visit form")
      .get("/owners/${visitLink}"))
  }

  val AddNewVisit = {
    exec(http("Add a new visit")
      .post("/owners/${visitLink}")
      .formParam("date", "2015/09/09")
      .formParam("description", "test"))
  }
}
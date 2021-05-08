import { LOCAL_URL } from "../../support";

// It's a need to run the tests with a test database or
// TODO: Mock all the requests
context("Logged in / Teacher", () => {
  beforeEach(() => {
    cy.login("teacher@gmail.com", "pass");
  });

  // The server is returning 404 if whatever authorized URL is accessed directly by the address bar.
  // Skipping until the bug is fixed.
  it.skip("should load home page after loggin in the application", () => {
    cy.visit(`${LOCAL_URL}/courses`, { failOnStatusCode: false });

    cy.get(".dashboard-title").should("be.visible");
  });

  it("should redirect to a logged in route when accessing a public route with a valid cookie", () => {
    cy.visit(`${LOCAL_URL}/`);

    // Assertions
    cy.url().should("eq", `${LOCAL_URL}/courses`);
    cy.get(".dashboard-title").should("be.visible");
  });

  it("should verify a course `attenders` list", () => {
    cy.visit(`${LOCAL_URL}/`);
    cy.clickOnElement(".course-list-item:nth-child(2)");
    cy.clickOnElement("i[data-tooltip='Attenders']");

    // Assertions
    cy.get(".attender-row-div").should("have.length", 1);
    cy.contains("Teacher Cheater");
  });

  it("should be possible to add a student to a course", () => {
    cy.visit(`${LOCAL_URL}/`);
    cy.clickOnElement(".course-list-item:nth-child(2)");
    cy.clickOnElement("i[data-tooltip='Attenders']");

    // Assertions
    cy.get(".attender-row-div").should("have.length", 1);
    cy.contains("Teacher Cheater");

    cy.clickOnElement("a[title='Add attenders'");
    cy.get("#input-attender-simple").type("student1@gmail.com");
    cy.clickOnElement("#put-modal-btn");

    // Assertions
    cy.get(".attender-row-div").should("have.length", 2);
  });

  it("should be possible to delete a student from a course", () => {
    cy.visit(`${LOCAL_URL}/`);
    cy.clickOnElement(".course-list-item:nth-child(2)");
    cy.clickOnElement("i[data-tooltip='Attenders']");

    // Assertions
    cy.get(".attender-row-div").should("have.length", 2);
    cy.contains("Teacher Cheater");
    cy.contains("Student Imprudent");

    cy.clickOnElement("i[title='Modify attenders']");
    cy.clickOnElement("i[title='Remove Student Imprudent']");

    // Assertions
    cy.contains("Student Imprudent").should("not.exist");
    cy.get(".attender-row-div").should("have.length", 1);
  });

  it("should redirect to the application github repository", () => {
    cy.visit(`${LOCAL_URL}/`);

    cy.get("a")
      .contains("GitHub repository")
      .invoke("removeAttr", "target")
      .click();

    // Assertions
    cy.url().should("eq", "https://github.com/pabloFuente/full-teaching");
  });
});

// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

import { LOCAL_URL } from ".";

Cypress.Commands.add("login", (username, password) => {
  cy.log(`Logging in as ${username}`);

  cy.request({
    method: "POST",
    url: `${LOCAL_URL}/api-logIn`,
    auth: {
      user: username,
      pass: password,
      sendImmediately: true,
    },
  }).then(({ body }) => {
    cy.log(`User data: ${body}`);
  });
});

Cypress.Commands.add(
  "clickOnElement",
  (element, multiple = true, force = true) => {
    cy.get(element).click({ multiple: true });
  }
);

Feature: Reportar un bug

  Background:
    Given Encender el movil
    And   Abrir la aplicacion
    And   Se visualiza la aplicacion


  @bug
  Scenario: Reportar un bug
    And   Hacer clic en el menu
    And   Hacer clic en la opcion Report a Bug
    And   Escribir el bug
    And   Hacer clic en enviar
    Then  Comprobar que el mensaje se ha enviado
Feature: Compra en la aplicacion

  Background:
    Given Encender el movil
    And   Abrir la aplicacion
    And   Se visualiza la aplicacion


  @add
  Scenario: Incluir mochila al producto
    And     Hacer clic en la mochila
    And     Incluir en el carrito
    And     Hacer clic en el carrito
    Then    Comprobar que esta en el carrito


  @compra
  Scenario: Comprar una camiseta
    And     Hacer clic en la camiseta
    And     Incluir en el carrito
    And     Hacer clic en el carrito
    And     Comprobar que esta en el carrito
    And     Hacer clic en comprar
    And     Hacer login
    And     Rellenar los datos
    And     Ir a metodos de pago
    And     Rellenar metodo de pago
    And     Hacer clic en revisar compra
    And     Hacer clic en realizar compra
    Then    Comprobar que la compra se ha realizado

Feature: como usuario logueado, quiero realizar una compra

  @Shopping
  Scenario Outline: el cliente busca un producto
    Given el cliente se encuentra en el buscador de productos
    When el cliente ingresa un <producto> en el buscador
    Then el cliente verifica que es redireccionado a la pantalla de resultados

    Examples:
      | producto |
      | dress    |

  @Shopping @Ignore
  Scenario Outline: el cliente selecciona un producto
    Given el cliente se encuentra en la pantalla de resultados
    When el cliente clickea un <producto>
    And ingresa la <cantidad> a comprar
    And seleciona un <talle>
    And selecciona un <color>
    And hace click en el boton "add to cart"
    Then el cliente es redireccionado al carrito de compra

    Examples:
      | producto      | cantidad| talle | color     |
      | Model demo_4  | 1       | S     | color_24  |

  @Shopping @Ignore
  Scenario: el cliente compra un producto
    Given el cliente se encuentra en el carrito de compras
    When el cliente confirma la compra haciendo click en "Proceed to checkout"
    And el cliente confirma la direccion haciendo click en "Proceed to checkout"
    And el cliente acepta los terminos de servicio haciendo click en el checkbox y clickeando "Proceed to checkout"
    And el cliente selecciona un metodo de pago
    And confirma la orden haciendo click en "I confirm my order"
    Then el cliente es redireccionado a la pagina de "Order Confirmation"




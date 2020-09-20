Feature: como usuario logueado, quiero realizar una compra

  @Shopping @Ignore
  Scenario Outline: el cliente busca un producto
    Given el cliente se encuentra en el buscador de productos
    When el cliente ingresa un <producto> en el buscador
    Then el cliente verifica que es redireccionado a la pantalla de resultados

    Examples:
      | producto |
      | dress    |

  @Shopping @Ignore
  Scenario Outline: el cliente elige un producto
    Given el cliente se encuentra en la pantalla de resultados
    When el cliente elige el <item>° producto
    Then el cliente verifica que fue redireccionado a la pantalla del item seleccionado

    Examples:
      | item  |
      | 4     |

  @Shopping
  Scenario Outline: el cliente  el producto seleccionado
    Given el cliente se encuentra en la pantalla del producto seleccionado
    When ingresa la <cantidad> a comprar
    And seleciona un <talle>
    And selecciona un <color>
    And hace click en el boton para agregar al carrito de compra
    Then el cliente es redireccionado al carrito de compra

    Examples:
      | cantidad| talle   | color   |
      | 2       | L       | Green   |

  @Shopping @Ignore
  Scenario: el cliente compra un producto
    Given el cliente se encuentra en el carrito de compras
    When el cliente confirma la compra haciendo click en "Proceed to checkout"
    And el cliente confirma la direccion haciendo click en "Proceed to checkout"
    And el cliente acepta los terminos de servicio haciendo click en el checkbox y clickeando "Proceed to checkout"
    And el cliente selecciona un metodo de pago
    And confirma la orden haciendo click en "I confirm my order"
    Then el cliente es redireccionado a la pagina de "Order Confirmation"




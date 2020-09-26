Feature: como usuario logueado, quiero realizar una compra

  @Shopping
  Scenario Outline: el cliente busca un producto
    Given el cliente se encuentra en el buscador de productos
    When el cliente ingresa un <producto> en el buscador
    Then el cliente verifica que es redireccionado a la pantalla de resultados

    Examples:
      | producto |
      | dress    |

  @Shopping
  Scenario: el cliente elige un producto
    Given el cliente se encuentra en la pantalla de resultados
    When el cliente elige un producto
    Then el cliente verifica que fue redireccionado a la pantalla del item seleccionado


  @Shopping
  Scenario Outline: el cliente agrega el producto seleccionado al carrito de compras y confirma la compra
    Given el cliente se encuentra en la pantalla del producto seleccionado
    When ingresa la <cantidad> a comprar
    And seleciona un <talle>
    And selecciona un <color>
    And hace click en el boton para agregar al carrito de compra
    And el cliente confirma la compra haciendo click en Proceed to checkout
    And el cliente se loguea con <email> y <contraseña>
    And el cliente confirma la direccion haciendo click en Proceed to checkout
    And el cliente acepta los terminos de servicio haciendo click en el checkbox y clickeando Proceed to checkout
    And el cliente selecciona el <metodo_de_pago> deseado y confirma la orden haciendo click en I confirm my order
    Then el cliente es redireccionado a la pagina de Order Confirmation

    Examples:
    |metodo_de_pago | cantidad| talle   | color   | email                   |contraseña   |
    |tb             | 2       | L       | Green   | emanuel.videla@gmail.com|13579        |





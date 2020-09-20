package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class ShopSteps extends PageSteps {
    @Given("el cliente se encuentra en el buscador de productos")
    public void elClienteSeEncuentraEnElBuscadorDeProductos(){
        Injector._page(StoreHomePage.class).go();
    }

    @When("el cliente ingresa un (.*) en el buscador")
    public void elClienteIngresaUnProductoEnElBuscador(String busqueda) {
        Injector._page(StoreHomePage.class).enterSearch(busqueda);
    }

    @Then("el cliente verifica que es redireccionado a la pantalla de resultados")
    public void elClienteVerificaQueEsRedireccionadoALaPantallaDeResultados() {
        Injector._page(ShopResultSearchPage.class).verifYProduct();
        //Assert.assertTrue(!Injector._page(ShopResultSearchPage.class).getStats().isEmpty());

    }

    @Given("el cliente se encuentra en la pantalla de resultados")
    public void elClienteSeEncuentraEnLaPantallaDeResultados() {
        Injector._page(ShopResultSearchPage.class).go();
    }

    @When("el cliente elige el <item>° producto")
    public void elClienteEligeElNProducto(int item) {
        Injector._page(ShopResultSearchPage.class).selectItem(item);
    }

    @Then("el cliente verifica que fue redireccionado a la pantalla del item seleccionado")
    public void elClienteVerificaQueFueRedireccionadoALaPantallaDelItemSeleccionado() {
        Injector._page(Product.class).verifyProduct();
    }

    @Given("el cliente se encuentra en la pantalla del producto seleccionado")
    public void elClienteSeEncuentraEnLaPantallaDelProductoSeleccionado() {
        Injector._page(Product.class).go();
    }

    @When("ingresa la (.*) a comprar")
    public void ingresaLaCantidadAComprar(String cantidad) {
        Injector._page(Product.class).completeCantidad(cantidad);
    }

    @And("seleciona un (.*)")
    public void selecionaUnTalle(String tallePorValue) {
        Injector._page(Product.class).selectTalle(tallePorValue);
    }

    @And("selecciona un (.*)")
    public void seleccionaUnColor(String color) {
        Injector._page(Product.class).selectColor(color);
    }

    @And("hace click en el boton para agregar al carrito de compra")
    public void haceClickEnElBoton() {
        Injector._page(Product.class).addToCart();
    }

    @Then("el cliente es redireccionado al carrito de compra")
    public void elClienteEsRedireccionadoAlCarritoDeCompra() {
        Injector._page(ShoppingCart.class).verifyPage();
    }


    @Given("el cliente se encuentra en el carrito de compras")
    public void elClienteSeEncuentraEnElCarritoDeCompras() {
        Injector._page(ShoppingCart.class).go();
    }

    @When("el cliente confirma la compra haciendo click en {string}")
    public void elClienteConfirmaLaCompraHaciendoClickEn(String arg0) {
    }

    @And("el cliente confirma la direccion haciendo click en {string}")
    public void elClienteConfirmaLaDireccionHaciendoClickEn(String arg0) {
    }

    @And("el cliente acepta los terminos de servicio haciendo click en el checkbox y clickeando {string}")
    public void elClienteAceptaLosTerminosDeServicioHaciendoClickEnElCheckboxYClickeando(String arg0) {
    }

    @And("el cliente selecciona un metodo de pago")
    public void elClienteSeleccionaUnMetodoDePago() {

    }

    @And("confirma la orden haciendo click en {string}")
    public void confirmaLaOrdenHaciendoClickEn(String arg0) {
    }

    @Then("el cliente es redireccionado a la pagina de {string}")
    public void elClienteEsRedireccionadoALaPaginaDe(String arg0) {
    }



}

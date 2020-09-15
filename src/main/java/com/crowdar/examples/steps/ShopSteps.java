package com.crowdar.examples.steps;

import com.crowdar.core.Injector;
import com.crowdar.core.PageSteps;
import com.crowdar.examples.pages.ShopResultSearchPage;
import com.crowdar.examples.pages.StoreHomePage;
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
        Assert.assertTrue(!Injector._page(ShopResultSearchPage.class).getStats().isEmpty());

    }

    @Given("el cliente se encuentra en la pantalla de resultados")
    public void elClienteSeEncuentraEnLaPantallaDeResultados() {
    }

    @When("el cliente clickea un (.*)")
    public void elClienteClickeaUnProducto() {
    }

    @And("ingresa la (.*) a comprar")
    public void ingresaLaCantidadAComprar() {
    }

    @And("seleciona un (.*)")
    public void selecionaUnTalle() {
    }

    @And("selecciona un (.*)")
    public void seleccionaUnColor() {
    }

    @And("hace click en el boton {string}")
    public void haceClickEnElBoton(String arg0) {
    }

    @Then("el cliente es redireccionado al carrito de compra")
    public void elClienteEsRedireccionadoAlCarritoDeCompra() {
    }

    @Given("el cliente se encuentra en el carrito de compras")
    public void elClienteSeEncuentraEnElCarritoDeCompras() {
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

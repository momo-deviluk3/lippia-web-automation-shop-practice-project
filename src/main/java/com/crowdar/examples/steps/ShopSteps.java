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
        Injector._page(ShopResultSearchPage.class).verifyProduct();
        //Assert.assertTrue(!Injector._page(ShopResultSearchPage.class).getStats().isEmpty());

    }

    @Given("el cliente se encuentra en la pantalla de resultados")
    public void elClienteSeEncuentraEnLaPantallaDeResultados() {
        Injector._page(ShopResultSearchPage.class).go();
    }

    @When("el cliente elige el (.*)")
    public void elClienteEligeElProducto(int producto) {
        Injector._page(ShopResultSearchPage.class).selectItem(producto);
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


    @And("el cliente confirma la compra haciendo click en Proceed to checkout")
    public void elClienteConfirmaLaCompraHaciendoClickEnProceedToCheckout() {
        Injector._page(ShoppingCart.class).clickSummaryButton();
    }

    @And("el cliente se loguea con (.*) y (.*)")
    public void elClienteSeLoguea(String user,String pass) {
        Injector._page(ShoppingCart.class).login(user,pass);
    }

    @And("el cliente confirma la direccion haciendo click en Proceed to checkout")
    public void elClienteConfirmaLaDireccionHaciendoClickEnProceedToCheckout() {
        Injector._page(ShoppingCart.class).clickAdressButton();
    }

    @And("el cliente acepta los terminos de servicio haciendo click en el checkbox y clickeando Proceed to checkout")
    public void elClienteAceptaLosTerminosDeServicioHaciendoClickEnElCheckboxYClickeandoProceedToCheckout() {
        Injector._page(ShoppingCart.class).clickShippingButton();
    }

    @And("el cliente selecciona el (.*) deseado y confirma la orden haciendo click en I confirm my order")
    public void elClienteSeleccionaElMetodo_de_pagoDeseado(String metodoPago) {
        Injector._page(ShoppingCart.class).selectPaymentMethod(metodoPago);
    }

    @Then("el cliente es redireccionado a la pagina de Order Confirmation")
    public void elClienteEsRedireccionadoALaPaginaDeOrderConfirmation() {
        Injector._page(ShoppingCart.class).verifyOrder();
    }



}

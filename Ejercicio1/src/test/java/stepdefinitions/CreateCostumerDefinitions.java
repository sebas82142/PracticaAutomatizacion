package stepdefinitions;

import static exceptions.DeleteCustomerException.DELETE_CUSTOMER_MESSAGE_ERROR;
import static exceptions.NoChangeInFieldsException.NO_CHANGE_FIELDS_MESSAGE_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.DeleteCustomerException;
import exceptions.NoChangeInFieldsException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import questions.ValidateCustomerDeleteQuestion;
import questions.ValidateModifyFields;
import tasks.CleanFields;
import tasks.CreateNewCustomer;
import tasks.DeleteCustomer;
import tasks.EditCustomer;
import tasks.GoToEditCustomer;
import tasks.LogIn;
import tasks.SignIn;

public class CreateCostumerDefinitions {
	
	private Actor actor = Actor.named("Administrator");

	@Managed(driver = "chrome")
	public WebDriver hisBrowser;
	
	@Before
	public void configuracioInicial() {
		actor.can(BrowseTheWeb.with(hisBrowser));
	}
	
	@Given("^el usuario se registra con correo (.*)$")
    public void el_usuario_se_encuentra_en_la_pággina_inicial_de_Guru_Bank(String email){
		actor.wasAbleTo(SignIn.with(email));				
    }
	
	@Given("^se autentica con credenciales del sistema$")
    public void seAutenticaConCredencialesDelSistema(){
		actor.attemptsTo(LogIn.withCredentialSystem());	
    }
    	
    @When("^el usuario registra un nuevo cliente con datos$")
    public void elUsuarioHaceClickSobreElLinkHere(List<Map<String, String>> data){
    	actor.attemptsTo(CreateNewCustomer.with(data.get(0)));
    }
    
    @When("^el usuario valida campos obligatorios$")
    public void elUsuarioValidaCamposObligatorios(){
    	actor.attemptsTo(GoToEditCustomer.page(),
    			CleanFields.andValidateMessage());
    }
    
    @And("^el usuario modifica el estado a (.*) y el pin a (.*)")
    public void elUsuarioModificaElEstadoAYElPinA(String state, String pin){
    	actor.attemptsTo(EditCustomer.with(state, pin));
    }
    
    @Given("^el usuario elimina el cliente registrado por su id$")
    public void elUsuarioEliminaElClienteRegistradoPorSuId() {
    	actor.attemptsTo(DeleteCustomer.withCustomerID());
    }

    @Then("^el usuario deberia visualizar el mensaje (.*)$")
    public void elUsuarioDeberiaVisualizarMensajeDeConfirmacion(String message) {
    	actor.should(
				seeThat(ValidateCustomerDeleteQuestion.withTheMessage(message))
				.orComplainWith(DeleteCustomerException.class, DELETE_CUSTOMER_MESSAGE_ERROR));
    }
    
    @Then("^deberia visualizar el cambio de los campos$")
    public void deberiaVisualizarElCambioDeLosCampos() {    	
    	actor.should(seeThat(
    			ValidateModifyFields.withNewState())
    			.orComplainWith(NoChangeInFieldsException.class, NO_CHANGE_FIELDS_MESSAGE_ERROR),
    			seeThat(
    					ValidateModifyFields.withNewPin())
    			.orComplainWith(NoChangeInFieldsException.class, NO_CHANGE_FIELDS_MESSAGE_ERROR));
    }
    
    @After
    public void deleteUser() {
    	actor.attemptsTo(DeleteCustomer.withCustomerID());
    }
    
}
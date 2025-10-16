package com.capgemini.test.code.acceptance.step;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(properties = "spring.flyway.enabled=false")
@AutoConfigureMockMvc(print = MockMvcPrint.LOG_DEBUG)
@Transactional
@ActiveProfiles("test")
@CucumberContextConfiguration
public class CreateUserStepTest {

    private String jsonRequest;
    private ResultActions result;

    @Autowired
    private MockMvc mockMvc;

    @Given("no existe un usuario")
    public void notExistsUser() {
        jsonRequest = String.format("""
            { 
                 "name": "%s",
                 "email": "%s", 
                 "phone": "%s", 
                 "rol": "%s", 
                 "dni": "%s" 
             }
        """, "jose", "ignaciomarinreyes@gmail.com","627645678", "admin", "54999267G");
    }

    @When("creo un usuario")
    public void createUser() throws Exception {
        result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest));
    }

    @Then("el usuario debe existir en la base de datos")
    public void userExistsDB() throws Exception {
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1));
    }
}

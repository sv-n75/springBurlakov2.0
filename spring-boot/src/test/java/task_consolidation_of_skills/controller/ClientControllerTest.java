package task_consolidation_of_skills.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsInAnyOrder;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
//@Sql(value = {"/create-client-address-order-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ClientControllerTest {

    @Autowired
    private ClientController clientController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getClients() throws Exception {
        this.mockMvc.perform(get("/clients/clients"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].id", containsInAnyOrder(1, 2)))
                .andExpect(jsonPath("$[*].individualTaxNumber", containsInAnyOrder("540002", "540003")));
    }

    @Test
    public void addClient() {
    }

    @Test
    public void getClient() throws Exception {
        this.mockMvc.perform(get("/clients/client/id/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(1)))
                .andExpect(jsonPath("$.title", equalTo("OOO Uspeh")));
    }

    @Test
    public void deleteClient() {
    }

    @Test
    public void addOrder() {
    }

    @Test
    public void getOrder() {
    }

    @Test
    public void getOrders() {
    }

    @Test
    public void deleteOrder() {
    }

    @Test
    public void updateClient() {
    }

    @Test
    public void updateOrder() {
    }
}
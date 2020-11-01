package com.beautysoftware.com;

import com.beautysoftware.com.controller.RegisterClienteController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ValidationRuleTest {
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new RegisterClienteController()).build();
    }

    @Test
    public void givenMatchingEmailPassword_whenPostNewUserForm_thenOk()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/client/new")
                .accept(MediaType.TEXT_HTML)
                .param("nickName","name")
                .param("email", "john@yahoo.com")
                .param("password", "password")
                .param("confirmPassword", "password"))
                .andExpect(model().errorCount(0))
                .andExpect(status().isOk());
    }

    @Test
    public void givenMatchingEmailPassword_whenPostNewUserForm_thenFalse()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/client/new")
                .accept(MediaType.TEXT_HTML)
                .param("nickName","name")
                .param("email", "johnyahoocom")
                .param("password", "pass")
                .param("confirmPassword", "pass"))
                .andExpect(model().errorCount(1))
              ;
    }

    @Test
    public void givenBadPassword_whenPostNewUserForm_thenFalse()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/client/new")
                .accept(MediaType.TEXT_HTML)
                .param("nickName","name")
                .param("email", "john@yahoo.com")
                .param("password", "pass")
                .param("confirmPassword", "pass"))
                .andExpect(model().errorCount(2))
                .andExpect(status().isOk());
    }

    @Test
    public void givenPasswordDontMathc_whenPostNewUserForm_thenFalse()
            throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/client/new")
                .accept(MediaType.TEXT_HTML)
                .param("nickName","name")
                .param("email", "john@yahoo.com")
                .param("password", "password")
                .param("confirmPassword", "password1"))
                .andExpect(model().errorCount(1))
                .andExpect(status().isOk());
    }
}

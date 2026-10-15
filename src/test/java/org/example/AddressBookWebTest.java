package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddressBookWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createBookAndBuddyThenViewPage() throws Exception {
        String bookUrl = mockMvc.perform(post("/api/addressBooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getHeader("Location");

        String buddyUrl = mockMvc.perform(post("/api/buddyInfoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Alice Smith\",\"phoneNumber\":\"613-555-0101\",\"address\":\"1 Main St\"}"))
                .andExpect(status().isCreated())
                .andReturn().getResponse().getHeader("Location");

        mockMvc.perform(post(bookUrl + "/buddies")
                        .contentType("text/uri-list")
                        .content(buddyUrl))
                .andExpect(status().isNoContent());

        String id = bookUrl.substring(bookUrl.lastIndexOf('/') + 1);
        mockMvc.perform(get("/addressbook/" + id))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Alice Smith")))
                .andExpect(content().string(containsString("1 Main St")));
    }
}
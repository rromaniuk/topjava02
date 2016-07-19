package ru.javawebinar.topjava.web.meal;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.web.WebTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.HSQLDB;

/**
 * GKislin
 * 10.04.2015.
 */
@ActiveProfiles({HSQLDB, DATAJPA})
public class UserMealControllerTest extends WebTest{

    @Test
    public void testMealList() throws Exception {
        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
//                .andExpect(status().isOk())
//                .andExpect(view().name("mealList"))
//                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"));
//                .andExpect(model().attribute("mealList", hasSize(4)))
//                .andExpect(model().attribute("mealList", hasItem(
//                        allOf(
//                                hasProperty("id", is(MEAL1_ID)),
//                                hasProperty("description", is(MEAL1.getDescription()))
//                        )
//                )));
    }
}
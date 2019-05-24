package main;

import main.controller.DayMenuController;
import main.db.DayMenuDb;
import main.db.MealDb;
import main.db.WeekMenuDb;
import main.model.DayMenu;
import main.model.builder.DayMenuBuilder;
import main.service.MealService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@WebMvcTest(DayMenuController.class)
public class DayMenuControllerUnitTest {

    @Autowired
    private MockMvc dayMenuController;

    @MockBean
    private MealService service;

    @MockBean
    private MealDb mealDb;

    @MockBean
    private DayMenuDb dayMenuDb;

    @MockBean
    private WeekMenuDb weekMenuDb;

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void given_Two_DayMenus_when_GetDayMenus_then_ReturnJsonArray() throws Exception {

        DayMenu dayMenu1 = DayMenuBuilder.dayMenu1().build();
        DayMenu dayMenu2 = DayMenuBuilder.dayMenu2().build();
        when(service.getDayMenus()).thenReturn(Arrays.asList(dayMenu1, dayMenu2));

        dayMenuController.perform(get("/dagmenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].date").value("2019-02-18"))
                .andExpect(jsonPath("$[0].soup.name").value("Tomatensoep"))
                .andExpect(jsonPath("$[0].soup.price").value(1))
                .andExpect(jsonPath("$[0].soup.mealType").value("SOEP"))
                .andExpect(jsonPath("$[0].daily.name").value("Konijn met pruimen"))
                .andExpect(jsonPath("$[0].daily.price").value(4.2))
                .andExpect(jsonPath("$[0].daily.mealType").value("DAGSCHOTEL"))
                .andExpect(jsonPath("$[0].veggie.name").value("Veggie pasta"))
                .andExpect(jsonPath("$[0].veggie.price").value(4))
                .andExpect(jsonPath("$[0].veggie.mealType").value("VEGGIE"))
                .andExpect(jsonPath("$[1].date").value("2019-02-19"))
                .andExpect(jsonPath("$[1].soup.name").value("Bloemkoolsoep"))
                .andExpect(jsonPath("$[1].soup.price").value(1))
                .andExpect(jsonPath("$[1].soup.mealType").value("SOEP"))
                .andExpect(jsonPath("$[1].daily.name").value("Cordon Blue"))
                .andExpect(jsonPath("$[1].daily.price").value(4.2))
                .andExpect(jsonPath("$[1].daily.mealType").value("DAGSCHOTEL"))
                .andExpect(jsonPath("$[1].veggie.name").value("Veggie pasta"))
                .andExpect(jsonPath("$[1].veggie.price").value(4))
                .andExpect(jsonPath("$[1].veggie.mealType").value("VEGGIE"));
    }

}

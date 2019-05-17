package main;

import main.db.DayMenuDb;
import main.db.MealDb;
import main.db.WeekMenuDb;
import main.model.DayMenu;
import main.model.Meal;
import main.model.MealType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class DayMenuControllerIntegrationTest {

    @Autowired
    private MockMvc dayMenuController;

    @Autowired
    private DayMenuDb dayMenuDb;

    @Autowired
    private MealDb mealDb;

    @Autowired
    private WeekMenuDb weekMenuDb;

    @Test
    public void givenDayMenus_whenGetDayMenus_thenStatus200AndJSONofMeals() throws Exception {
        this.createTestDayMenu(LocalDate.of(2019,2,19), new Meal("Bloemkoolsoep", 1, MealType.SOEP), new Meal("Cordon Blue", 4.2, MealType.DAGSCHOTEL), new Meal("Veggie pasta", 4, MealType.VEGGIE));

        dayMenuController.perform(get("/dagmenu")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(11)))
                .andExpect(jsonPath("$[10].date").value("2019-02-19"))
                .andExpect(jsonPath("$[10].soup.name").value("Bloemkoolsoep"))
                .andExpect(jsonPath("$[10].soup.price").value(1))
                .andExpect(jsonPath("$[10].soup.mealType").value("SOEP"))
                .andExpect(jsonPath("$[10].daily.name").value("Cordon Blue"))
                .andExpect(jsonPath("$[10].daily.price").value(4.2))
                .andExpect(jsonPath("$[10].daily.mealType").value("DAGSCHOTEL"))
                .andExpect(jsonPath("$[10].veggie.name").value("Veggie pasta"))
                .andExpect(jsonPath("$[10].veggie.price").value(4))
                .andExpect(jsonPath("$[10].veggie.mealType").value("VEGGIE"));
    }

    private void createTestDayMenu(LocalDate date, Meal soup, Meal daily, Meal veggie) {
        mealDb.saveAndFlush(soup);
        mealDb.saveAndFlush(daily);
        mealDb.saveAndFlush(veggie);
        DayMenu dayMenu = new DayMenu(date, soup, daily, veggie);
        dayMenuDb.saveAndFlush(dayMenu);
    }

}

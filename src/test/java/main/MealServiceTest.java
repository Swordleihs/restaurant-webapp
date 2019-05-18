package main;

import main.db.DayMenuDb;
import main.db.MealDb;
import main.db.WeekMenuDb;
import main.model.*;
import main.model.builder.MealBuilder;
import main.service.MealService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class MealServiceTest {

    @TestConfiguration
    static class MealServiceTestContextConfiguration {

        @Bean
        public MealService mealService() {
            return new MealService();
        }
    }

    @Autowired
    private MealService service;

    @MockBean
    private DayMenuDb dayMenuDb;

    @MockBean
    private MealDb mealDb;

    @MockBean
    private WeekMenuDb weekMenuDb;

    private Meal soup, daily, veggie;
    private List<Meal> meals;

    @Before
    public void setUp() {
        soup = MealBuilder.soupMeal().build();
        daily = MealBuilder.dailyMeal().build();
        veggie = MealBuilder.veggieMeal().build();
        meals = new ArrayList<Meal>();
        meals.add(soup);
        meals.add(daily);
    }

    public List<Meal> getAllMeals(){
        return mealDb.findAll();
    }

    @Test
    public void getAllMeals_Should_Get_All_Meals(){
        Mockito.when(mealDb.findAll()).thenReturn(meals);

        List<Meal> foundMeals = service.getAllMeals();

        assertThat(foundMeals.size()).isEqualTo(2);
        assertThat(foundMeals).contains(soup);
        assertThat(foundMeals).contains(daily);
    }

    @Test
    public void findMealByName_Should_Return_Meal_With_Given_Name_If_There_Is_Meal_With_Given_Name(){
        Mockito.when(mealDb.findByName(soup.getName())).thenReturn(soup);

        String name = "Tomatensoep";
        double price = 2.5;
        MealType mealType = MealType.SOEP;

        Meal foundMeal = service.findMealByName(name);

        assertThat(foundMeal.getName()).isEqualTo(name);
        assertThat(foundMeal.getPrice()).isEqualTo(price);
        assertThat(foundMeal.getMealType()).isEqualTo(mealType);
    }

    @Test(expected = Exception.class)
    public void findMealByName_Null_Should_Throw_Exception () {
        service.findMealByName(null);
    }

    @Test(expected = Exception.class)
    public void findMealByName_Empty_Should_Throw_Exception () {
        service.findMealByName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void findMealByName_Non_Existing_Meal_Name_Should_Throw_Exception () {
        service.findMealByName("bruhxd");
    }

    @Test
    public void addMeal_Should_Add_New_Meal_When_Correct_Meal_Is_Given(){
        Mockito.when(mealDb.save(veggie)).thenReturn(veggie);

        Meal addedMeal = service.addMeal(veggie);

        assertThat(addedMeal.getName()).isEqualTo("Veggie Pasta");
        assertThat(addedMeal.getPrice()).isEqualTo(3.5);
        assertThat(addedMeal.getMealType()).isEqualTo(MealType.VEGGIE);
    }

    @Test(expected = Exception.class)
    public void addMeal_Null_Should_Throw_Exception () {
        service.addMeal(null);
    }

    @Test
    public void deleteMeal_Deletes_If_correct_Meal_Given(){
        Mockito.when(mealDb.save(soup)).thenReturn(soup);

        service.deleteMeal(soup);

        assertThat(service.getAllMeals().size()).isEqualTo(0);
    }

    @Test(expected = Exception.class)
    public void deleteMeal_Null_Should_Throw_Exception () {
        service.deleteMeal(null);
    }

    @Test
    public void updateMeal_Update_Meal_If_Correct_Meal_Given(){
        Mockito.when(mealDb.save(soup)).thenReturn(soup);
        Mockito.when(mealDb.findByName(soup.getName())).thenReturn(soup);

        soup.setPrice(7);

        service.updateMeal(soup);

        Meal updatedMeal = mealDb.findByName("Tomatensoep");
        assertThat(updatedMeal.getPrice()).isEqualTo(7);
    }

    @Test(expected = Exception.class)
    public void updateMeal_Null_Should_Throw_Exception(){
        service.updateMeal(null);
    }
}
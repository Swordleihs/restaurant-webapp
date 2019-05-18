package main;

import main.db.MealDb;
import main.model.Meal;
import main.model.builder.MealBuilder;
import main.model.MealType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MealDbIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MealDb mealDb;

    @Test
    public void findAll_should_find_all_meals() {
        Meal soup = MealBuilder.soupMeal().build();
        entityManager.persist(soup);
        entityManager.flush();

        Meal daily = MealBuilder.dailyMeal().build();
        entityManager.persist(daily);
        entityManager.flush();

        List<Meal> mealsFound = mealDb.findAll();

        assertThat(mealsFound.size() == 2);
        assertThat(mealsFound.contains(soup));
        assertThat(mealsFound.contains(daily));
    }

    @Test
    public void save_should_save_meal_when_correct_meal_given() {
        Meal soup = MealBuilder.soupMeal().build();

        Meal addedMeal = mealDb.save(soup);

        assertThat(addedMeal.getName()).isEqualTo("Tomatensoep");
        assertThat(addedMeal.getPrice()).isEqualTo(2.5);
        assertThat(addedMeal.getMealType()).isEqualTo(MealType.SOEP);
    }

    @Test(expected = Exception.class)
    public void save_should_throw_exception_when_incorrect_meal_given (){
        Meal addedMeal = mealDb.save(null);
    }

    @Test
    public void findByName_should_find_meal_by_given_name () {
        Meal veggie = new Meal("groentenlasagne", 4, MealType.VEGGIE);
        entityManager.persist(veggie);
        entityManager.flush();

        Meal foundMeal = mealDb.findByName(veggie.getName());

        assertThat(foundMeal.getName()).isEqualTo(veggie.getName());
        assertThat(foundMeal.getPrice()).isEqualTo(veggie.getPrice());
        assertThat(foundMeal.getMealType()).isEqualTo(veggie.getMealType());
    }

    @Test
    public void findByName_by_given_name_null_should_return_null () {
        assertThat(mealDb.findByName(null) == null);
    }

    @Test
    public void findByName_by_given_unused_name_should_return_null () {
        // when
        assertThat(mealDb.findByName("bruhlolxddd") == null);
    }


}

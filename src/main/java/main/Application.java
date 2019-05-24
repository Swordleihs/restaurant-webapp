package main;

import main.db.DayMenuDb;
import main.db.MealDb;
import main.db.WeekMenuDb;
import main.model.DayMenu;
import main.model.Meal;
import main.model.MealType;
import main.model.WeekMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.time.LocalDate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /*
    @Bean
    @Order(1)
    public CommandLineRunner runnerMeals(MealDb mealDb) {
        return MealsArgs -> {
            mealDb.save(new Meal("Bloemkoolsoep", 1, MealType.SOEP));
            mealDb.save(new Meal("Tomatensoep", 1, MealType.SOEP));
            mealDb.save(new Meal("Pompoensoep", 1, MealType.SOEP));
            mealDb.save(new Meal("Preisoep", 1, MealType.SOEP));
            mealDb.save(new Meal("Cordon Blue", 4.2, MealType.DAGSCHOTEL));
            mealDb.save(new Meal("Konijn met Pruimen", 4.2, MealType.DAGSCHOTEL));
            mealDb.save(new Meal("Biefstuk met Friet", 4.2, MealType.DAGSCHOTEL));
            mealDb.save(new Meal("Groentenlasagne", 4, MealType.VEGGIE));
            mealDb.save(new Meal("Veggie Pasta", 4, MealType.VEGGIE));
            mealDb.save(new Meal("Salade", 4, MealType.VEGGIE));
        };
    }

    @Bean
    @Order(2)
    public CommandLineRunner runnerDayMenus(DayMenuDb dayMenuDb, MealDb mealDb) {
        return DayMenusArgs -> {
            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 22),
                    mealDb.findByName("Bloemkoolsoep"),
                    mealDb.findByName("Cordon Blue"),
                    mealDb.findByName("Groentenlasagne")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 23),
                    mealDb.findByName("Bloemkoolsoep"),
                    mealDb.findByName("Cordon Blue"),
                    mealDb.findByName("Veggie Pasta")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 24),
                    mealDb.findByName("Bloemkoolsoep"),
                    mealDb.findByName("Konijn met Pruimen"),
                    mealDb.findByName("Groentenlasagne")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 25),
                    mealDb.findByName("Bloemkoolsoep"),
                    mealDb.findByName("Konijn met Pruimen"),
                    mealDb.findByName("Veggie Pasta")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 26),
                    mealDb.findByName("Tomatensoep"),
                    mealDb.findByName("Cordon Blue"),
                    mealDb.findByName("Groentenlasagne")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 29),
                    mealDb.findByName("Tomatensoep"),
                    mealDb.findByName("Cordon Blue"),
                    mealDb.findByName("Veggie Pasta")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,4, 30),
                    mealDb.findByName("Tomatensoep"),
                    mealDb.findByName("Konijn met Pruimen"),
                    mealDb.findByName("Groentenlasagne")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,5, 1),
                    mealDb.findByName("Pompoensoep"),
                    mealDb.findByName("Cordon Blue"),
                    mealDb.findByName("Groentenlasagne")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,5, 2),
                    mealDb.findByName("Pompoensoep"),
                    mealDb.findByName("Cordon Blue"),
                    mealDb.findByName("Veggie Pasta")));

            dayMenuDb.save(new DayMenu(LocalDate.of(2019,5, 3),
                    mealDb.findByName("Pompoensoep"),
                    mealDb.findByName("Konijn met Pruimen"),
                    mealDb.findByName("Groentenlasagne")));
        };
    }

    @Bean
    @Order(3)
    public CommandLineRunner runnerWeekMenus(WeekMenuDb weekMenuDb, DayMenuDb dayMenuDb) {
        return WeekMenuArgs -> {
            WeekMenu weekMenu0 = new WeekMenu();
            DayMenu dayMenu = dayMenuDb.findById(LocalDate.of(2019,4, 22)).orElseThrow(IllegalArgumentException::new);
            int yearAndWeekNumber = dayMenu.getYearAndWeekNumber();
            weekMenu0.setId(yearAndWeekNumber);

            weekMenu0.addDayMenu(dayMenu);
            weekMenu0.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,4, 23)).orElseThrow(IllegalArgumentException::new));
            weekMenu0.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,4, 24)).orElseThrow(IllegalArgumentException::new));
            weekMenu0.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,4, 25)).orElseThrow(IllegalArgumentException::new));
            weekMenu0.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,4, 26)).orElseThrow(IllegalArgumentException::new));

            weekMenuDb.save(weekMenu0);

            WeekMenu weekMenu1 = new WeekMenu();
            dayMenu = dayMenuDb.findById(LocalDate.of(2019,4, 29)).orElseThrow(IllegalArgumentException::new);
            yearAndWeekNumber = dayMenu.getYearAndWeekNumber();
            weekMenu1.setId(yearAndWeekNumber);

            weekMenu1.addDayMenu(dayMenu);
            weekMenu1.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,4, 30)).orElseThrow(IllegalArgumentException::new));
            weekMenu1.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,5, 1)).orElseThrow(IllegalArgumentException::new));
            weekMenu1.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,5, 2)).orElseThrow(IllegalArgumentException::new));
            weekMenu1.addDayMenu(dayMenuDb.findById(LocalDate.of(2019,5, 3)).orElseThrow(IllegalArgumentException::new));

            weekMenuDb.save(weekMenu1);
        };
    }
    */

}

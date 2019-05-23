package main.model.builder;

import main.model.DayMenu;
import main.model.Meal;
import main.model.MealType;
import java.time.LocalDate;

public class DayMenuBuilder {

    private LocalDate date;
    private Meal soup, daily, veggie;

    private DayMenuBuilder(){}

    public static DayMenuBuilder dayMenu() {
        return new DayMenuBuilder();
    }

    public static DayMenuBuilder dayMenu1 () {
        Meal soup = new Meal("Tomatensoep", 1.0, MealType.SOEP);
        Meal daily = new Meal("Konijn met pruimen", 4.2, MealType.DAGSCHOTEL);
        Meal veggie = new Meal("Veggie pasta", 4.0, MealType.VEGGIE);

        return dayMenu().setDate(LocalDate.of(2019,2, 18)).setSoup(soup).setDaily(daily).setVeggie(veggie);
    }

    public static DayMenuBuilder dayMenu2 () {
        Meal soup = new Meal("Bloemkoolsoep", 1.0, MealType.SOEP);
        Meal daily = new Meal("Cordon Blue", 4.2, MealType.DAGSCHOTEL);
        Meal veggie = new Meal("Veggie pasta", 4.0, MealType.VEGGIE);
        return dayMenu().setDate(LocalDate.of(2019,2, 19)).setSoup(soup).setDaily(daily).setVeggie(veggie);
    }

    public DayMenuBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public DayMenuBuilder setSoup(Meal soup) {
        this.soup = soup;
        return this;
    }

    public DayMenuBuilder setDaily(Meal daily) {
        this.daily = daily;
        return this;
    }

    public DayMenuBuilder setVeggie(Meal veggie) {
        this.veggie = veggie;
        return this;
    }

    public DayMenu build() {
        DayMenu dayMenu = new DayMenu();
        dayMenu.setDate(LocalDate.of(2019,2, 18));
        dayMenu.setSoup(soup);
        dayMenu.setDaily(daily);
        dayMenu.setVeggie(veggie);
        return dayMenu;
    }

}

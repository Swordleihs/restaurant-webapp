package main.model;

import java.time.LocalDate;

public class DayMenuBuilder {

    private LocalDate date;
    private Meal soup, daily, veggie;

    private DayMenuBuilder(){}

    public static DayMenuBuilder dayMenu() {
        return new DayMenuBuilder();
    }

    public static DayMenuBuilder dayMenu1 () {
        return dayMenu().setDate(LocalDate.of(2019,2, 18)).setSoup(new Meal("Tomatensoep", 1, MealType.SOEP)).setDaily(new Meal("Konijn met pruimen", 4.2, MealType.DAGSCHOTEL)).setVeggie(new Meal("Groentenlasagne", 4, MealType.VEGGIE));
    }

    public static DayMenuBuilder dayMenu2 () {
        return dayMenu().setDate(LocalDate.of(2019,2, 19)).setSoup(new Meal("Bloemkoolsoep", 1, MealType.SOEP)).setDaily(new Meal("Cordon Blue", 4.2, MealType.DAGSCHOTEL)).setVeggie(new Meal("Veggie pasta", 4, MealType.VEGGIE));
    }

    private DayMenuBuilder setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    private DayMenuBuilder setSoup(Meal soup) {
        this.soup = soup;
        return this;
    }

    private DayMenuBuilder setDaily(Meal daily) {
        this.daily = daily;
        return this;
    }

    private DayMenuBuilder setVeggie(Meal veggie) {
        this.veggie = veggie;
        return this;
    }

    public DayMenu build() {
        DayMenu dayMenu = new DayMenu();
        dayMenu.setDate(this.date);
        dayMenu.setSoup(this.soup);
        dayMenu.setDaily(this.daily);
        dayMenu.setVeggie(this.veggie);
        return dayMenu;
    }

}

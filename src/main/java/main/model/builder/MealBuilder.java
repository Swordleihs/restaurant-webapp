package main.model.builder;

import main.model.Meal;
import main.model.MealType;

public class MealBuilder {

    private String name;
    private double price;
    private MealType mealType;

    private MealBuilder(){}

    public static MealBuilder meal(){
        return new MealBuilder();
    }

    public MealBuilder setName(String name){
        this.name = name;
        return this;
    }

    public MealBuilder setPrice(double price){
        this.price = price;
        return this;
    }

    public MealBuilder setMealType(MealType mealType){
        this.mealType = mealType;
        return this;
    }

    public static MealBuilder soupMeal(){
        return meal().setName("Tomatensoep").setPrice(2.5).setMealType(MealType.SOEP);
    }

    public static MealBuilder dailyMeal(){
        return meal().setName("Cordon Blue").setPrice(4.5).setMealType(MealType.DAGSCHOTEL);
    }

    public static MealBuilder veggieMeal(){
        return meal().setName("Veggie Pasta").setPrice(3.5).setMealType(MealType.VEGGIE);
    }

    public Meal build(){
        Meal meal = new Meal();
        meal.setName(this.name);
        meal.setPrice(this.price);
        meal.setMealType(this.mealType);
        return meal;
    }

}

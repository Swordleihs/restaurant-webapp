package main.model;

import javax.validation.constraints.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @NotEmpty
    @Size(min=4, max=50)
    private String name;

    @NotNull
    @DecimalMax("10.0")
    @DecimalMin("0.1")
    private double price;

    private MealType mealType;

    public Meal(){}

    public Meal(@Size(min=4, max=50) String n,@DecimalMax("10.0") @DecimalMin("0.1") double p, MealType m){
        this.name = n;
        this.price = p;
        this.mealType = m;
    }

    public void setId(int i){
        this.id = i;
    }

    public int getId(){
        return this.id;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName(){
        return this.name;
    }

    public void setPrice(double p){
        this.price = p;
    }

    public double getPrice(){
        return this.price;
    }

    public void setMealType(MealType m){
       this.mealType = m;
    }

    public MealType getMealType(){
        return this.mealType;
    }

    @Override
    public String toString(){
        return this.name + ": €" + this.price;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Meal){
            Meal m = (Meal) o;
            if(this.name.equals(m.getName()) && this.price == m.getPrice()){
                return true;
            }else return false;
        }else return false;
    }
}

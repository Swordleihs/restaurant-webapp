package main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;

@Entity
public class DayMenu {
    @Id
    @NotNull
    private LocalDate date;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Meal soup;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Meal daily;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH)
    private Meal veggie;

    private String dayName; // Monday, Tuesday
    private int dayOfWeek; //1=MONDAY 2=TUESDAY
    private int yearAndWeekNumber; // year 2019 and week 7 => 201907

    public DayMenu(){}

    public DayMenu(LocalDate date, Meal soup, Meal daily, Meal veggie){
        this.setDate(date);
        this.setSoup(soup);
        this.setDaily(daily);
        this.setVeggie(veggie);
    }

    public void setDate(LocalDate date) {
        this.date = date;
        setDayName(date.getDayOfWeek().toString());
        TemporalField weekOfWeekBasedYear = WeekFields.ISO.weekOfWeekBasedYear();
        setYearAndWeekNumber(date.getYear(), date.get(weekOfWeekBasedYear));
        weekOfWeekBasedYear = WeekFields.ISO.dayOfWeek();
        setDayOfWeek(date.get(weekOfWeekBasedYear));
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName.charAt(0) + dayName.substring(1).toLowerCase();
    }

    public String getDayName() {
        return dayName;
    }

    public void setYearAndWeekNumber(int year, int weekNumber) {
        String y = String.valueOf(year);
        String wn = String.format("%02d", weekNumber);
        this.yearAndWeekNumber = Integer.parseInt(y + wn);
    }

    public int getYearAndWeekNumber() {
        return yearAndWeekNumber;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setSoup(Meal s) {
        if(!s.getMealType().equals(MealType.SOEP)){
            throw new DomainException("Not a soup!");
        }
        this.soup = s;
    }

    public Meal getSoup(){
        return this.soup;
    }

    public void setDaily(Meal d) {
        if(!d.getMealType().equals(MealType.DAGSCHOTEL)){
            throw new DomainException("Not a daily meal!");
        }
        this.daily = d;
    }

    public Meal getDaily(){
        return this.daily;
    }

    public void setVeggie(Meal v) {
        if(!v.getMealType().equals(MealType.VEGGIE)){
            throw new DomainException("Not a veggie meal!");
        }
        this.veggie = v;
    }

    public Meal getVeggie(){
        return this.veggie;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DayMenu) {
            DayMenu dm = (DayMenu) o;
            if (this.getDate().equals(dm.getDate())) return true;
        }
        return false;
    }
}

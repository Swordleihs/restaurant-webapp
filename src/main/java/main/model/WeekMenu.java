package main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

@Entity
public class WeekMenu {
    @Id
    private int id = 0;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    @OneToMany
    @MapKeyColumn(name = "day_number")
    private Map<Integer, DayMenu> weekMenu = new HashMap<Integer, DayMenu>();

    public Map<Integer, DayMenu> getWeekMenu(){
        return this.weekMenu;
    }

    public void setWeekMenu(Map<Integer, DayMenu> wm){
        this.weekMenu = wm;
    }

    public void addDayMenu(DayMenu dm){
        this.weekMenu.put(dm.getDayOfWeek(), dm);
    }

    public void deleteDayMenu(DayMenu dm){
        this.weekMenu.remove(dm.getDayOfWeek());
    }

    public boolean weekMenuIsEmpty(){
        return weekMenu.isEmpty();
    }

    /*
    public void addMealToMenu(int day, Meal meal){
        Integer dayI = day;
        if(day < 0 || day > 6){
            throw new DomainException();
        }else if(meal == null){
            throw new DomainException("invalid meal");
        }
        if(this.weekmenu.get(dayI)==null)
            throw new DomainException("this day does not have a daymenu ");

        DayMenu dm = this.weekmenu.get(dayI);
        dm.setMeal(meal);
        this.weekmenu.replace(dayI, dm);
    }*/
 }

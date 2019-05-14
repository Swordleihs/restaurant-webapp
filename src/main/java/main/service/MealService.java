package main.service;

import main.db.DayMenuDb;
import main.db.MealDb;
import main.db.WeekMenuDb;
import main.model.DayMenu;
import main.model.Meal;
import main.model.WeekMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    MealDb mealDb;

    @Autowired
    DayMenuDb dayMenuDb;

    @Autowired
    WeekMenuDb weekMenuDb;

    public MealService(){}

    //WEEKMENU -------------------------------------------------

    public List<WeekMenu> getWeekMenus(){
        return this.weekMenuDb.findAll();
    }

    public Optional<WeekMenu> getWeekMenuById(int id){
        return weekMenuDb.findById(id);
    }

    //DAYMENU --------------------------------------------------

    public List<DayMenu> getDayMenus(){
        return this.dayMenuDb.findAll();
    }

    public void addDayMenu(DayMenu dm){
        commitToDatabase(dm);

        int weekMenuId = dm.getYearAndWeekNumber();
        WeekMenu wm = weekMenuDb.findById(weekMenuId).orElse(new WeekMenu());

        if(wm.getId() == 0){
            wm.setId(weekMenuId);
            Map<Integer, DayMenu> weekMenuMap = new HashMap<Integer, DayMenu>();
            weekMenuMap.put(dm.getDayOfWeek(), dm);
            wm.setWeekMenu(weekMenuMap);
        }
        else {
            wm.addDayMenu(dm);
        }
        weekMenuDb.save(wm);
    }

    private void commitToDatabase(DayMenu dm) {
        addMeal(dm.getSoup());
        addMeal(dm.getDaily());
        addMeal(dm.getVeggie());
        dayMenuDb.save(dm);
    }

    public void changeDayMenu(LocalDate date, DayMenu changedDayMenu) {
        changedDayMenu.setDate(date);
        DayMenu previousVersionOfDayMenu = dayMenuDb.findById(date).orElseThrow(IllegalArgumentException::new);
        changedDayMenu.setDayName(previousVersionOfDayMenu.getDayName());
        commitToDatabase(changedDayMenu);
    }

    public void deleteDayMenu(LocalDate date) {
        DayMenu dm = dayMenuDb.findById(date).orElseThrow(IllegalArgumentException::new);
        int weekMenuId = dm.getYearAndWeekNumber();
        WeekMenu wm = weekMenuDb.findById(weekMenuId).orElseThrow(IllegalArgumentException::new);
        wm.deleteDayMenu(dm);
        if(wm.weekMenuIsEmpty()){
            weekMenuDb.delete(wm);
        }
        else {
            weekMenuDb.save(wm);
        }
        dayMenuDb.deleteById(date);
    }

    //MEAL -----------------------------------------------------

    public List<Meal> getAllMeals(){
        return this.mealDb.findAll();
    }

    public Meal findMealByName(String name){
        return mealDb.findByName(name);
    }

    public Meal addMeal(Meal meal){
        Meal mealToAdd = mealDb.findByName(meal.getName());
        if(mealToAdd != null){
            meal.setId(mealToAdd.getId());
        }
        return mealDb.save(meal);
    }

    public void deleteMeal(Meal meal){
        mealDb.delete(meal);
    }

    public void updateMeal(Meal meal){
        mealDb.save(meal);
    }
}

package main.service;

import main.db.MealDb;
import main.model.DayMenu;
import main.model.Meal;
import main.model.MealType;
import main.model.WeekMenu;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MealServiceTest {

    private MealService service;
    private Meal m0,m1,m2,m3,m4,m5,m6;
    private DayMenu dm0,dm1,dm2,dm3,dm4,dm5,dm6,dm7,dm8,dm9;
    private WeekMenu weekMenu0, weekMenu1;

    @Before
    public void setUp() throws Exception {
        service = new MealService();

        m0 = new Meal("Bloemkoolsoep", 1, MealType.SOEP);
         m1 = new Meal("Tomatensoep", 1, MealType.SOEP);
         m2 = new Meal("Pompoensoep", 1, MealType.SOEP);
         m3 = new Meal("Cordon Blue", 4.2, MealType.DAGSCHOTEL);
         m4 = new Meal("Konijn met Pruimen", 4.2, MealType.DAGSCHOTEL);
         m5 = new Meal("Groentenlasagne", 4, MealType.VEGGIE);
         m6 = new Meal("Veggie Pasta", 4, MealType.VEGGIE);

         dm0 = new DayMenu(LocalDate.of(2019,4, 22), m0, m3, m5);
         dm1 = new DayMenu(LocalDate.of(2019,4, 23), m0, m3, m6);
         dm2 = new DayMenu(LocalDate.of(2019,4, 24),m0, m4, m5);
         dm3 = new DayMenu(LocalDate.of(2019,4, 25),m0,m4,m6);
         dm4 = new DayMenu(LocalDate.of(2019,4, 26),m1,m3,m5);
         dm5 = new DayMenu(LocalDate.of(2019,4, 29),m1,m3,m6);
         dm6 = new DayMenu(LocalDate.of(2019,4, 30),m1,m4,m5);
         dm7 = new DayMenu(LocalDate.of(2019,5, 1),m2,m3,m5);
         dm8 = new DayMenu(LocalDate.of(2019,5, 2),m2,m3,m6);
         dm9 = new DayMenu(LocalDate.of(2019,5, 3),m2,m4,m5);

         weekMenu0 = new WeekMenu();
        int yearAndWeekNumber = dm0.getYearAndWeekNumber();
        weekMenu0.setId(yearAndWeekNumber);

        weekMenu0.addDayMenu(dm0);
        weekMenu0.addDayMenu(dm1);
        weekMenu0.addDayMenu(dm2);
        weekMenu0.addDayMenu(dm3);
        weekMenu0.addDayMenu(dm4);

         weekMenu1 = new WeekMenu();
        yearAndWeekNumber = dm5.getYearAndWeekNumber();
        weekMenu1.setId(yearAndWeekNumber);

        weekMenu1.addDayMenu(dm5);
        weekMenu1.addDayMenu(dm6);
        weekMenu1.addDayMenu(dm7);
        weekMenu1.addDayMenu(dm8);
        weekMenu1.addDayMenu(dm9);

    }

    @Test
    public void test_Get_Week_Menus(){
        List<WeekMenu> weekmenus = this.service.getWeekMenus();
        List<WeekMenu> weekmenusGiven = new ArrayList<>();
        assertNotEquals(weekmenus, weekmenusGiven);
    }

    @Test
    public void test_Get_Week_Menus_By_Id(){
        
    }

    @After
    public void tearDown() throws Exception {
    }
}
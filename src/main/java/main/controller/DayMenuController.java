package main.controller;

import main.model.DayMenu;
import main.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class DayMenuController {
    @Autowired
    private MealService dayMenuService;

    @GetMapping("/dagmenu")
    public List<DayMenu> getDayMenus(){
        return dayMenuService.getDayMenus();
    }

    @GetMapping("/dagmenu/{date}")
    public DayMenu getDayMenuById(@PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd][dd-MM-yyyy][dd/MM/yyyy]");
        LocalDate dateFromUrl = LocalDate.parse(date, formatter);
        return dayMenuService.getDayMenuById(dateFromUrl).orElseThrow(IllegalArgumentException::new);
    }

    @PostMapping("/dagmenu/add")
    public List<DayMenu> addDayMenu(@RequestBody @Valid DayMenu dayMenu){
        dayMenuService.addDayMenu(dayMenu);
        return dayMenuService.getDayMenus();
    }

    @PatchMapping("/dagmenu/change/{date}")
    public List<DayMenu> changeDayMenu(@RequestBody @Valid DayMenu dm, @PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd][dd-MM-yyyy][dd/MM/yyyy]");
        LocalDate dateFromUrl = LocalDate.parse(date, formatter);
        dayMenuService.changeDayMenu(dateFromUrl, dm);
        return dayMenuService.getDayMenus();
    }

    @DeleteMapping("/dagmenu/delete/{date}")
    public void deleteDayMenu(@PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy/MM/dd][dd-MM-yyyy][dd/MM/yyyy]");
        LocalDate dateFromUrl = LocalDate.parse(date, formatter);
        dayMenuService.deleteDayMenu(dateFromUrl);
    }
}

package main.controller;

import main.model.Meal;
import main.model.MealType;
import main.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@Configuration
public class MealController implements WebMvcConfigurer {

    @Autowired
    private MealService mealService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        return "login";
    }

    @GetMapping("/gerechten")
    public String getMeals(Model model){
        model.addAttribute("meals", mealService.getAllMeals());
        return "gerechten";
    }

    @GetMapping("/gerechten/add")
    public String addMealPage(Model model){
        model.addAttribute("mealTypes", MealType.values());
        return "addGerecht";
    }

    @PostMapping("/gerechten/add")
    public String addMeal(@Valid Meal meal , BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("mealTypes", MealType.values());
            return "addGerecht";
        }
        else {
            mealService.addMeal(meal);
            model.addAttribute("meals", mealService.getAllMeals());
            return "gerechten";
        }
    }

    @GetMapping(value="/gerechten/delete", params={"name"})
    public String deleteMealPage(Model model, @RequestParam(value="name") String name){
        Meal meal = mealService.findMealByName(name);
        model.addAttribute("meal", meal);
        return "verwijderGerecht";
    }

    @GetMapping(value="/gerechten/confirmdelete", params={"beschrijving"})
    public String deleteMealConfirmation(@RequestParam(value="beschrijving") String name, Model model){
        Meal meal = mealService.findMealByName(name);
        System.out.println("meal=" + meal.getId());
        mealService.deleteMeal(meal);
        model.addAttribute("meals", mealService.getAllMeals());
        return "gerechten";
    }

    @GetMapping("gerechten/change")
    public String changeMealPage(Model model){
        model.addAttribute("meals", mealService.getAllMeals());
        return "veranderGerechten";
    }

    @GetMapping(value="/gerechten/update", params={"name"})
    public String updateMealPage(Model model, @RequestParam(value="name") String name){
        Meal meal = mealService.findMealByName(name);
        model.addAttribute("meal", meal);
        model.addAttribute("mealTypes", MealType.values());
        return "updateGerecht";
    }

    @PostMapping("/gerechten/update")
    public String updateMeal(Model model, @Valid Meal meal, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getFieldErrors());
            model.addAttribute("mealTypes", MealType.values());
            return "updateGerecht";
        } else {
            mealService.updateMeal(meal);
            model.addAttribute("meals", mealService.getAllMeals());
            return "gerechten";
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="Requested ID not found!")
    @ExceptionHandler(value = IllegalArgumentException.class)
    public void badIdExceptionHandler(){}

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}

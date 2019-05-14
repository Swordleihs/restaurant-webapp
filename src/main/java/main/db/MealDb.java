package main.db;

import main.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealDb extends JpaRepository<Meal, Integer> {
    Meal findByName(String name);
    //void deleteByName(String name);
}

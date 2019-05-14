package main.db;

import main.model.WeekMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WeekMenuDb extends JpaRepository<WeekMenu, Integer>{}

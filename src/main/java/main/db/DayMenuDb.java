package main.db;

import main.model.DayMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DayMenuDb extends JpaRepository<DayMenu, LocalDate> {
}

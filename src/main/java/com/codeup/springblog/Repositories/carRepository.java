package com.codeup.springblog.Repositories;
import com.codeup.springblog.models.car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepository extends JpaRepository<car, Long> {

}

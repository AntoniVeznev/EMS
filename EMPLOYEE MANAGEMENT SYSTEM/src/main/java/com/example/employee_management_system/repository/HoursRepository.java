package com.example.employee_management_system.repository;

import com.example.employee_management_system.model.entity.Hours;
import com.example.employee_management_system.model.entity.enums.HoursNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoursRepository extends JpaRepository<Hours, Long> {
    Hours findHoursByHours(HoursNameEnum hours);
}

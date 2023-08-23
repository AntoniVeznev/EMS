package com.example.employee_management_system.model.entity;

import com.example.employee_management_system.model.entity.enums.PositionNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "positions")
public class Position extends BaseEntity {
    private PositionNameEnum position;

    public Position() {
    }

    @Enumerated(EnumType.STRING)
    public PositionNameEnum getPosition() {
        return position;
    }

    public Position setPosition(PositionNameEnum position) {
        this.position = position;
        return this;
    }
}

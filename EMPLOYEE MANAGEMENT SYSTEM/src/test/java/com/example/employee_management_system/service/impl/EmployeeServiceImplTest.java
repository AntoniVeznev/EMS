package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.*;
import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import com.example.employee_management_system.model.entity.enums.PositionNameEnum;
import com.example.employee_management_system.model.view.EmployeeViewModel;
import com.example.employee_management_system.repository.*;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    private static final String BOSS_USERNAME = "Boss";
    private static final String MODERATOR_USERNAME = "Moderator";
    private static final String USER_USERNAME = "User";
    private EmployeeServiceImpl serviceToTest;
    @Mock
    private EmployeeRepository mockEmployeeRepository;
    @Mock
    private UserRepository mockUserRepository;
    @Mock
    private PositionRepository mockPositionRepository;
    @Mock
    private DepartmentRepository mockDepartmentRepository;
    @Mock
    private LocationRepository mockLocationRepository;
    @Mock
    private AddressRepository mockAddressRepository;
    @Mock
    private ModelMapper mockModelMapper;

    @BeforeEach
    void setup() {
        serviceToTest = new EmployeeServiceImpl(
                mockEmployeeRepository, mockUserRepository, mockPositionRepository,
                mockDepartmentRepository, mockLocationRepository, mockAddressRepository,
                mockModelMapper);

    }

    @Test
    void testInitBossModeratorAndEmployee() {

        Location testLocation1 = createLocationMethod(LocationNameEnum.USA, 1L);
        User testUser1 = createUserMethod(BOSS_USERNAME);
        Position testPosition1 = createPositionMethod(PositionNameEnum.CEO);
        Department testDepartment1 = createDepartmentMethod(DepartmentNameEnum.EXECUTIVE);

        Location testLocation2 = createLocationMethod(LocationNameEnum.CANADA, 2L);
        User testUser2 = createUserMethod(MODERATOR_USERNAME);
        Position testPosition2 = createPositionMethod(PositionNameEnum.ADMIN_MANAGER);
        Department testDepartment2 = createDepartmentMethod(DepartmentNameEnum.ADMINISTRATION);

        Location testLocation3 = createLocationMethod(LocationNameEnum.BULGARIA, 3L);
        User testUser3 = createUserMethod(USER_USERNAME);
        Position testPosition3 = createPositionMethod(PositionNameEnum.CTO);
        Department testDepartment3 = createDepartmentMethod(DepartmentNameEnum.PRODUCT_MARKETING);

        when(mockEmployeeRepository.count()).thenReturn(0L);

        when(mockLocationRepository.findById(1L)).thenReturn(Optional.of(testLocation1));
        when(mockUserRepository.findUserByUsername(testUser1.getUsername())).thenReturn(Optional.of(testUser1));
        when(mockPositionRepository.findById(1L)).thenReturn(Optional.of(testPosition1));
        when(mockDepartmentRepository.findById(1L)).thenReturn(Optional.of(testDepartment1));

        when(mockLocationRepository.findById(2L)).thenReturn(Optional.of(testLocation2));
        when(mockUserRepository.findUserByUsername(testUser2.getUsername())).thenReturn(Optional.of(testUser2));
        when(mockPositionRepository.findById(2L)).thenReturn(Optional.of(testPosition2));
        when(mockDepartmentRepository.findById(2L)).thenReturn(Optional.of(testDepartment2));

        when(mockLocationRepository.findById(3L)).thenReturn(Optional.of(testLocation3));
        when(mockUserRepository.findUserByUsername(testUser3.getUsername())).thenReturn(Optional.of(testUser3));
        when(mockPositionRepository.findById(9L)).thenReturn(Optional.of(testPosition3));
        when(mockDepartmentRepository.findById(5L)).thenReturn(Optional.of(testDepartment3));

        serviceToTest.initEmployee();

    }

    @Test
    void testCantFindEmployeeWithGivenID() {
        Assertions
                .assertThrows(NoSuchElementException.class,
                        ()-> serviceToTest.findEmployeeWithID(5L));
    }


    private Department createDepartmentMethod(DepartmentNameEnum name) {
        Department testDepartment = new Department();
        testDepartment.setDepartment(name);
        return testDepartment;

    }

    private Position createPositionMethod(PositionNameEnum name) {
        Position testPosition = new Position();
        testPosition.setPosition(name);
        return testPosition;

    }

    private User createUserMethod(String name) {
        User testUser = new User();
        testUser.setUsername(name);
        return testUser;

    }

    private Location createLocationMethod(LocationNameEnum name, Long id) {
        Location testLocation = new Location();
        testLocation
                .setLocation(name)
                .setId(id);
        return testLocation;

    }
}

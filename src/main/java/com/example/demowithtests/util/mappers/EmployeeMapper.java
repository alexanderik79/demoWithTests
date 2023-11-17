package com.example.demowithtests.util.mappers;

import com.example.demowithtests.domain.Employee;
import com.example.demowithtests.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);
    EmployeeDeleteDto toEmployeeDeleteDto(Employee employee);

    EmployeeUnDeleteDto toEmployeeUnDeleteDto(Employee employee);
    EmployeeRefreshNameDto toEmployeeRefreshNameDto(Employee employee);
    EmployeeReadDto toEmployeeReadDto(Employee employee);

    List<EmployeeDto> toListEmployeeDto(List<Employee> employees);

    Employee toEmployee(EmployeeDto employeeDto);
}
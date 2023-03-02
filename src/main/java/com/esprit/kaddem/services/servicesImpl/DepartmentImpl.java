package com.esprit.kaddem.services.servicesImpl;

import com.esprit.kaddem.entities.Department;
import com.esprit.kaddem.repositories.DepartmentRepository;
import com.esprit.kaddem.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentImpl implements DepartmentService {


    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> retrieveAllDepartements() {
        return departmentRepository.findAll();
    }

    @Override
    public Department addDepartement(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department updateDepartement(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Optional<Department> retrieveDepartement(Integer idDepart) {
        return departmentRepository.findById(idDepart);
    }
}

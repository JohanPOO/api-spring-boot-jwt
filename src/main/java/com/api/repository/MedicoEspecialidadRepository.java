package com.api.repository;

import com.api.entity.MedicoEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoEspecialidadRepository extends JpaRepository<MedicoEspecialidad, Long> {

    MedicoEspecialidad findByEmpleado_IdAndEspecialidad_Id(Long empleado_id, Long especialidad_id);

}

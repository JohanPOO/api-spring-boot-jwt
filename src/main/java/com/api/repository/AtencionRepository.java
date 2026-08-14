package com.api.repository;

import com.api.entity.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    @Query(value = "Select a.id, a.fecha, a.motivo, a.estado, a.paciente_id, a.empleado_id  from atencion a inner join paciente p on a.paciente_id  = p.id inner join persona pe on p.persona_id = pe.id \n" +
            "inner join usuario u on pe.id = u.persona_id Where u.usuario = :usuario", nativeQuery = true)
    List<Atencion> findByMias(String usuario);

    List<Atencion> findByFecha(LocalDate fecha);

    @Query(value = "select a.id, a.fecha, a.motivo, a.estado, a.paciente_id, a.empleado_id from atencion a inner join  empleado e on a.empleado_id = e.id inner join persona p on p.id = e.persona_id where p.nombre = :nombre", nativeQuery = true)
    List<Atencion> findByMedico(String nombre);

}

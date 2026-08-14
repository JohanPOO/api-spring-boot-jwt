package com.api.repository;

import com.api.entity.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Long> {

    @Query(value = "Select a.id, a.fecha, a.motivo, a.estado, a.paciente_id, a.empleado_id  from atencion a inner join paciente p on a.paciente_id  = p.id inner join persona pe on p.persona_id = pe.id \n" +
            "inner join usuario u on pe.id = u.persona_id Where u.usuario = :usuario", nativeQuery = true)
    List<Atencion> findByMias(String usuario);

}

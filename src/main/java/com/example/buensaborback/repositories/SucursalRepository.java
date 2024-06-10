package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.domain.entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SucursalRepository extends BaseRepository<Sucursal,Long> {
}

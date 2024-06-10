package com.example.buensaborback.repositories;


import com.example.buensaborback.domain.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {
}

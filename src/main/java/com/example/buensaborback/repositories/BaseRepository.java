package com.example.buensaborback.repositories;


import com.example.buensaborback.domain.entities.Base;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseRepository <E extends Base, ID extends Serializable> extends JpaRepository<E, ID> {
}

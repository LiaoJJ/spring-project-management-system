package com.example.pma.dao;

import com.example.pma.dto.StageCount;
import com.example.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT stage as stageName, count(*) as stageCount " +
            "from project " +
            "group by stage " +
            "order by 2 desc ")
    public List<StageCount> stageCount();
}

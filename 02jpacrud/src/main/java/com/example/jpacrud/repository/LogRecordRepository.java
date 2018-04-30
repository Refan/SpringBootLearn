package com.example.jpacrud.repository;

import com.example.jpacrud.model.LogRecordModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogRecordRepository extends JpaRepository<LogRecordModel,Integer>,JpaSpecificationExecutor<LogRecordModel> {

    //搜尋
    @Query(value = "SELECT lr.* FROM logRecord AS lr WHERE lr.action=?1",nativeQuery = true)
    List<LogRecordModel> getLogRecordBySql(String action);

}

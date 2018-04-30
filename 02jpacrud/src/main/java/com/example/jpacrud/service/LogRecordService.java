package com.example.jpacrud.service;

import com.example.jpacrud.model.LogRecordModel;
import com.example.jpacrud.repository.LogRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogRecordService {

    @Autowired
    private LogRecordRepository logRecordRepository;

    //新增
    public Integer addData(LogRecordModel logRecordModel) {
        logRecordRepository.save(logRecordModel);
        logRecordRepository.flush();
        return logRecordModel.getId();
    }

    //修改用
    public LogRecordModel getDataModel(Integer id){
        return logRecordRepository.getOne(id);
    }
    public LogRecordModel updateData(LogRecordModel logRecordModel){
        return logRecordRepository.save(logRecordModel);
    }

    //刪除
    public void delData(Integer id){
        logRecordRepository.delete(id);
    }

    //搜尋
    public List<LogRecordModel> getData(String tables, String action, String creater) {
        return logRecordRepository.findAll(filterByData(tables,action,creater));
    }
    public static Specification<LogRecordModel> filterByData(final String tables, final String action, final String creater) {
        return (Root<LogRecordModel> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<Predicate>();
            if (StringUtils.hasText(tables)) {
                predicates.add(cb.or(cb.equal(root.get("tables"), tables )));
            }
            if (StringUtils.hasText(action)) {
                predicates.add(cb.or(cb.equal(root.get("action"), action )));
            }
            if (StringUtils.hasText(creater)) {
                predicates.add(cb.or(cb.equal(root.get("creater"), creater )));
            }
            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    //以下為SQL的方式
    public List<LogRecordModel> getDataSql(String action) {
        return logRecordRepository.getLogRecordBySql(action);
    }
}

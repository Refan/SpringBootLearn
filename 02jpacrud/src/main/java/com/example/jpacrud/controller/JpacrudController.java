package com.example.jpacrud.controller;

import com.example.jpacrud.model.LogRecordModel;
import com.example.jpacrud.service.LogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/jpacrud")
public class JpacrudController {

    @Autowired
    private LogRecordService logRecordService;

    @RequestMapping("/create")
    @ResponseBody
    public String testCreate(){
        LogRecordModel logRecordModel = new LogRecordModel();
        logRecordModel.setTables("val");
        logRecordModel.setAction("val");
        logRecordModel.setValueBefore("val");
        logRecordModel.setValueAfter("val");
        logRecordModel.setCreater("val");
        logRecordModel.setCreateDate("val");
        Integer id = logRecordService.addData(logRecordModel);

        return "新增資料的ID為："+id;
    }

    @RequestMapping("/read")
    @ResponseBody
    public String testRead(){
        //全空值則為所有資料
        String table = "";
        String action = "S";
        String creater = "M000000014731";

        List<LogRecordModel> list = logRecordService.getData(table,action,creater);

        //取第一筆資料的ValueBefore欄位
        String valueBefore = list.get(0).getValueBefore();

        return valueBefore;
    }

    @RequestMapping("/readone")
    @ResponseBody
    public String testReadOne(@RequestParam(name = "id") Integer id){
        LogRecordModel logRecordModel = logRecordService.getDataModel(id);
        return logRecordModel.getCreater()+" : "+logRecordModel.getCreateDate();
    }

    @RequestMapping("/update")
    @ResponseBody
    public String testUpdate(){
        LogRecordModel logRecordModel = logRecordService.getDataModel(8987);
        logRecordModel.setCreater("tttt");
        logRecordModel.setCreateDate("tttt");
        logRecordService.updateData(logRecordModel);

        return "success ：<br/>"+logRecordModel.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String testDelete(@PathVariable(name = "id") Integer id){
        logRecordService.delData(id);

        return "Success";
    }

    //Sql讀取
    @RequestMapping("/readsql")
    public @ResponseBody String testReadSql() {

        //全空值則為所有資料
        String action = "S";

        List<LogRecordModel> list = logRecordService.getDataSql(action);

        //取第一筆資料的ValueBefore欄位
        String valueBefore = list.get(0).getValueBefore();

        return valueBefore;
    }

}

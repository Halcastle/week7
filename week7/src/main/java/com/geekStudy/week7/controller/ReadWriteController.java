package com.geekStudy.week7.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.geekStudy.week7.service.ReadWriteService;

@RestController()
public class ReadWriteController {
    private final static Logger logger = LoggerFactory.getLogger(ReadWriteController.class);


    @Autowired
    ReadWriteService readWriteService;


    @RequestMapping(value = "/dynamicread",method = RequestMethod.GET)
    public void dynamicread(){
        readWriteService.masterRead("1");
        readWriteService.slave1Read("1");
        readWriteService.slave2Read("1");
        readWriteService.slave3Read("1");
    }

    @RequestMapping(value = "/dynamicwrite",method = RequestMethod.GET)
    public void dynamicwrite(){
        readWriteService.masterInsert();
        readWriteService.slave1Insert();
        readWriteService.slave2Insert();
        readWriteService.slave3Insert();
    }

    @RequestMapping(value = "/dynamicupdate",method = RequestMethod.GET)
    public void dynamicupdate(){
        readWriteService.masterUpdate();
        readWriteService.slave1Update();
        readWriteService.slave2Update();
        readWriteService.slave3Update();
    }

}


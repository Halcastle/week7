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


    @RequestMapping(value = "/dynamicreadwrite",method = RequestMethod.GET)
    public void dynamicreadwrite(){
        readWriteService.masterRead("1");
        readWriteService.slave1Read("2");
        readWriteService.slave2Read("3");
        readWriteService.slave3Read("4");
    }

}


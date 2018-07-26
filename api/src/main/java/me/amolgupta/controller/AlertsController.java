package me.amolgupta.controller;

import me.amolgupta.entity.Alerts;
import me.amolgupta.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value = "/alerts")
public class AlertsController {

    @Autowired
    AlertsService alertsService;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findAll(){
        return alertsService.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findByVIN(@PathVariable("vin") String vin){

        System.out.println("VIN --> "+vin);
        List<Alerts> list = alertsService.findByVIN(vin);

        System.out.println(list.get(0));

        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/highAlert",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Alerts> findByHighAlerts(){
        System.out.println(" --> In Alerts controller ");
        return alertsService.findByHighAlerts();

    }


}

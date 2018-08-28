package controllers;


import db.Seeds;
import models.Area;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

    public static void main(String[] args) {
        Seeds.seedData();
        staticFileLocation("/public");

        setupEndPoints();


        CustomersController customersController = new CustomersController();
        FlowersController flowersController = new FlowersController();
        HotelsController hotelsController = new HotelsController();

    }


    public static void setupEndPoints() {
        get("/", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    Area bulgaria = Area.BULGARIA;
                    Area greece = Area.GREECE;
                    Area scotland = Area.SCOTLAND;
                    Area japan = Area.JAPAN;
                    Area hungary = Area.HUNGARY;
                    Area australia = Area.AUSTRALIA;
                    Area ecuador = Area.ECUADOR;


                    model.put("bulgaria", bulgaria);
                    model.put("greece", greece);
                    model.put("scotland", scotland);
                    model.put("japan", japan);
                    model.put("hungary", hungary);
                    model.put("australia", australia);
                    model.put("ecuador", ecuador);
                    model.put("template", "templates/index.vtl");

                    return new ModelAndView(model, "templates/layout.vtl");
                }, new VelocityTemplateEngine()
        );


    }
}
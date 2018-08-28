package controllers;


import db.Seeds;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;
import  static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

public static void main(String[]args){
        Seeds.seedData();
    staticFileLocation("/public");

    setupEndPoints();


        CustomersController customersController = new CustomersController();
        FlowersController flowersController = new FlowersController();
        HotelsController hotelsController = new HotelsController();

        }




    public static void setupEndPoints () {
        get("/", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    model.put("template", "templates/index.vtl");
                    return new ModelAndView(model, "templates/layout.vtl");
                }, new VelocityTemplateEngine()
        );

    }}
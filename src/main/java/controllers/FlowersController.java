package controllers;

import db.DBHelper;
import models.Flower;
import models.Hotel;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class FlowersController {

    public FlowersController() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        get("/flowers", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/flowers/index.vtl");
            List<Flower> flowers = DBHelper.getAll(Flower.class);
            model.put("flowers", flowers);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/flowers/new", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/flowers/create.vtl");

            List<Flower> flowers = DBHelper.getAll(Flower.class);
            model.put("flowers", flowers);


            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/flowers", (req, res) -> {
            int flowerId = Integer.parseInt(req.queryParams("flower"));
            Flower flower = DBHelper.find(Flower.class, flowerId);
            String name = req.queryParams("name");
            String type = req.queryParams("type");
            String area = req.queryParams("area");
            int points = Integer.parseInt(req.queryParams("points"));
            Flower flower1 = new Flower(name, type, null, points);
            DBHelper.save(flower);
            res.redirect("/flowers");
            return null;
        }, new VelocityTemplateEngine());


    }
}
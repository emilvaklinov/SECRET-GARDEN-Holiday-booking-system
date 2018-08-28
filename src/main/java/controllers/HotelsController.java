package controllers;

import db.DBHelper;
import models.Hotel;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class HotelsController {

    public HotelsController() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        get("/hotels", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/hotels/index.vtl");
            List<Hotel> hotels = DBHelper.getAll(Hotel.class);
            model.put("hotels", hotels);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/hotels/new", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/hotels/create.vtl");

            List<Hotel> hotels = DBHelper.getAll(Hotel.class);
            model.put("hotels", hotels);


            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());



        post("/hotels", (req, res) -> {
            String name = req.queryParams("name");
            String area = req.queryParams("area");
            double price = Integer.parseInt(req.queryParams("price"));
            int points = Integer.parseInt(req.queryParams("points"));
            Hotel hotel1 = new Hotel(name, null, price, points);
            DBHelper.save(hotel1);
            res.redirect("/hotels");
            return null;
        }, new VelocityTemplateEngine());


        // # edit
//        get '/className/:id/edit'

        get("/hotels/:id/edit", (req, res) -> {

                    //create the model
                    Map<String, Object> model = new HashMap<>();
                    model.put("template", "templates/hotels/edit.vtl");

                    int hotelId = Integer.parseInt(req.params(":id"));
                    Hotel hotel1 = DBHelper.find(Hotel.class, hotelId);
                    model.put("hotel", hotel1);

                    return new ModelAndView(model, "templates/layout.vtl");

                }, new VelocityTemplateEngine()
        );


        //        # update
//        post '/className/:id'


        post("/hotels/:id", (req, res) -> {

                    int hotelId = Integer.parseInt(req.params(":id"));
                    Hotel hotel = DBHelper.find(Hotel.class, hotelId);

                    String name = req.queryParams("name");
//                    String area = req.queryParams("area");
//                    Hotel hotel1 = DBHelper.update(Hotel.class, hotel);


                    hotel.setName(name);
//                    hotel.setArea(area);

                    DBHelper.update(hotel);
                    res.redirect("/hotels");
                    return null;
                }
        );

        //        # destroy
//        get '/className/:id/delete'

        post("/hotels/:id/delete", (req, res) -> {
            int hotelId = Integer.parseInt(req.params(":id"));
            Hotel hotel = DBHelper.find(Hotel.class, hotelId);
            DBHelper.delete(hotel);
            res.redirect("/hotels");
            return null;
        });

    }
}


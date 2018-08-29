package controllers;

import db.DBHelper;
import db.DBHotel;
import models.Area;
import models.Customer;
import models.Hotel;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.route.HttpMethod.get;

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

        post("/hotels/area", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String area = req.queryParams("areaSelect");

            List<Hotel> hotel = DBHotel.getHotelByArea(Area.valueOf(area));


            model.put("template", "templates/hotels/index.vtl");
            List<Hotel> hotels = DBHelper.getAll(Hotel.class);
            model.put("hotels", hotels);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/hotels/:id/booking", (req, res) -> {

                    //create the model
                    Map<String, Object> model = new HashMap<>();
                    model.put("template", "templates/hotels/booking.vtl");

                    // Do query to get list of customers (get all of them)
                    List<Customer> customers = DBHelper.getAll(Customer.class);


                    int hotelId = Integer.parseInt(req.params(":id"));
                    Hotel hotel1 = DBHelper.find(Hotel.class, hotelId);
                    model.put("hotel", hotel1);
                    model.put("customers", customers);
                    // Pass list of customers into model with put on the name 'customers'

                    return new ModelAndView(model, "templates/layout.vtl");

                }, new VelocityTemplateEngine()
        );

        post("/hotels/booking", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String area = req.queryParams("customerBooking");

            List<Customer> customers = DBHelper.getAll(Customer.class);


            model.put("template", "templates/customers/index.vtl");
            List<Customer> customers1 = DBHelper.getAll(Customer.class);
            model.put("customers", customers);

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

            //query to find all hotels in the area

            //view that shows all hotels in an area

//            /area/1

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

                    String name = req.queryParams("customer");
//                    // Use the name to do a query to get customer by name
//                    Customer customer1 = DBHelper.find(Customer.class, customerId);
//                    // now have customer object !!
//                    int money = Integer.parseInt(req.queryParams("money"));
//                    int points = Integer.parseInt(req.queryParams("points"));
//                    // Apply discount and book hotel




                    // update customer

//                    customer1.setPoints(points);
//                    customer1.setMoney(money);
//
//                    String area = req.queryParams("area");
//                    Hotel hotel1 = DBHelper.update(Hotel.class, hotel);


//                    hotel.setName(name);
//                    hotel.setArea(area);

                    DBHelper.update(hotel);
                    res.redirect("/hotels");
                    return null;
                }
        );

//        # show

        get("hotels/id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/hotels/index.vtl");
            List<Hotel> hotels = DBHelper.getAll(Hotel.class);
            model.put("hotels", hotels);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


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


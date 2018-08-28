package controllers;

import db.DBHelper;
import models.Customer;
import models.Hotel;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class CustomersController {

    public CustomersController() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        get("/customers", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/customers/index.vtl");
            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("customers", customers);

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        get("/customers/new", (req, res) -> {

            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/customers/create.vtl");

            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("customers", customers);


            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        post("/customers", (req, res) -> {
            String firstName = req.queryParams("first_name");
            String lastName = req.queryParams("last_name");

            Customer customer1 = new Customer(firstName, lastName);
            DBHelper.save(customer1);
            res.redirect("/customers");
            return null;
        });


        // # edit
//        get '/className/:id/edit'

        get("/customers/:id/edit", (req, res) -> {


                    int customerId = Integer.parseInt(req.params(":id"));
                    Customer customer = DBHelper.find(Customer.class, customerId);

                    Map<String, Object> model = new HashMap<>();

                    model.put("customer", customer);
                    model.put("template", "templates/customers/edit.vtl");


                    return new ModelAndView(model, "templates/layout.vtl");

                }, new VelocityTemplateEngine()
        );


        //        # update
//        post '/className/:id'


        post("/customers/:id", (req, res) -> {

                    //get the customer to update from the db
                    int customerId = Integer.parseInt(req.params(":id"));
                    Customer customer = DBHelper.find(Customer.class, customerId);

                    //get the new values of the customer properties from req.params()
                    String firstName = req.queryParams("firstName");
                    String lastName = req.queryParams("lastName");

                    //update customer model with new values of properties
                    customer.setFirstName(firstName);
                    customer.setLastName(lastName);

                    //update the customer in the db and redirect to the customers page
                    DBHelper.update(customer);
                    res.redirect("/customers");
                    return null;
                }
        );

        //        # destroy
//        get '/className/:id/delete'

        post("/customers/:id/delete", (req, res) -> {
            int customerId = Integer.parseInt(req.params(":id"));
            Customer customer = DBHelper.find(Customer.class, customerId);
            DBHelper.delete(customer);
            res.redirect("/customers");
            return null;
        });

    }
}

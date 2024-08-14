package com.flipkart.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.restcontroller.*;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/*
 * App class extending Application class to register the API RestControllers
 */
public class App extends Application<Configuration>
{
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
	 
	@Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
	@Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        
        //Registering User REST API
        e.jersey().register(new UserRestAPI());
        
        //Registering Student REST API
        e.jersey().register(new StudentRestAPI());
        
        //Registering Professor REST API
        e.jersey().register(new ProfessorRestAPI());
        
        //Registering Admin REST API
        e.jersey().register(new AdminRestAPI());
    }
    public static void main( String[] args ) throws Exception
    {
    	new App().run(args);
    }
}
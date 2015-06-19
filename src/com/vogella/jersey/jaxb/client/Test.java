package com.vogella.jersey.jaxb.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Test {

  public static void main(String[] args) {

/*** Old API

    ClientConfig config = new DefaultClientConfig();
    Client client = Client.create(config);
    WebResource service = client.resource(getBaseURI());
    // Get XML
    System.out.println(service.path("rest").path("todo").accept(MediaType.TEXT_XML).get(String.class));
    // Get XML for application
    System.out.println(service.path("rest").path("todo").accept(MediaType.APPLICATION_JSON).get(String.class));
    // Get JSON for application
    System.out.println(service.path("rest").path("todo").accept(MediaType.APPLICATION_XML).get(String.class));
    */
  

  ClientConfig config = new ClientConfig();

  Client client = ClientBuilder.newClient(config);

  WebTarget target = client.target(getBaseURI());

  System.out.println(target.path("rest").path("todo").request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString());
  
  System.out.println(target.path("rest").path("todo").request().accept(MediaType.TEXT_XML).get(String.class));

  System.out.println(target.path("rest").path("todo").request().accept(MediaType.APPLICATION_XML).get(String.class));
  
  }
  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/com.vogella.jersey.jaxb").build();
  }

} 


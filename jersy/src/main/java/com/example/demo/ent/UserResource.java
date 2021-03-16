package com.example.demo.ent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import com.example.demo.jpa.service.Manager;
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/users")
public class UserResource  implements   ContainerResponseFilter
{
      @GET
    @Produces("application/json")
    public Users getAllUsers() {
        Users users = new Users();
        users.setUsers(new ArrayList<>(myDb().values()));
        return users;
    }
      @GET
      @Path("/{id}")
      @Produces("application/json")
      public User getUserById(@PathParam("id") Long id) 
      {
    	  return myDb().get(id);
    } 
    @POST
    @Consumes("application/json")
    public void createUser(User user) throws URISyntaxException 
    {
      Manager.insert(user);
      response(user,(-1L),"POST");
    }
    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public void updateUser(@PathParam("id") Long id, User user) throws URISyntaxException 
    {
     Manager.update(user, id);
    	response(user,id,"PUT");
             }
 
    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") Long id) throws URISyntaxException {
    	  Manager.delete(id);
    	response(null,id,"DELETE");
     }
   private Map<Long, User> myDb() {
    	Map<Long, User> map = new HashMap<>();
    	Manager.showList().forEach(
    			user-> {
    				map.put(user.getId(), user);
    	        } 
    			);
    	return map;
    }

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		  MultivaluedMap<String, Object> headers = responseContext.getHeaders();
	        headers.add("Access-Control-Allow-Origin", "*");
	        //headers.add("Access-Control-Allow-Origin", "http://abcd.org"); //allows CORS requests only coming from abcd.org
	        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
	        headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, X-Codingpedia");  
			}
	private void response(User user,Long id,String type) {
	 	System.out.println("begin\nsalamo alaykom from "+type);
		System.out.println("id="+id+"\n");
		System.out.println("user=\n"+user!=null?user:"null");
	  	System.out.println("\nend");
	}
}

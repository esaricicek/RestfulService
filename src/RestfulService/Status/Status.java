package RestfulService.Status;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/Status")
public class Status {

	@GET
	@Produces(MediaType.TEXT_HTML)	
	public String returnTitle()
	{
		return "<p>Deneme</p>";		
	}
}

package RestfulService.CheckXml;
import java.io.InputStream;
import javax.jws.WebMethod;
import javax.ws.rs.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import se.uglisch.XmlSchemaNsUris;

@Path("/CheckXml")
public class CheckXml {
		
	@POST
	@WebMethod
	@Consumes("*/*")
	@Produces("*/*;charset=UTF-8")
	public String test(String xmlData){
		 try( InputStream stream = getClass().getResourceAsStream("/schematron/UBL-TR_Main_Schematron.xml");){
	          SchemaFactory schemaFactory = SchemaFactory.newInstance(XmlSchemaNsUris.SCHEMATRON_NS_URI);
	          Schema schema = schemaFactory.newSchema(new StreamSource(stream));
	          schema.newValidator().validate(new StreamSource(xmlData));
	        } catch (Exception   e) {
	           return e.getMessage();
	        }
	        return "valid";
		//System.out.println(xmlData); //reads xml data
 	    //return xmlData;	
   	    //if(xmlData == "<?xml version='1.0' encoding='UTF-8'?><test>Test!</test></xml>")
		//  return "<?xml version='1.0' encoding='ISO-8859-1'?><note>Ayný be yaaaa!</note>";
		//else			  
	    // return "<?xml version='1.0' encoding='ISO-8859-1'?><note>Hello!</note>"; 
	}

}

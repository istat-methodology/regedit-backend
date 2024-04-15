package it.istat.mec.regedit.service;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.RScriptDao;

@Service
public class RScriptService {
	
	@Autowired
	RScriptDao rScriptDao;
	@Value("${app.editing.Rserver}")
	private String Rserver;
	@Value("${app.editing.Rport}")
	private Integer Rport;
	@Value("${app.editing.Ruser}")
	private String Ruser;
	@Value("${app.editing.Rpass}")
	private String Rpass;
	@Value("${app.editing.Rwd}")
	private String Rwd;

	public String eseguiScript() throws REXPMismatchException, REngineException {		
			
		
		String result = null;	


		RConnection conn=null;			
		
		try {			
			conn = open(null,Rserver,Rport,Ruser,Rpass);
			System.out.println("Connessione Server R:" + conn.toString());
			
	
			String path = conn.eval("getwd()").asString();
			conn.eval("setwd('//home2//ruser')").toString();
			path = conn.eval("getwd()").asString();
			System.out.println("path RServe;" + path);
			REXP rResponseObject =  conn.parseAndEval("try(source('R_directory_test//LinkageProbabilistico.R'), silent=TRUE)");
			result = conn.eval("outstr").asString();
			System.out.println(result);
			//"source('" + fileScriptR + "')"
			//System.out.println("Risultato sript R;" + rResponseObject);
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = e.getMessage();
		} finally{
			conn.close();
		}
	
			
		return result;
	}
	public static RConnection open(RConnection connection,String hostname,int port,String username,String password) throws RserveException{
		//connection = new RConnection(hostname,port);
		connection = new RConnection(hostname);
	      connection.login(username,password);
	      return connection;
	}
}

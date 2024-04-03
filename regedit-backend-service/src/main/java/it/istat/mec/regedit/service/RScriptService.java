package it.istat.mec.regedit.service;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.istat.mec.regedit.dao.RScriptDao;

@Service
public class RScriptService {
	
	@Autowired
	RScriptDao rScriptDao;

	public void eseguiScript() throws REXPMismatchException {
		String hostname = "rstudio.istat.it";
		int port=6311;
		//RConnection connection=null;	
		String risultato = null;
		

//	try {
//		
//		connection = open(connection, hostname, port, username, password);
//		System.out.println("Sono nel try");
//		//connection = new RConnection(hostname,port);
//		System.out.println("test R: " +connection);
//	//}catch(RserveException e) {
//	}catch(Exception e) {
//		System.out.println("Si è verificata un'eccezione: "+e);
//	}
		try {
			RConnection conn=null;
			conn = open(null,hostname,port,"ruser","Ruser2023");
			System.out.println("Connessione Server R:" + conn.toString());
			risultato += conn.eval("3 * 5").asString();
			System.out.println("Risultato moltiplicazione R;" + risultato);
			//conn.eval("setwd('" +"script/regedit/" + "')");
			//risultato += conn.parseAndEval("getwd()").toString();
			conn.eval("setwd('//home2//ruser')").toString();
			String path = conn.eval("getwd()").asString();
			System.out.println("path RServe;" + path);
            RList ris = conn.eval("source('script//regedit//prova.R')").asList();
			System.out.print(ris);
			for(int i=0;i<ris.size();i++){
			      System.out.println(ris.at(i).toString());
			}
			//"source('" + fileScriptR + "')"
			System.out.println("Risultato sript R;" + risultato);
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			
		
	}
	public static RConnection open(RConnection connection,String hostname,int port,String username,String password) throws RserveException{
		//connection = new RConnection(hostname,port);
		connection = new RConnection(hostname);
	      connection.login(username,password);
	      return connection;
	}
}

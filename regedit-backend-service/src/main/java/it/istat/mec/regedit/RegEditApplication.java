package it.istat.mec.regedit;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
//@EnableEurekaClient

public class RegEditApplication extends SpringBootServletInitializer {
	//public static RConnection connection = null;
	//private static final Logger log = LoggerFactory.getLogger(RegEditApplication.class);
	public static void main(String[] args) throws RserveException {
		SpringApplication.run(RegEditApplication.class, args);		
	}
	
	String hostname = "rstudio.istat.it";
	int port=6311;
	String username="ruser";
	String password="Ruser2023";
	
	
	
	
	
//	@Override
//	public void run(String... strings) throws REXPMismatchException {
//		String hostname = "rstudio.istat.it";
//		int port=6311;
//		//RConnection connection=null;	
//		String risultato = null;
//		
//
////	try {
////		
////		connection = open(connection, hostname, port, username, password);
////		System.out.println("Sono nel try");
////		//connection = new RConnection(hostname,port);
////		System.out.println("test R: " +connection);
////	//}catch(RserveException e) {
////	}catch(Exception e) {
////		System.out.println("Si è verificata un'eccezione: "+e);
////	}
//		try {
//			RConnection conn=null;
//			conn = open(null,hostname,port,"ruser","Ruser2023");
//			System.out.println("Connessione Server R:" + conn.toString());
//			risultato += conn.eval("3 * 5").asString();
//			System.out.println("Risultato moltiplicazione R;" + risultato);
//			//conn.eval("setwd('" +"script/regedit/" + "')");
//			//risultato += conn.parseAndEval("getwd()").toString();
//			conn.eval("setwd('//home2//ruser')").toString();
//			String path = conn.eval("getwd()").asString();
//			System.out.println("path RServe;" + path);
//            RList ris = conn.eval("source('script//regedit//prova.R')").asList();
//			System.out.print(ris);
//			for(int i=0;i<ris.size();i++){
//			      System.out.println(ris.at(i).toString());
//			}
//			//"source('" + fileScriptR + "')"
//			System.out.println("Risultato sript R;" + risultato);
//		} catch (RserveException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//			
//		
//	}
	
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RegEditApplication.class);
	}

	
//	public static RConnection open(RConnection conn,String hostname,int port,String username,String password) throws RserveException{
//		conn = new RConnection(hostname,port);
//		conn.login(username,password);
//        return conn;
//  }
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("*").allowedOrigins("*");
			}
		};
	}
	
		
		// Test connessione con RServe
		
		
//	public static RConnection open(RConnection connection,String hostname,int port,String username,String password) throws RserveException{
//		//connection = new RConnection(hostname,port);
//		connection = new RConnection(hostname);
//	      connection.login(username,password);
//	      return connection;
//	}
//		
//		@Bean
//		public static REXP funcall(RConnection connection,String funcname,int num1,int num2) throws RserveException, REXPMismatchException{
//			return connection.eval(funcname+"("+num1+","+num2+")");
//		}
//		
//		public static void close(RConnection connection) throws RserveException{
//			if(connection !=null){
//				connection.close();
//			}
//		}
//	
	
		
}

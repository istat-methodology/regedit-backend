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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
//@EnableEurekaClient

public class RegEditApplication extends SpringBootServletInitializer implements CommandLineRunner{
	//public static RConnection connection = null;
	//private static final Logger log = LoggerFactory.getLogger(RegEditApplication.class);
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
	static String risultato;
	public static void main(String[] args) throws RserveException {
		SpringApplication.run(RegEditApplication.class, args);		
	}
	
	String hostname = "rstudio.istat.it";
	int port=6311;
	String username="ruser";
	String password="Ruser2023";
	
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Connessione Server R Starting");
		
		RConnection conn=null;
		try {
			
			
			
				
				
				conn = open(null,"rstudio8.istat.it",6311,"ruser","Ruser2023");
				System.out.println("Connessione Server R:" + conn.toString());
				risultato += conn.eval("3 * 5").asString();
				System.out.println("Risultato moltiplicazione R;" + risultato);
				conn.close();
				//conn = open(null,"rstudio8.istat.it",6311,"ruser","Ruser2023");
				conn = open(null,Rserver,Rport,Ruser,Rpass);
				System.out.println("Connessione Server R:" + conn.toString());
				conn.eval("setwd('//home2//ruser')").toString();
				//conn.eval("setwd(Rwd)").toString();
				String path = conn.eval("getwd()").asString();
				System.out.println("path RServe;" + path);
				
				conn.close();
				conn = open(null,"rstudio8.istat.it",6311,"ruser","Ruser2023");
				
				
				
				
				  //REXPGenericVector ris = (REXPGenericVector)conn.eval("source('script//regedit//prova.R')");
				  //System.out.println(ris.asList().at("value").asString());
				 
					/*
					 * conn.close();
					 * 
					 * System.out.println(ris.asList().at("value").asString()); conn =
					 * open(null,"rstudio8.istat.it",6311,"ruser","Ruser2023");
					 * conn.eval("setwd('//home2//ruser')").toString();
					 * 
					 * String path2 = conn.eval("getwd()").asString();
					 * System.out.println("path RServe;" + path2);
					 */
				//REXPGenericVector ris2 = (REXPGenericVector) conn.eval("source('script//regedit//connessionetest.R')");
				//REXP ris2 = conn.eval("source('script//regedit//connessionetest.R')");
				  
				  
				  
				  
				conn.eval("setwd('//home2//ruser')").toString();
				path = conn.eval("getwd()").asString();
				System.out.println("path RServe;" + path);
				//REXPGenericVector ris2 = (REXPGenericVector) conn.eval("source('R_directory_test//LinkageProbabilistico.R')");
				//System.out.println(ris2.asList().at("value"));
				REXP rResponseObject =  conn.parseAndEval("try(source('R_directory_test//LinkageProbabilistico.R'), silent=TRUE)");
				
				REXP ris2 = conn.eval("outstr");
				System.out.println(ris2.asString());
				//System.out.println(rResponseObject.asString());
				/*
				 * REXP ris1 = conn.eval("oraodbcname<-'PD_RSI_PT'" );
				 * System.out.print("Assegnazione DB:" + ris1.asStrings()[0]);
				 */
				
				/*
				 * REXP ris2 = conn.eval("orauser<-'UP_STEFANO_MACONE'");
				 * System.out.print("Assegnazione utente DB:" + ris2.asStrings()[0]);
				 * 
				 * REXP ris3 = conn.eval("orapassword<-'Malcomx#1971'");
				 * System.out.print("Assegnazione password DB:" + ris3.asStrings()[0]);
				 */
				
				/*
				 * REXP ris4 = conn.eval("PROV<-'Sassari'");
				 * System.out.print("Assegnazione Provincia:" + ris4.asStrings()[0]);
				 * 
				 * REXP ris5 = conn.eval("COD<-'090'");
				 * System.out.print("Assegnazione Codice Provincia:" + ris5.asStrings()[0]);
				 * 
				 * REXP ris6 = conn.eval("s<- 0.6"); System.out.print("Assegnazione Soglia" +
				 * ris6.asStrings()[0]);
				 * 
				 * 
				 * 
				 * 
				 * 
				 * 
				 * REXP ris7 = (REXPGenericVector)
				 * conn.parseAndEval("source('script//regedit//indirizzi_rodbc_regedit_mod.R')")
				 * ;
				 * 
				 * System.out.print("Output Esecuzione Script:" +
				 * ris7.asList().at("value").asString());
				 * 
				 * REXP ris8 = (REXPGenericVector) conn.eval("result')");
				 * 
				 * System.out.print("Output Script:" + ris8.asList().at("value").asString());
				 * conn.close();
				 */
				
				conn.close();
				
			
		} catch (RserveException e) {
			// TODO Auto-generated catch block
			conn.close();
			e.printStackTrace();
		}
	}	
	
	
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
	
	public static RConnection open(RConnection connection,String hostname,int port,String username,String password) throws RserveException{
		connection = new RConnection(hostname,port);
	     connection.login(username,password);
	      return connection;
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

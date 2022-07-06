package application;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
/**
*
* This function is used for interfacing with the system
*	 You can register yourself as a client and then research the race and the boats
*	  The employee and the users can login and perform the functions that are already permitted
* @author Francesca Stefano mat. 306826
* @author Antonio Signorelli mat. 306824
*
*/
public class Server 
{
	
	private static final String DBURL = "jdbc:mysql://localhost:3306/circolovelico?";
	private static final String ARGS = "createDatabaseIfNotExist=true&serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "";	
    static ServerSocket serversocket;
    static Socket client;
    BufferedReader input;
    PrintWriter output;
   
    ArrayList<Socio> listaSoci = new ArrayList<Socio>(); 
    ArrayList<String> listaGare = new ArrayList<String>();
    ArrayList<String> listaBarche = new ArrayList<String>();
    ArrayList<String>ListaSoci =new ArrayList<String>(); 
    ArrayList<Personale> listaPersonale = new ArrayList<Personale>();
    ArrayList<String> listaPagamenti = new ArrayList<String>();
    
    /**
	  * Public void method for start, the server is waiting for connection from client
	 * Connection with local db 
	 * 
	 */
    public void start() throws IOException
    {

        System.out.println("Connection Starting on port:" + serversocket.getLocalPort() );
        client = serversocket.accept();

        System.out.println("Waiting for connection from client");
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
  
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));       
        
        String tipo = input.readLine();
    
        try 
        
        {	  	        	
        	if (tipo.equals("registrazione"))
            {
        		registrazione();
            }
        	if (tipo.equals("login dipendente"))
            {
        		loginPersonale();       		
            }
        	if (tipo.equals("soci"))
            {
        		visualizzaSoci();
            }
        	if (tipo.equals("visualizza gare"))
            {
        		visualizzaGara();
            }
        	if (tipo.equals("visualizza barche"))
            {
        		visualizzaBarche();
            }
        	if (tipo.equals("iscrizione gara"))
            {
        		iscrizioneGara();
            }
            if (tipo.equals("login socio"))
            {
            	logInfo();           	
            }
            if (tipo.equals("rimuovi barca"))
            {
            	rimuoviBarca();           	
            }
            if (tipo.equals("aggiungi barca"))
            {
            	aggiungiBarca();           	
            }
            if (tipo.equals("paga"))
            {
            	Payment();           	
            }
            if (tipo.equals("visualizza pagamenti"))
            {
            	visualizzaPagamenti();           	
            }
            if (tipo.equals("gestione gare"))
            {
            	gestionegare();           	
            }
        }
        catch (Exception e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        output.flush();
        output.close();
        input.close();
    }
    /**
	  * Public void method for the registration of the user 
	 * Connection with local db 
	 * 
	 */

    public void registrazione() throws Exception 
    {
   
    	try (Connection conn = DriverManager.getConnection(
                DBURL + ARGS , LOGIN, PASSWORD);
              Statement stmt = conn.createStatement();)
         {
       
        
        String CF = input.readLine();
        System.out.println("cf" + CF);
        String nome = input.readLine();
        System.out.println("name" + nome);
        String cognome = input.readLine();
        System.out.println("cognome" + cognome);
        String indirizzo = input.readLine();
        System.out.println("address" + indirizzo);
        String username = input.readLine();
        System.out.println("username" + username);
        String password = input.readLine();
        System.out.println("password" + password);
        String cc = input.readLine();
        System.out.println("cc" + cc);

        //query for insert into the db the cerdentials of the user 
	        PreparedStatement stmt4 = conn.prepareStatement("INSERT INTO socio(CF, nome, cognome,indirizzo,username,pwd,carta_credito) VALUES (?,?,?,?,?,?,?)");
	        stmt4.setString(1, CF);
	        stmt4.setString(2, nome);
	        stmt4.setString(3, cognome);
	        stmt4.setString(4,indirizzo);
	        stmt4.setString(5, username);
	        stmt4.setString(6, password);
	        stmt4.setString(7,cc);
	        stmt4.executeUpdate();

        output.flush();
        output.close();  
         	}
    	}
    /**
	  * Public void method to  sing in  of the race
	 * Connection with local db 
	 * 
	 */
    public void iscrizioneGara() throws Exception 
    {

    	try (Connection conn = DriverManager.getConnection(
                DBURL + ARGS , LOGIN, PASSWORD);
              Statement stmt = conn.createStatement();)
         {
    
        
        String fk_partecipante = input.readLine();
        System.out.println("id partecipante" + fk_partecipante);
        String fk_gara = input.readLine();
        System.out.println("fk_gara" + fk_gara);
        boolean pagato = false;
     
        output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
	        PreparedStatement stmt44 = conn.prepareStatement("INSERT INTO partecipanti(fk_partecipante,fk_gara,pagato) VALUES (?,?,?)");
	        stmt44.setString(1, fk_partecipante);
	        stmt44.setString(2, fk_gara);
	        stmt44.setBoolean(3, pagato);
	        stmt44.executeUpdate();

        output.flush();
        output.close();  
         	}
    	}
    /**
	  * Public void method for  login of the user employee
	 * 
	 */
    
    public void loginPersonale() throws Exception
    {
    	
    	 int thereIsUser = 0;



        String id_personale = input.readLine();
        System.out.println("id_personale" + id_personale);
        String password = input.readLine();
        System.out.println("password" + password);

 
        String strSelect = "select * from personale";
		
        try (Connection conn = DriverManager.getConnection(
                DBURL + ARGS , LOGIN, PASSWORD);
              Statement stmt = conn.createStatement();)
         {
        	
        	System.out.println("personale loggato con suxxesso");        	
			ResultSet rset= stmt.executeQuery(strSelect);
			while (rset.next())
			{
				Personale p = new Personale (rset.getString("id_personale"),rset.getString("user"),rset.getString("password")); 
				
				listaPersonale.add(p);
				
			}
			
			for(Personale e:listaPersonale) 
			{
				
				
				if(id_personale.equals(e.getId_personale())&& password.equals(e.getPassword()))
				{
					System.out.println("login personale effettuato con suxxess");
				
					output.println("true2");
					
					thereIsUser=1; 
					
				}
			}
			if(thereIsUser == 0) 
			{
				output.println("login failed");
				
			}
		}
        
			catch (Exception e) 
			{
				e.printStackTrace();
			}

        output.flush();
        output.close();
    }
    /**
	  * Public void method for the visualization  of the users 
	 * Connection with local db 
	 * 
	 */
    public void visualizzaSoci() throws Exception
    {
    	
    	System.out.println("entro nel metodo visualizza soci");
    	ArrayList<String>ListaSoci =new ArrayList();
    	
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));

       output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
    	
        String strSelect3 = "select * from socio";	
        try (Connection conn = DriverManager.getConnection(
                DBURL + ARGS , LOGIN, PASSWORD);
              Statement stmt = conn.createStatement();)
         
        {
        	System.out.println("entro nel try di visualizza soci");
        
        	ResultSet rset3= stmt.executeQuery(strSelect3);
			while (rset3.next())
			{
				 
						String cf=rset3.getString("CF");
						ListaSoci.add(cf);
						String nome=rset3.getString("nome");
						ListaSoci.add(nome);
						String cognome=rset3.getString("cognome");
					    ListaSoci.add(cognome);
						String indirizzo=rset3.getString("indirizzo");
						ListaSoci.add(indirizzo);
						String username=rset3.getString("username");
						ListaSoci.add(username);
						String psw=rset3.getString("pwd");
						ListaSoci.add(psw);
						String cc=rset3.getString("carta_credito"); 
						ListaSoci.add(cc);   																		
						ListaSoci.add("-");
		
			}
			
			
			  String str = ""; 
			  for (String i : ListaSoci)
			 { 
				  str += i + ","; 
				  
			  }

			  
			  System.out.println(ListaSoci);
			  output.println(str);

		}
      
		catch (Exception e) 
		{
			e.printStackTrace();
		}

        output.flush();
        output.close();
    }  
    /**
	  * Public void method for the login of the user 
	 * 
	 * 
	 */
    public void logInfo() throws Exception 
    {
    	
    	 int thereIsUser = 0;
  

        String CF = input.readLine();
        System.out.println("username" + CF);
        String password = input.readLine();
        System.out.println("password" + password);
      
        
        String strSelect = "select * from socio";
        		
        try (Connection conn = DriverManager.getConnection(
                DBURL + ARGS , LOGIN, PASSWORD);
              Statement stmt = conn.createStatement();)
         {
        	
			ResultSet rset= stmt.executeQuery(strSelect);
			while (rset.next())
			{
				Socio s = new Socio (rset.getString("CF"),rset.getString("nome"),rset.getString("cognome"),rset.getString("indirizzo"),rset.getString("username"),rset.getString("pwd"),rset.getString("carta_credito")); 
				
				listaSoci.add(s);
				
			}
			
			for(Socio pers:listaSoci) 
			{
				
				if(CF.equals(pers.getCF())&& password.equals(pers.getPwd()))
				{
					System.out.println("credenziali socio valide! ");
					output.println("true");
					System.out.println("lista soci= "+ listaSoci);
					thereIsUser=1; 
					
				}
			}
			if(thereIsUser == 0) 
			{
				output.println("login failed");
				
			}
		}
        
			catch (Exception e) 
			{
				e.printStackTrace();
			}

        output.flush();
        output.close();
    }        

    /**
	  * Public void method for add a boat 
	 * Connection with local db 
	 * 
	 */

        public void aggiungiBarca() throws Exception
        { 
	        try (Connection conn = DriverManager.getConnection(
	                DBURL + ARGS , LOGIN, PASSWORD);
	              Statement stmt = conn.createStatement();)
	         {
	       
	  
	        	String id_barca = input.readLine();
	            System.out.println("id: " + id_barca);
	        	String nome = input.readLine();
	            System.out.println("nome: " + nome);        	
	            String lunghezza = input.readLine();
	            System.out.println("L: " + lunghezza);        	
	            String fk_socio= input.readLine();
	            System.out.println("id socio : " + fk_socio);
	            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
	
	       PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO barca(id_barca, nome, lunghezza,fk_socio) VALUES (?,?,?,?)");
	        stmt1.setString(1, id_barca);
	        stmt1.setString(2, nome);
	        stmt1.setString(3, lunghezza);
	        stmt1.setString(4,fk_socio);
	        stmt1.executeUpdate();
	        
	        output.flush();
	        output.close();
	         }
    }

        /**
   	  * Public void method for remove boat 
   	 * Connection with local db 
   	 * 
   	 */
        public void rimuoviBarca() throws Exception
        { 
        	try (Connection conn = DriverManager.getConnection(
	                DBURL + ARGS , LOGIN, PASSWORD);
	              Statement stmt = conn.createStatement();)
	         {
	       
	       
	
	        	String id_barca = input.readLine();
	            System.out.println("id: " + id_barca);
	            String fk_socio = input.readLine();
	            System.out.println("fk_socioo: " + fk_socio);
	            
	            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
	
	            
	       PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM BARCA WHERE id_barca=? and fk_socio=?");
	        stmt2.setString(1, id_barca);
	        stmt2.setString(2, fk_socio);
	        
	
	        stmt2.executeUpdate();
	        output.flush();
	        output.close();
	        
	         }
        }
        /**
   	  * Public void method for payment
   	 * Connection with local db 
   	 * 
   	 */
        public void Payment() throws Exception
        { 	
        	LocalDate oggi= LocalDate.now();
        
        	try (Connection conn = DriverManager.getConnection(
	                DBURL + ARGS , LOGIN, PASSWORD);
	              Statement stmt = conn.createStatement();)
	         {


	        	String tipo = input.readLine();
	            System.out.println("tipo: " + tipo);
	        	String importo = input.readLine();
	            System.out.println("importo: " + importo);
	        	String fk_soci = input.readLine();
	            System.out.println("id soci6: " + fk_soci);
	        	String data = String.valueOf(oggi);
	            System.out.println("data: " + data);
	            String metodo = input.readLine();
	            System.out.println("metodo di pagamento: " + metodo);
	            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));	
	            
	       PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO pagamento(tipo, importo,fk_soci, data_pagamento,metodo) VALUES (?,?,?,?,?)");
	  
	        stmt3.setString(1, tipo);
	        stmt3.setString(2, importo);
	        stmt3.setString(3, fk_soci);
	        stmt3.setString(4, data); 
	        stmt3.setString(5, metodo);
	        stmt3.executeUpdate();
	        
	        output.flush();
	        output.close();
	        
	         }
        }
        
      /**
   	  * Public void method for visualization of payment
   	  * Connection with local db 
   	  * 
   	  */
        public void visualizzaPagamenti() throws Exception 
        {
        	System.out.println("se stampa vuol dire che entra nel metodo viisulizagara" );
        	
        
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

            
            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream())); 
            
            String strSelect2 = "select * from pagamento";	
            try (Connection conn = DriverManager.getConnection(
                    DBURL + ARGS , LOGIN, PASSWORD);
                  Statement stmt = conn.createStatement();)
             
            {
            	System.out.println("dovresti visualizzare i pagamenti bello" );
            	ResultSet rset2= stmt.executeQuery(strSelect2);
            	
    			while (rset2.next())
    			{

    				String tipo=rset2.getString("tipo");
    				listaPagamenti.add(tipo);
					String importo=rset2.getString("importo");
					listaPagamenti.add(importo);
					String fk_soci=rset2.getString("fk_soci");
					listaPagamenti.add(fk_soci);		
					String data_pagamento=rset2.getString("data_pagamento");
					listaPagamenti.add(data_pagamento);	
					String metodo=rset2.getString("metodo");
					listaPagamenti.add(metodo);
					listaPagamenti.add("-");	
    			}
    			
    			  String str2 = ""; 
    			  for (String i : listaPagamenti)
    			  { 
    				  str2 += i + ","; 
    				  
    			  }
    			  System.out.println(listaPagamenti);
    			  output.println(str2);
    		}
    	  
    		catch (Exception e) 
    		{
    			e.printStackTrace();
    		}

            output.flush();
            output.close();
        }
        /**
   	  * Public void method for the visualization of race
   	 * Connection with local db 
   	 * 
   	 */
        public void visualizzaGara() throws Exception 
        {
        	System.out.println("se stampa vuol dire che entra nel metodo viisulizagara" );


            input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        
            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream())); 
            
            String strSelect2 = "select * from gara";	
            try (Connection conn = DriverManager.getConnection(
                    DBURL + ARGS , LOGIN, PASSWORD);
                  Statement stmt = conn.createStatement();)
             
            {
            	System.out.println("dovresti visualizzare le gare bello" );
            	ResultSet rset2= stmt.executeQuery(strSelect2);
            	
    			while (rset2.next())
    			{
    				
    				
    				String id_gara=rset2.getString("id_gara");
					listaGare.add(id_gara);
					String quota=rset2.getString("quota");
					listaGare.add(quota);
					String data=rset2.getString("data");
					listaGare.add(data);
					String luogo=rset2.getString("luogo");
					listaGare.add(luogo);
					listaGare.add("-");
					
    				
    			}
    			
    			  String str2 = ""; 
    			  for (String i : listaGare)
    			 { 
    				  str2 += i + ","; 
    				  
    			  }
    			  System.out.println(listaGare);
    			  output.println(str2);
    		}
    	  
    		catch (Exception e) 
    		{
    			e.printStackTrace();
    		}

            output.flush();
            output.close();
        }
        
        /**
   	  * Public void method for the visualization of the boat 
   	 * Connection with local db 
   	 * 
   	 */

        public void visualizzaBarche() throws Exception
        {

        	System.out.println("se stampa vuol dire che entra nel metodo viisulizza barche" );

            input = new BufferedReader(new InputStreamReader(client.getInputStream()));


            output = new PrintWriter(new OutputStreamWriter(client.getOutputStream())); 
            
            String strSelect3 = "select * from barca";	
            try (Connection conn = DriverManager.getConnection(
                    DBURL + ARGS , LOGIN, PASSWORD);
                  Statement stmt = conn.createStatement();)
             
            {
            	System.out.println("dovresti visualizzare le barchette ");
            	ResultSet rset4= stmt.executeQuery(strSelect3);
            	
            	
    			while (rset4.next())
    			{

    				String id_barca=rset4.getString("id_barca");
    				listaBarche.add(id_barca);
    				String nome=rset4.getString("nome");
    				listaBarche.add(nome);
    				String lunghezza=rset4.getString("lunghezza");
    				listaBarche.add(lunghezza);
    				String fk_socio=rset4.getString("fk_socio");
    				listaBarche.add(fk_socio);
    				listaBarche.add("-");
    				
    			}

    			
    			  String str3 = ""; 
    			  for (String i : listaBarche)
    			 { 
    				  str3 += i + ","; 
    				  
    			  }
    			  System.out.println(listaBarche);
    			  output.println(str3);

    		}        
    		catch (Exception e) 
    		{
    			e.printStackTrace();
    		}

            output.flush();
            output.close();
        }
        
        
        
        /**
      	 * With this method the admin  is able to add a new race 
      	 * 
      	 * 
      	 * 
      	 */
        
        
        public void gestionegare() throws Exception 
        {
       
        	try (Connection conn = DriverManager.getConnection(
                    DBURL + ARGS , LOGIN, PASSWORD);
                  Statement stmt = conn.createStatement();)
             {
           
            
            String id_gara = input.readLine();
            System.out.println("id_gara" + id_gara);
            String quota = input.readLine();
            System.out.println("quota" + quota);
            String data = input.readLine();
            System.out.println("data" + data);
            String luogo = input.readLine();
            System.out.println("luogo" + luogo);

            //query for insert into the db the cerdentials of the user 
    	        PreparedStatement stmt4 = conn.prepareStatement("INSERT INTO gara(id_gara, quota, data,luogo) VALUES (?,?,?,?)");
    	        stmt4.setString(1, id_gara);
    	        stmt4.setString(2, quota);
    	        stmt4.setString(3, data);
    	        stmt4.setString(4,luogo);

    	        stmt4.executeUpdate();

            output.flush();
            output.close();  
             	}
        	}
        /**
      	 * Creation of the server and serversocket ( port 9091)
      	 * while true needs to keep ready for new request 
      	 * 
      	 * 
      	 */
        
    public static void main(String[] args)
    {
        Server server = new Server();
        try 
        {
        	serversocket = new ServerSocket(9091);

        } 
        catch (IOException e) 
        {
  
            e.printStackTrace();
        }
        while(true) 
        {
        	try 
        	{
        	
				server.start();
			} 
        	catch (IOException e) 
        	{

				e.printStackTrace();
			}
        }
    }       
}

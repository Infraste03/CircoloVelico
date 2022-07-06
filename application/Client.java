package application;
/**
 * 
 */

/**
 * @author Francesca Stefano mat. 306826
 * @author Antonio Signorelli mat. 306824
 *
 */
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
/**
 * This is the class "Client" where all the stage and roots are set
* 
*
*/ 
public class Client extends Application 
{	 

    Socket socket;
    BufferedReader read;
    PrintWriter output;

    
	public void start(Stage primaryStage) throws IOException 
	{	 	
		try 
		{									
			Parent rootIniziale = FXMLLoader.load(getClass().getResource("Iniziale.fxml"));
			Scene sceneIniziale = new Scene(rootIniziale,700,700);	
			sceneIniziale.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent rootRegistrazione = FXMLLoader.load(getClass().getResource("Registrazione.fxml")); //scena resistrazione socio
			Scene sceneSocioRegistration = new Scene(rootRegistrazione,700,700);
			
			Parent rootLoginSocio = FXMLLoader.load(getClass().getResource("LoginSocio.fxml")); //scena login del socio
			Scene sceneLoginSocio = new Scene(rootLoginSocio,700,700);
			
			Parent rootDipendente = FXMLLoader.load(getClass().getResource("Dipendente.fxml")); //scena login del dipendente
			Scene sceneLoginDipendente = new Scene(rootDipendente,700,700);
			
			Parent rootGareSocio = FXMLLoader.load(getClass().getResource("IscrizioneSocioGare.fxml")); //scena iscrizione gare di socio
			Scene sceneGareSocio = new Scene(rootGareSocio,700,700);
			
			Parent rootBarcheSocio = FXMLLoader.load(getClass().getResource("MetodiSocioBarche.fxml")); //scena metodi add e remove socio barche
			Scene sceneBarcheSocio = new Scene(rootBarcheSocio,700,700);
			
			Parent rootPagaSocio = FXMLLoader.load(getClass().getResource("MetodiPagamentoSocio.fxml")); //scena pagamenti vari del socio
			Scene scenePagaSocio = new Scene(rootPagaSocio,700,700);
			
			Parent rootAddGara = FXMLLoader.load(getClass().getResource("Addgareadmin.fxml")); // gestione gare admin 
			Scene sceneAddGara = new Scene(rootAddGara,700,700);
					
			primaryStage.setScene(sceneIniziale);
			primaryStage.show();	
			
			// bottoni per scena ininziale
			Button LoginSocio= (Button)sceneIniziale.lookup("#LoginSocio");	
			Button EmployeeLogin= (Button)sceneIniziale.lookup("#EmployeeLogin");
			Button SocioRegistration= (Button)sceneIniziale.lookup("#SocioRegistration");			
			
			//AREA REGISTRAZIONE SOCI 
			TextField CfSocio= (TextField)sceneSocioRegistration.lookup("#CFTEXT");
			TextField NomeSocio= (TextField)sceneSocioRegistration.lookup("#NOMETEXT");
			TextField CognomeSocio= (TextField)sceneSocioRegistration.lookup("#COGNOMETEXT");
			TextField IndirizzoSocio= (TextField)sceneSocioRegistration.lookup("#INDIRIZZOTEXT");
			TextField UsernameSocio= (TextField)sceneSocioRegistration.lookup("#USERNAMETEXT");
			TextField PwdSocio= (TextField)sceneSocioRegistration.lookup("#PWDTEXT");
			TextField CcSocio = (TextField)sceneSocioRegistration.lookup("#CARTATEXT");
			Button InvioRegistrazioneSocio = (Button)sceneSocioRegistration.lookup("#ENTERAREAREGISTRAZIONE");
			
			//AREA LOGIN SOCIO
			Text textCF = (Text)sceneLoginSocio.lookup("#textCF"); 
			Text textPwd = (Text)sceneLoginSocio.lookup("#textPwd");
			Text GESTIONEBARCHETEXT = (Text)sceneLoginSocio.lookup("#GESTIONEBARCHETEXT");
			Text GESTIONEGARETEXT = (Text)sceneLoginSocio.lookup("#GESTIONEGARETEXT");
			Text GESTIONEPAYTEXT = (Text)sceneLoginSocio.lookup("#GESTIONEPAYTEXT");
			TextField codFisSocio= (TextField)sceneLoginSocio.lookup("#CFLOGINSOCIOTEXT");
			PasswordField PasswordSocio = (PasswordField)sceneLoginSocio.lookup("#PWDLOGINSOCIOTEXT");
			Button InvioLoginSocio = (Button)sceneLoginSocio.lookup("#ENTERAREALOGIN");
			ImageView ugabbian = (ImageView)sceneLoginSocio.lookup("#ugabbian");
			Button InvioAiMetodiGare = (Button)sceneLoginSocio.lookup("#InvioAiMetodiGare");
			Button InvioAiMetodiBarche = (Button)sceneLoginSocio.lookup("#InvioAiMetodiBarche");
			Button InvioAiMetodiPaga = (Button)sceneLoginSocio.lookup("#InvioAiMetodiPaga");	
			
			//AREA GESTIONE GARE SOCIO 
			Button EnterGaraIscrizione = (Button)sceneGareSocio.lookup("#EnterGaraIscrizione");
			TextField IDGARAISCRIZIONE = (TextField)sceneGareSocio.lookup("#IDGARAISCRIZIONE");
			TextArea TEXTAREAGARESOCIO = (TextArea)sceneGareSocio.lookup("#TEXTAREAGARESOCIO");		
			
			//AREA GESTIONE BARCHE SOCIO 
			Button enterRimozioneBarca =(Button)sceneBarcheSocio.lookup("#enterRimozioneBarca");
			Button enterAggiungiBarca =(Button)sceneBarcheSocio.lookup("#enterAggiungiBarca");
			TextField IDBARCAADD = (TextField)sceneBarcheSocio.lookup("#IDBARCAADD");
			TextField NOMEADD= (TextField)sceneBarcheSocio.lookup("#NOMEADD");
			TextField LUNGHEZZAADD = (TextField)sceneBarcheSocio.lookup("#LUNGHEZZAADD");
			TextField IDBARCADELETE= (TextField)sceneBarcheSocio.lookup("#IDBARCADELETE");
			TextArea TEXTAREASOCIOBARCHE = (TextArea)sceneBarcheSocio.lookup("#TEXTAREASOCIOBARCHE");		
			
			//AREA PAGAMENTO SOCIO
			Button enterpagasocio =(Button)scenePagaSocio.lookup("#enterpagasocio");
			TextField IMPORTOTEXT= (TextField)scenePagaSocio.lookup("#IMPORTOTEXT");
			RadioButton qgara = (RadioButton)scenePagaSocio.lookup("#qgara");
			RadioButton qassociazione = (RadioButton)scenePagaSocio.lookup("#qassociazione");
			RadioButton qrimessaggio = (RadioButton)scenePagaSocio.lookup("#qrimessaggio");
			RadioButton cartac = (RadioButton)scenePagaSocio.lookup("#cartac");
			RadioButton iban = (RadioButton)scenePagaSocio.lookup("#iban");
			
			//AREA LOGIN PERSONALE BOTTONI E TEXTFIELD E ROBBA VARIA
			Text textIDPERSONALE = (Text)sceneLoginDipendente.lookup("#textIDPERSONALE");
			Text textPasswordPersonale = (Text)sceneLoginDipendente.lookup("#textPasswordPersonale");
			TextField IDPERSONALETEXT= (TextField)sceneLoginDipendente.lookup("#IDPERSONALETEXT");
			PasswordField PWDPERSONALETEXT = (PasswordField)sceneLoginDipendente.lookup("#PWDPERSONALETEXT");
			Button ENTERAREADIPENDENTI = (Button)sceneLoginDipendente.lookup("#ENTERAREADIPENDENTI");				
			TextArea TEXTAREALISTASOCI= (TextArea)sceneLoginDipendente.lookup("#TEXTAREALISTASOCI");
			TextArea TEXTAREAGARE = (TextArea)sceneLoginDipendente.lookup("#TEXTAREAGARE"); 
			TextArea TEXTAREABARCHE = (TextArea)sceneLoginDipendente.lookup("#TEXTAREABARCHE");
			TextArea TEXTAREALISTAPAGAMENTI = (TextArea)sceneLoginDipendente.lookup("#TEXTAREALISTAPAGAMENTI");
			Text garatext = (Text)sceneLoginDipendente.lookup("#garatext"); 
			Text credenzialitext = (Text)sceneLoginDipendente.lookup("#credenzialitext"); 
			Text barchetext = (Text)sceneLoginDipendente.lookup("#barchetext"); 
			Text pagamentitext = (Text)sceneLoginDipendente.lookup("#pagamentitext");  
			ImageView imgdipendente = (ImageView)sceneLoginDipendente.lookup("#imgdipendente");
			Button barchettadmin = (Button)sceneLoginDipendente.lookup("#barchettadmin");	
			Button ButtonGestioneGare = (Button)sceneLoginDipendente.lookup("#ButtonGestioneGare");
			
			///AREA GESTIONE BARCHE ADMIN 
			Button Aggiungi = (Button)sceneAddGara.lookup("#Aggiungi");
			TextField IdGara= (TextField)sceneAddGara.lookup("#IdGara");
			TextField DataGara= (TextField)sceneAddGara.lookup("#DataGara");
			TextField QuotaGara= (TextField)sceneAddGara.lookup("#QuotaGara");
			TextField LuogoGara= (TextField)sceneAddGara.lookup("#LuogoGara");

			
			EventHandler<MouseEvent> eventControl = new EventHandler<MouseEvent>() 
			{ 
				public void handle(MouseEvent e) 
				{ 
					primaryStage.setScene(sceneIniziale);
					primaryStage.show();						
				}
			};   
			SocioRegistration.addEventFilter(MouseEvent.MOUSE_CLICKED, eventControl);		
			    
			EventHandler<MouseEvent> eventRegistration = new EventHandler<MouseEvent>() 
			{ 																			
				public void handle(MouseEvent e) 
				{ 
					primaryStage.setScene(sceneSocioRegistration);
					primaryStage.show();	
				}
			};   			
				SocioRegistration.addEventFilter(MouseEvent.MOUSE_CLICKED, eventRegistration);
							
				EventHandler<MouseEvent> eventInviodatidellaregistrazione = new EventHandler<MouseEvent>() 
				{ 
					public void handle(MouseEvent e) 
					{ 
						try 
						{	
							socket = new Socket("localhost", 9091);
							output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
							read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							if (CfSocio.getText()!= "" && NomeSocio.getText()!="" && CognomeSocio.getText()!="" && IndirizzoSocio.getText()!=""
									&& UsernameSocio.getText()!="" && PwdSocio.getText()!="" && CcSocio.getText()!="")
							{
							output.println("registrazione");
							output.println(CfSocio.getText());
							
							output.println(NomeSocio.getText());
							output.println(CognomeSocio.getText());
							output.println(IndirizzoSocio.getText());
							output.println(UsernameSocio.getText());
							output.println(PwdSocio.getText());
							output.println(CcSocio.getText());
							output.flush();
							
							System.out.println("REGISTRAZIONE AVVENUTA CON SUCCESSO");
							primaryStage.setScene(sceneIniziale);
							primaryStage.show();
							}
							else 
								System.out.println("compilare tutti i campi :)");
						} 
						catch (Exception e1) 
						{
							e1.printStackTrace();
						} 	
					}
				};  	
					InvioRegistrazioneSocio.addEventFilter(MouseEvent.MOUSE_CLICKED, eventInviodatidellaregistrazione);
				
					EventHandler<MouseEvent> eventLoginSocio = new EventHandler<MouseEvent>() 
					{ 																		
						public void handle(MouseEvent e) 
						{ 
							primaryStage.setScene(sceneLoginSocio);
							primaryStage.show();	
						}
					};   		
					LoginSocio.addEventFilter(MouseEvent.MOUSE_CLICKED, eventLoginSocio);
					
					EventHandler<MouseEvent> eventInvioAGare = new EventHandler<MouseEvent>() 
					{
						public void handle(MouseEvent e) 
						{ 
							try 
							{
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("visualizza gare"); 
								output.flush();
								String StringaListaGare = read.readLine();
								String str2[] = StringaListaGare.split(",-,");
								List<String> al2 = new ArrayList<String>();
								al2 = Arrays.asList(str2);										
								for(String s: al2)
								{
								   TEXTAREAGARESOCIO.appendText(s + "\n");
								}
								primaryStage.setScene(sceneGareSocio);
								primaryStage.show();	
							}
							catch (Exception e1) 
							{										
								e1.printStackTrace();
							}
						}
					};  		
					InvioAiMetodiGare.addEventFilter(MouseEvent.MOUSE_CLICKED, eventInvioAGare);
							
					EventHandler<MouseEvent> eventGareSocio = new EventHandler<MouseEvent>() 
					{ 
						public void handle(MouseEvent e) 
						{ 								
							try 
							{
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("iscrizione gara");
								output.println(codFisSocio.getText());
								output.println(IDGARAISCRIZIONE.getText());								
								output.flush();
								System.out.println("codFisSocio "+ codFisSocio.getText());
								System.out.println("IDGARAISCRIZIONE835 "+ IDGARAISCRIZIONE.getText());
								primaryStage.setScene(scenePagaSocio);
								primaryStage.show();
							} 
							catch (Exception e1) 
							{										
								e1.printStackTrace();
							} 	
						}
					};
													
					EnterGaraIscrizione.addEventFilter(MouseEvent.MOUSE_CLICKED, eventGareSocio);
					
					EventHandler<MouseEvent> eventGestioneBarcheSocio = new EventHandler<MouseEvent>() 
					{ 																			
						public void handle(MouseEvent e) 
						{ 
							try 
							{											
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("visualizza barche");
								output.flush();
								String StringaListaBarche = read.readLine();
								String str3[] = StringaListaBarche.split(",-,");
								List<String> al3 = new ArrayList<String>();
								al3 = Arrays.asList(str3);				
								for(String s: al3)
								{											  
									TEXTAREASOCIOBARCHE.appendText(s + "\n");
								}
								primaryStage.setScene(sceneBarcheSocio);
								primaryStage.show();	
							} 
							catch (Exception e1) 
							{
								e1.printStackTrace();
							}
						}
					};   					
					InvioAiMetodiBarche.addEventFilter(MouseEvent.MOUSE_CLICKED, eventGestioneBarcheSocio);
	
					EventHandler<MouseEvent> eventAggiungiBarcheSocio = new EventHandler<MouseEvent>() 
					{ 																			
						public void handle(MouseEvent e) 
						{ 
							try 
							{
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("aggiungi barca");
								output.println(IDBARCAADD.getText());
								output.println(NOMEADD.getText());
								output.println(LUNGHEZZAADD.getText());
								output.println(codFisSocio.getText());
								output.flush();
								output.close();
								primaryStage.setScene(sceneIniziale);
								primaryStage.show();
							} 
							catch (Exception e1) 
							{	
								e1.printStackTrace();
							}										
						}
					};   					
					enterAggiungiBarca.addEventFilter(MouseEvent.MOUSE_CLICKED, eventAggiungiBarcheSocio);
							
					EventHandler<MouseEvent> eventRimuoviBarcheSocio = new EventHandler<MouseEvent>() 
					{ 																			
						public void handle(MouseEvent e) 
						{ 
							try 
							{	
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("rimuovi barca");
								output.println(IDBARCADELETE.getText());	
								output.println(codFisSocio.getText());
								output.flush();
								output.close();
								System.out.println("IDBARCADELETE "+ IDBARCADELETE.getText());
								primaryStage.setScene(sceneIniziale);
								primaryStage.show();
							} 
							catch (Exception e1) 
							{								
								e1.printStackTrace();
							}										
						}
					};   
											
											
					enterRimozioneBarca.addEventFilter(MouseEvent.MOUSE_CLICKED, eventRimuoviBarcheSocio);								
									
					EventHandler<MouseEvent> eventInvioAPagamentoSocio = new EventHandler<MouseEvent>() 
					{ 																			
						public void handle(MouseEvent e) 
						{ 
			  
							primaryStage.setScene(scenePagaSocio);
							primaryStage.show();	
						}
					};   		
					InvioAiMetodiPaga.addEventFilter(MouseEvent.MOUSE_CLICKED, eventInvioAPagamentoSocio);
					
					EventHandler<MouseEvent> eventPaga = new EventHandler<MouseEvent>() 
					{ 																			
						public void handle(MouseEvent e) 
						{ 																			
							try 
							{
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); 
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
								if(qgara.isSelected()) 
								{
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); 
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("paga");
									output.println("gara");
									output.println(IMPORTOTEXT.getText());
									output.println(codFisSocio.getText());
									if(cartac.isSelected()) 
									{
										output.println("carta");
									}
									if(iban.isSelected()) 
									{
										output.println("iban");
									}											           
						            output.flush();
									output.close();
								}
								if(qassociazione.isSelected()) 
								{
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); 
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("paga");
									output.println("associazione");
									output.println(IMPORTOTEXT.getText());
									output.println(codFisSocio.getText());
									if(cartac.isSelected()) 
									{
										output.println("carta");
									}
									if(iban.isSelected()) 
									{
										output.println("iban");
									}											           
						            output.flush();
									output.close();
								}
								if(qrimessaggio.isSelected()) 
								{
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream())); 
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("paga");
									output.println("rimessaggio");
									output.println(IMPORTOTEXT.getText());
									output.println(codFisSocio.getText());
									if(cartac.isSelected()) 
									{
										output.println("carta");
									}
									if(iban.isSelected()) 
									{
										output.println("iban");
									}											           
						            output.flush();
									output.close();
								}
								primaryStage.setScene(sceneLoginSocio);
								primaryStage.show();
							} 
							catch (UnknownHostException e1) 
							{							
								e1.printStackTrace();
							} 
							catch (IOException e1) 
							{	
								e1.printStackTrace();
							} 
						}
					};   
					enterpagasocio.addEventFilter(MouseEvent.MOUSE_CLICKED, eventPaga);						
											
					EventHandler<MouseEvent> eventInviodatidellLoginSocio = new EventHandler<MouseEvent>() 
					{ 
						public void handle(MouseEvent e) 
						   { 				
							   try 
							   {	
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("login socio");
									output.println(codFisSocio.getText());
									output.println(PasswordSocio.getText());
									output.flush();									
									String ricevuto_login = read.readLine();
									if(ricevuto_login.equals("true"))
									{
										ugabbian.setVisible(true);
										textCF.setVisible(false);
										textPwd.setVisible(false);
										codFisSocio.setVisible(false);
										PasswordSocio.setVisible(false);
										InvioLoginSocio.setVisible(false);
										InvioAiMetodiBarche.setVisible(true);
										InvioAiMetodiGare.setVisible(true);
										InvioAiMetodiPaga.setVisible(true);
										GESTIONEBARCHETEXT.setVisible(true);
										GESTIONEGARETEXT.setVisible(true);
										GESTIONEPAYTEXT.setVisible(true);
										primaryStage.setScene(sceneLoginSocio);
										primaryStage.show();
									}													
									if(ricevuto_login.equals("login failed"))
									{
										System.out.println("credenziali socio errrate");
									}						
							   } 
							   catch (UnknownHostException e1) 
							   {							   
								   e1.printStackTrace();
							   } 
							   catch (IOException e1) 
							   {
								   e1.printStackTrace();
							   }
						}
					};   													
					InvioLoginSocio.addEventFilter(MouseEvent.MOUSE_CLICKED, eventInviodatidellLoginSocio);
			
					EventHandler<MouseEvent> eventLoginDipendente = new EventHandler<MouseEvent>() 
					{ 																		
						public void handle(MouseEvent e) 
						{ 
							primaryStage.setScene(sceneLoginDipendente);
							primaryStage.show();	
						}
					};   
					EmployeeLogin.addEventFilter(MouseEvent.MOUSE_CLICKED, eventLoginDipendente);
					
				
					
					
					EventHandler<MouseEvent> eventgaraDipendente = new EventHandler<MouseEvent>() 
					{
						public void handle(MouseEvent e) 
						{ 
							try 
							{											
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("visualizza barche");
								output.flush();
								String StringaListaBarche = read.readLine();
								String str3[] = StringaListaBarche.split(",-,");
								List<String> al3 = new ArrayList<String>();
								al3 = Arrays.asList(str3);				
								for(String s: al3)
								{											  
									TEXTAREASOCIOBARCHE.appendText(s + "\n");
								}
								primaryStage.setScene(sceneBarcheSocio);
								primaryStage.show();	
							}
							catch (Exception e1) 
							{										
								e1.printStackTrace();
							}
						}
					};  		
					barchettadmin.addEventFilter(MouseEvent.MOUSE_CLICKED, eventgaraDipendente);
					
					
				
					
					//------------------------INIZIO TEST SCENA GARE------------------------------
					EventHandler<MouseEvent> eventAddGareAdmin= new EventHandler<MouseEvent>() 
					{ 																		
						public void handle(MouseEvent e) 
						{ 
							primaryStage.setScene(sceneAddGara);
							primaryStage.show();	
						}
					};   
					ButtonGestioneGare.addEventFilter(MouseEvent.MOUSE_CLICKED, eventAddGareAdmin);
					
					EventHandler<MouseEvent> eventInvioDatiGareAdmin = new EventHandler<MouseEvent>() 
					{ 
						public void handle(MouseEvent e) 
						{ 
							try 
							{	
								socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("gestione gare");
								output.println(IdGara.getText());
								output.println(QuotaGara.getText());
								output.println(DataGara.getText());
								output.println(LuogoGara.getText());

								output.flush();
								
								primaryStage.setScene(sceneLoginDipendente);
								primaryStage.show();
							} 
							catch (Exception e1) 
							{
								e1.printStackTrace();
							} 	
						}
					};  	
					Aggiungi.addEventFilter(MouseEvent.MOUSE_CLICKED, eventInvioDatiGareAdmin);
					
					//----------------FINE TEST----------------------------------------------
					
					
					EventHandler<MouseEvent> eventInviodatidellLoginDipendente = new EventHandler<MouseEvent>() 
					{ 
						public void handle(MouseEvent e) 
						{ 								
							textIDPERSONALE.setVisible(true);
							textPasswordPersonale.setVisible(true);
							IDPERSONALETEXT.setVisible(true);
							PWDPERSONALETEXT.setVisible(true);
							ENTERAREADIPENDENTI.setVisible(true);
							imgdipendente.setVisible(false);

							try 
							{
							    socket = new Socket("localhost", 9091);
								output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
								read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
								output.println("login dipendente");																		
								output.println(IDPERSONALETEXT.getText());
								output.println(PWDPERSONALETEXT.getText());						
								output.flush();
								String ricevuto_login2 = read.readLine();	 
								if(ricevuto_login2.equals("true2"))
								{
									textIDPERSONALE.setVisible(false);
									textPasswordPersonale.setVisible(false);
									IDPERSONALETEXT.setVisible(false);
									PWDPERSONALETEXT.setVisible(false);
									ENTERAREADIPENDENTI.setVisible(false);
									TEXTAREALISTASOCI.setVisible(true);
									TEXTAREAGARE.setVisible(true);
									TEXTAREABARCHE.setVisible(true);
									TEXTAREALISTAPAGAMENTI.setVisible(true);	
									garatext.setVisible(true); 
									credenzialitext.setVisible(true); 
									barchetext.setVisible(true);
									pagamentitext.setVisible(true);
									barchettadmin.setVisible(true);
									ButtonGestioneGare.setVisible(true);
									//imgdipendente.setVisible(false);
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));								
									output.println("soci");
									output.flush();
									String StringaListaSoci = read.readLine();
									System.out.println("vediamo se lo stampa: " + StringaListaSoci);
									String str[] = StringaListaSoci.split(",-,");
									List<String> al = new ArrayList<String>();
									al = Arrays.asList(str);
									for(String s: al)
									{											  										 
									   TEXTAREALISTASOCI.appendText(s + "\n");
									}
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("visualizza gare");
									output.flush();
									String StringaListaGare = read.readLine();
									String str2[] = StringaListaGare.split(",-,");
									List<String> al2 = new ArrayList<String>();
									al2 = Arrays.asList(str2);										
									for(String s: al2)
									{											  
										TEXTAREAGARE.appendText(s + "\n");
									}	
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("visualizza barche");
									output.flush();
									String StringaListaBarche = read.readLine();
									String str3[] = StringaListaBarche.split(",-,");
									List<String> al3 = new ArrayList<String>();
									al3 = Arrays.asList(str3);								
									for(String s: al3)
									{											  
										TEXTAREABARCHE.appendText(s + "\n");
									}								
									socket = new Socket("localhost", 9091);
									output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
									read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
									output.println("visualizza pagamenti");
									output.flush();
									String StringaListapay = read.readLine();							
									String str5[] = StringaListapay.split(",-,");
									List<String> al5 = new ArrayList<String>();
									al5 = Arrays.asList(str5);									
									for(String s: al5)
									{											  								  
										TEXTAREALISTAPAGAMENTI.appendText(s + "\n");
									}								
									primaryStage.setScene(sceneLoginDipendente);
									primaryStage.show();
								}
								
									if(ricevuto_login2.equals("login failed"))
									{
										System.out.println("credenziali dipendente errrate");
									}								   
							}
							   
							catch (UnknownHostException e1) 
							{								
								e1.printStackTrace();
							} 
							catch (IOException e1) 
							{							
								e1.printStackTrace();
							}
						}
					};
					ENTERAREADIPENDENTI.addEventFilter(MouseEvent.MOUSE_CLICKED, eventInviodatidellLoginDipendente);
					
		}
		catch (Exception e)
		{           
            e.printStackTrace();
		}
	}
	
	/**
  	 * Creation of the client and set/get of the socket
  	 * 
  	 * 
  	 */ static void main(String args[])
	{    
	    System.out.println("Avvio client");
	    launch(args);	    
	}

	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @return the read
	 */
	public BufferedReader getRead() {
		return read;
	}

	/**
	 * @param read the read to set
	 */
	public void setRead(BufferedReader read) {
		this.read = read;
	}

	/**
	 * @return the output
	 */
	public PrintWriter getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(PrintWriter output) {
		this.output = output;
	}
}


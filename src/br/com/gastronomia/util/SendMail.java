package br.com.gastronomia.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

/**
 * Classe para realizar o envio de e-mails.
 *
 * @author Rodrigo Machado - rodrigo.domingos@acad.pucrs.br
 * @since 09/06/2017
 *
 **/
public class SendMail {
	
	private static final Logger LOGGER = Logger.getLogger(SendMail.class);
	
	public SendMail() {
		// TODO Auto-generated constructor stub
	}

	public void envio(String emailDestinatario, String destinatario, String assunto, String corpo) {
		try {
			SimpleEmail email = new SimpleEmail();
			// Servidor SMTP para envio do e-mail
			email.setHostName("smtp.gmail.com");

			email.setAuthenticator(new DefaultAuthenticator("ideiasages@gmail.com", "agesideias2017"));
			email.setSSLOnConnect(true);
			email.setSSLCheckServerIdentity(true);
			email.addTo(emailDestinatario, destinatario);

		  // Remetente
			email.setFrom("ages@pucrs.br","AGES - Agencia Experimental de Engenharia de Software" );

			// Assunto
			email.setSubject(assunto);

			// Corpo
			email.setMsg(corpo); // Conte�do

			// Envio
			email.send();

		} catch (EmailException e) {
			// TODO Auto-generated catch block
			LOGGER.debug("An E-mail Exception has occurred", e);
		}

	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.usuarios;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 10 Spring Creators
 */
public class Correo {
    
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = "sicvosnld@gmail.com";  //Para la dirección nomcuenta@gmail.com

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", "Sicvos148");    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, "Sicvos148");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (MessagingException me) {
            me.printStackTrace();   //Si se produce un error
        }
    }
    public static void enviarMasivo(String destinatario[], String cuerpo) {
        // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
        String remitente = "sicvosnld@gmail.com";  //Para la dirección nomcuenta@gmail.com
        String asunto = "No te lo pierdas! - BeFree Gym";

        for(int i=0;i<destinatario.length;i++){
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", "Sicvos148");    //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(remitente));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario[i]));   //Se podrían añadir varios de la misma manera
                message.setSubject(asunto);
                message.setText(cuerpo);
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, "Sicvos148");
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            catch (MessagingException me) {
                me.printStackTrace();   //Si se produce un error
            }
        }
    }
}

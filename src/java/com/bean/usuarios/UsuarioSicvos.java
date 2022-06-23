/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean.usuarios;

import com.bean.facade.UsuarioBean;
import com.controller.ControllerFactory;
import com.controller.ControllerFactoryMethod;
import com.controller.UsuarioJpaController;
import com.modelo.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author 10 Spring Creators
 */
public class UsuarioSicvos implements Serializable{
    
    private int id;
    private static boolean terminos = false;
    private String prom;
    private String contraseña;
    private String pNombre;
    private String pApellido;
    private String correo;
    private Usuario u = new Usuario();
    private ControllerFactoryMethod jpa = new ControllerFactory();
    
    public String validaLogin() {
        
        UsuarioJpaController user =new UsuarioJpaController();
        try {
            u = user.validarUsuario(id, contraseña);
            pNombre = u.getPrimerNombre();
            pApellido = u.getPrimerApellido();
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("BefreeUser", u);
            return u.getTipo();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String regUsuario() throws Exception{
        u.setTipo("CLIENTE");
        jpa.create(u);
        return "login";
        
    }
    
    public String editProfile(int i) {
        
        u= (Usuario) jpa.findEntity(id, u.getClass().getSimpleName());
        try {
            if(i==1){
                u.setContraseña(contraseña);
                jpa.edit(u);
            }else if(i==2){
                u.setCorreo(correo);
                jpa.edit(u);
            }
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
    
    public String profile() {
        u= (Usuario) jpa.findEntity(id, u.getClass().getSimpleName());
        correo=u.getCorreo();
        contraseña=u.getContraseña();
        return "perfil";
    }
    
    public String enviac() {
        try {
            String key = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            String password = "";
            
            for (int i = 0; i < 9; i++) {
                password+=(key.charAt((int)(Math.random() * key.length())));
            }
            u= (Usuario) jpa.findEntity(id, u.getClass().getSimpleName());
            u.setContraseña(password);
            String asunto="SICVOS - Recuperación de contraseña";
            String cuerpo = ("Estimado(a) "+u.getPrimerNombre()+" "+u.getPrimerApellido()+" hemos recuperado tu contraseña, intenta ingresar nuevamente con tu respectivo id de usuario y contraseñaLe recordamos que esta dirección de e-mail es utilizada solamente para los envíos de la información solicitada. Por favor no responda con consultas personales ya que no podrán ser respondidas.\n" +
                "\n"+
                "Contraseña: "+password+"\n"+
                "\n"+
                "Cordialmente.\n" +
                "\n" +
                "SICVOS - Befree Gym.");
            String destinatario =u.getCorreo();
            Correo.enviarConGMail(destinatario, asunto, cuerpo);
            jpa.edit(u);
            return "enviac";
        } catch (Exception e) {
            
            return "";
        }
    }
    
    public String enviarProm(){
        List<Usuario> dest = new ArrayList();
        dest = jpa.findAllEntities("Usuario");
        for(int i=0; i < dest.size() ; i++){
            if("ADMINISTRADOR".equals(dest.get(i).getCorreo())||"ENTRENADOR".equals(dest.get(i).getCorreo())){
                dest.remove(i);
            }
        }
        String[] destinatario = new String[dest.size()];
        for(int i=0; i < destinatario.length ; i++){
            destinatario[i]=dest.get(i).getCorreo();
        }
        Correo.enviarMasivo(destinatario, prom);
        return "";
    }
    
    public void datos(){
        setId(id);
        setpNombre(pNombre);
        setpApellido(pApellido);
    }
    
    //Setters y Getters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getU() {
        return u;
    }

    public void setU(com.modelo.Usuario u) {
        this.u = u;
    }

    public String getProm() {
        return prom;
    }

    public void setProm(String prom) {
        this.prom = prom;
    }

    public boolean isTerminos() {
        return terminos;
    }

    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }
    
    
}

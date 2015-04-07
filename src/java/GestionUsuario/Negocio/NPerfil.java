/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.Negocio;

import GestionUsuario.Entidades.EPerfil;
import GestionUsuario.Entidades.EUsuario;
import GestionUsuario.FileManager.FileManager;
import GestionUsuario.Util.GV;
import java.util.List;

/**
 *
 * @author Lion
 */
public class NPerfil {
    private EPerfil perfil;

    public NPerfil() {
    }

    public NPerfil(EPerfil perfil) {
        this.perfil = perfil;
    }
    public EPerfil getPerfilByUsername(EUsuario user){
        EPerfil perfil=new EPerfil();
        List lp=FileManager.getAllObject(perfil, GV.nameArchivoPerfil);
        for (Object lp1 : lp) {
            EPerfil p=(EPerfil) lp1;
            if(p.getUsername().equals(user.getUsername()))
                return p;
        }
        perfil=null;
        return perfil;
    }
    
}

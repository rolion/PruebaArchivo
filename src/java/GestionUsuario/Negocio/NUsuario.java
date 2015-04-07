/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUsuario.Negocio;

import GestionUsuario.Entidades.EUsuario;
import GestionUsuario.FileManager.FileManager;
import GestionUsuario.Util.GV;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Lion
 */
public class NUsuario {
    
    private EUsuario user;

    public NUsuario() {
    }

    public NUsuario(EUsuario user) {
        this.user = user;
    }
    public boolean existeUsuario(EUsuario user){
        boolean rstl=false;
        List lu=FileManager.getAllObject(user, GV.nameArchivoUsuario);
        for (Object u1 : lu) {
            EUsuario u= (EUsuario) u1;
            if(Objects.equals(u.getUsername(), user.getUsername()) && 
                    Objects.equals(u.getPassword(), user.getPassword())){
                user.setGroupName(u.getGroupName());
                return true;
            }
        }
        return rstl;
    }
    
}

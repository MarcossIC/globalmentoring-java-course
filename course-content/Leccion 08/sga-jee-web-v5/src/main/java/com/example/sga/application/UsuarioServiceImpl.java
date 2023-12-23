
package com.example.sga.application;

import com.example.sga.domain.UsuarioDao;
import com.example.sga.domain.Usuario;
import com.example.sga.domain.UsuarioServiceLocal;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioServiceImpl implements UsuarioServiceLocal {

    @Inject
    private UsuarioDao userDao;

    @Override
    public List<Usuario> listarUsuarios() {
       return userDao.findAllUsuario();
    }

    @Override
    public Usuario buscarUsuarioPorId(Usuario user) {
        return userDao.findUsuarioById(user);
    }

    @Override
    public Usuario buscarUsuarioPorUsername(Usuario user) {
        return userDao.findUsuarioByUsername(user);
    }

    @Override
    public void registarUsuario(Usuario user) {
        userDao.insertUsuario(user);
    }

    @Override
    public void modificarUsuario(Usuario user) {
        userDao.updateUsuario(user);
    }

    @Override
    public void eliminarUsuario(Usuario user) {
        userDao.deleteUsuario(user);
    }
    
    
}

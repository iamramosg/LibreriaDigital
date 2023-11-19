/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.libreria.AppService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.utl.idgs.libreria.model.Libro;
import org.utl.idgs.libreria.CQRS.LibroCQRS;
import org.utl.idgs.libreria.ViewModels.LibroPublicViewModel;
import org.utl.idgs.libreria.ViewModels.UsuarioPublicViewModel;
import org.utl.idgs.libreria.dao.LibroDao;

/**
 *
 * @author iamra
 */
public class LibroAppService {

    public Libro registroLibro(Libro l) throws Exception {
        LibroCQRS cqrs = new LibroCQRS();
        Libro lbr = cqrs.insertarLibro(l);

        if (l == null) {
            throw new Exception("Error al insertar");
        }

        return lbr;
    }

    public Libro restablecerLibro(Libro l) throws Exception {
        LibroCQRS cqrs = new LibroCQRS();
        cqrs.actualizarLibro(l);
        return l;
    }

    public List<Libro> buscarLibro(Libro l) throws SQLException {
        LibroDao dao = new LibroDao();
        List<Libro> lbr = dao.buscarLibro(l.getTitulo());
        return lbr;
    }

    public List<LibroPublicViewModel> buscarLibroPublic(Libro l) throws Exception {
        LibroDao dao = new LibroDao();
        List<Libro> lbr = dao.buscarLibro(l.getTitulo());
        List<LibroPublicViewModel> list_lvm = new ArrayList<>();

        for (int i = 0; i < lbr.size(); i++) {
            LibroPublicViewModel lvm = new LibroPublicViewModel(String.valueOf(lbr.get(i).getIdLibro()), lbr.get(i).getTitulo(), lbr.get(i).getArchivo(), lbr.get(i).getAutor());
            list_lvm.add(lvm);
        }

        return list_lvm;
    }

    public List<Libro> getAllLibro() throws SQLException {
        LibroDao dao = new LibroDao();
        List<Libro> lbr = dao.getAll();
        return lbr;
    }

    public List<LibroPublicViewModel> getAllLibroPublic() throws Exception {
        LibroDao dao = new LibroDao();
        List<Libro> lbr = dao.getAll();
        List<LibroPublicViewModel> list_lvm = new ArrayList<>();

        for (int i = 0; i < lbr.size(); i++) {
            LibroPublicViewModel lvm = new LibroPublicViewModel(String.valueOf(lbr.get(i).getIdLibro()), lbr.get(i).getTitulo(), lbr.get(i).getArchivo(), lbr.get(i).getAutor());
            list_lvm.add(lvm);
        }

        return list_lvm;
    }
}

package com.sena.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.sena.spring.model.Album;
import com.sena.spring.model.Genero;
import com.sena.spring.model.IGenero;

import com.sena.spring.model.IAlbum;


@Controller
@SessionAttributes("album")
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private IAlbum albumd;

    @Autowired
    private IGenero em;

    @GetMapping(path={"/listar","","/"})
    public String listar(Model m) {
        m.addAttribute("albums", albumd.findAll());
        return "album/listar";
    }

    @GetMapping("/ver")
    public String verc(Model m){
        Album al=new Album();
        al.setId_album(1);
        al.setNombre_album("Lina");
        al.setAni_publicacion("2022");
        al.setEstado_album(false); 
        m.addAttribute("album", al);
        return "album/ver";
    }

    /*@GetMapping("/ver")
    public String ver(@RequestParam int id,String nombreAlbum,Model m){
        m.addAttribute("msn", "En la ruta llegó el id "+id+" y el nombre recibido es "+nombreAlbum);
        return "album/ver";
    }*/

    @GetMapping(path={"/ver/{id_album}"})
    public String ver(@PathVariable int id_album, Model m){
        Album album=null;
        List<Genero> generos=em.findAll();
        if(id_album>0){
            album=albumd.findOne(id_album);
        }else{
            return "redirect:listar";
        }
        m.addAttribute("album", album);
        m.addAttribute("genero", generos);
        m.addAttribute("accion", "Actualizar Album");
        return "album/form";
    }
    
    @GetMapping(path={"/form"})
    public String form(Model m) {
        Album album=new Album();
        List<Genero> generod=em.findAll();
        m.addAttribute("album", album);
        m.addAttribute("genero", generod);
        m.addAttribute("accion", "Agregar Album");
        return "album/form";
    }

    @PostMapping("/add")
    public String add(@Valid Album album, BindingResult res, Model m, SessionStatus status) {
        if(res.hasErrors()){
            return "album/form";
        }
        /*m.addAttribute("album", album);
        return "album/ver";*/
        albumd.save(album);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/delete/{id_album}")
    public String delete(@PathVariable Integer id_album){
        if(id_album>0){
            albumd.delete(id_album);
        }
        return "redirect:../listar";
    }
    
    
}
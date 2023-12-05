package com.vitalusus.vitalususplus.controller;

import com.vitalusus.vitalususplus.model.Admin;
import com.vitalusus.vitalususplus.model.Treinador;
import com.vitalusus.vitalususplus.model.Usuario;
import com.vitalusus.vitalususplus.repository.AdminRepository;
import com.vitalusus.vitalususplus.repository.TreinadorRepository;
import com.vitalusus.vitalususplus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//localhost:8080/Vitalusus-2h/Clientes/listaClientes --> -->
//--> --> endereço para adiantar para quem for entrar na página para ver se tá tudo certo na parte web ;)

//Começo da classe
@Controller
//código que define os endereços das páginas, as "/" GetMappings vem depois disso. Exemplo "/Vitalusus-2h/Clientes/ListaClientes"
@RequestMapping("/Vitalusus-2h/Clientes")
public class UsuarioController {

    //negócio que liga dá acesso ao repository do usuário
    @Autowired
    private UsuarioRepository usuarioRepository;

    //negócio que liga dá acesso ao repository do treinador
    @Autowired
    private TreinadorRepository treinadorRepository;

    //negócio que liga dá acesso ao repository do administrador
    @Autowired
    private AdminRepository adminRepositoryy;

    //código que cria a localiação da página index
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    //código que cria a localiação da página cadastrar
    @GetMapping("/cadastrar")
    public String cadastrar(){
        return "CADASTRAR";
    }

    //código que coloca os registros digitados pelo usuário ao cadastrar no banco de dados
    @PostMapping("/cadastrar")
    public String enviarCadastro(Usuario usuario, Treinador treinador, Admin admin){
        usuario.setStatusUsuario("ativo");
        String page = "redirect:/Vitalusus-2h/Clientes/clienteSucesso";
        Usuario usuarioDb = usuarioRepository.findByEmail(usuario.getEmail());
        Treinador treinadorDb = treinadorRepository.findByCref(treinador.getCref());
        if (usuarioDb !=  null ) page = "CADASTRARTEMEMAIL";
        else if(treinadorDb !=null) page = "CADASTRARTEMCREF";
        else if (treinadorDb !=null && usuarioDb !=null) page = "CADASTRARTEMEMAILCREF";
        else{
        if (usuario.getTipoPessoa().equals("Treinador(a)")){
            treinadorRepository.save(treinador);
            treinador.setUsuario(usuario);
            usuario.setTreinador(treinador);
        }
        usuarioRepository.save(usuario);
        }
        return page;
    }

    //código que cria a localiação da página clienteSucesso
    @GetMapping("/clienteSucesso")
    public String clienteSucesso(){
        return "clienteSucesso";
    }

    //código que cria a localiação da página listaCLientes
    @GetMapping("/listaClientes")
    public ModelAndView usuarios(){
        ModelAndView mv = new ModelAndView("clientes");
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios",usuarios);
        return mv;
    }

    //código que cria a localiação da página login
    @GetMapping("/login")
    public String showFormLogin(){
        return "LOGIN";
    }

    //código que verifica se o login e senha que o usuário digitou são válidos
    @PostMapping("/login")
    public ModelAndView efetuarLogin(@ModelAttribute Usuario usuario){
        ModelAndView page = new ModelAndView();
        usuario = usuarioRepository.findByLogin(usuario.getEmail(), usuario.getSenha());
        if (usuario ==null) page.setViewName("LOGIN");
        else page.setViewName("HomeTreinador"); 
        page.addObject("usuario",usuario);
        return page;
    }

    //código que cria a localiação da página homeTreinaodor
    @GetMapping("/HomeTreinador/{id}")
    public ModelAndView usuariodetalhes(@PathVariable("id") Long id ){
        ModelAndView mv = new ModelAndView("HomeTreinador");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }

    //código que cria a localiação da página configT
    @GetMapping("/configT/{id}")
    public ModelAndView config(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("configT");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }

    //código que cria a localização da página confirmarDeletar
    @GetMapping("/confirmarDeletar")
    public String confirmarDeletar(){
        return "confirmarDeletar";
    }

    //código que deleta o usuario pela página listaClientes
    @GetMapping("/deletar{id}")
    public String deletarNormal(@ModelAttribute Usuario usuario, Treinador treinador){
        usuario = usuarioRepository.findById(usuario.getId());
        treinador = treinadorRepository.findById(usuario.getId()-1);
        usuario.setTreinador(null);
        treinador.setUsuario(null);
        usuario.setStatusUsuario("inativo");
        treinadorRepository.save(treinador);
        treinadorRepository.delete(treinador);
        usuarioRepository.save(usuario);
        usuarioRepository.delete(usuario);
        return "redirect:/Vitalusus-2h/Clientes/listaClientes";
    }

    //código que deleta o uusário
    @PostMapping("/confirmarDeletar")
    public String deletar(@ModelAttribute Usuario usuario, Treinador treinador){
        String page = "redirect:/Vitalusus-2h/Clientes/confirmarDeletar";
        Usuario usuarioDb = usuarioRepository.findByLogin(usuario.getEmail(), usuario.getSenha());
        treinador =  treinadorRepository.findById(usuario.getId()-1);
        if (usuarioDb !=null && usuario.getSenha().equals(usuarioDb.getSenha())&&usuario.getEmail().equals(usuario.getEmail())){
            page = "redirect:/Vitalusus-2h/Clientes/index";
            usuarioDb.setTreinador(null);
            treinador.setUsuario(null);
            usuarioDb.setStatusUsuario("inativo");
            treinadorRepository.save(treinador);
            treinadorRepository.delete(treinador);
            usuarioRepository.save(usuarioDb);
            usuarioRepository.delete(usuarioDb);
        }
        return page;
    }
    //código que cria a localização da página confirmarEditar
    @GetMapping("/confirmarEditar")
    public String confirmarEditar(){
        return "confirmarEditar";
    }

    //código que cria a localização da página editar
    @GetMapping("/editar/{id}")
    public ModelAndView entrarEditar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("editarSuaConta");
        Usuario usuario = usuarioRepository.findById(id);
        Treinador treinador = treinadorRepository.findById(id-1);
        mv.addObject("usuario",usuario);
        mv.addObject("treinador",treinador);
        return mv;
    }

    //código que cria a localização da página editar que executa método put
    @GetMapping("/editar{id}")
    public ModelAndView editar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("clienteSucesso");
        Usuario usuario = usuarioRepository.findById(id);
        Treinador treinador = treinadorRepository.findById(usuario.getId()-1);
        return mv;
    }

    //código que edita o usuário e seta ele de novo como ativo, porque se não fizer isso, o statusUsuario fica nulo e ninguém quer que ele fique nulo
    @PostMapping("/editar{id}")
    public ModelAndView editar(Usuario usuario, Treinador treinador){
        ModelAndView mv = new ModelAndView();
        treinador = treinadorRepository.findById(usuario.getId()-1);
        usuario.setTreinador(treinador);
        usuario.setStatusUsuario("ativo");
        usuarioRepository.save(usuario);
        mv.setViewName("redirect:/Vitalusus-2h/Clientes/login");
        return mv;
    }

    //Código que verifica se o email e senha estão certos na página confirmarEditar, funciona igual o login, basicamente
    @PostMapping("/confirmarEditar")
    public ModelAndView entrarNoEditar(@ModelAttribute Usuario usuario, Treinador treinador){
        ModelAndView page = new ModelAndView();
        usuario = usuarioRepository.findByLogin(usuario.getEmail(), usuario.getSenha());
        treinador = treinadorRepository.findById(usuario.getId()-1);
        if (usuario ==null)  page.setViewName("confirmarEditar");
        else page.setViewName("EditarSuaConta");
        page.addObject("usuario",usuario);
        page.addObject("treinador",treinador);
        return page;
    }

    //código que cria a localização da página user
    @GetMapping("/user/{id}")
    public ModelAndView user(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("user");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        mv.addObject("treinador",usuario.getTreinador());
        return mv;
    }

    //código que cria a localização da página esqueceuSenha
    @GetMapping("/esqueceuSenha")
    public String esqueceuSenha(){
        return "esqueceuSenha";
    }

    //código que cria a localização da página estatisticas
    @GetMapping("/Estatisticas/{id}")
    public ModelAndView estatisticas(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("Estatisticas");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }

    //código que cria a localização da página publicar
    @GetMapping("/publicar/{id}")
    public ModelAndView publicar(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("publicar");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }

    //código que cria a localização da página sobre nos
    @GetMapping("/Sobre-nos/{id}")
    public ModelAndView sobreNos(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("Sobre-nos");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }

    //código que cria a localização da página bibliotecaVideos
    @GetMapping("/bibliotecaVideos/{id}")
    public ModelAndView biblioteca(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("bibliotecaVideos");
        Usuario usuario = usuarioRepository.findById(id);
        mv.addObject("usuario",usuario);
        return mv;
    }
}




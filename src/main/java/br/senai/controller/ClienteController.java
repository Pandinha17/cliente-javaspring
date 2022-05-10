package br.senai.controller;

import br.senai.model.Cliente;
import br.senai.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    @GetMapping("/cliente/List")
    public String findAll(Model model){
        model.addAttribute("cliente", clienteService.findAll());
        return "cliente/List";
    }


   @GetMapping("/cliente/Add")
    public String add(Model model) { return "cliente/add"; }

    @GetMapping("/cleinte/Edit/{id}")
    public String Edit(Model model, @PathVariable long id){
        System.out.println("ID:" + id);
        model.addAttribute("cliente", clienteService.findById(id));
        return "cliente/edit";
    }

    @PostMapping("/cliente/save")
    public void save(Cliente cliente) {
        try {
            clienteService.save(cliente);
        } catch (Exception e) {
            throw e;
        }
    }







}

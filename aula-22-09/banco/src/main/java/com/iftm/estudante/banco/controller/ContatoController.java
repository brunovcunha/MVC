package com.iftm.estudante.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.iftm.estudante.banco.dao.ContatoDao;
import com.iftm.estudante.banco.domain.Contato;

@Controller

public class ContatoController {

    @Autowired

    private ContatoDao dao;

    @RequestMapping("contatos")

    public String getContatos(Model model) {
        List<Contato> contatos = dao.getContatos();
        model.addAttribute("contatos", contatos);
        return "contatosList";

    }

    @RequestMapping("contatosParametro")

    public String getContatos(@RequestParam(value = "nome", required = true) String nome, Model model) {
        model.addAttribute("contatos", dao.getContatos(nome));
        return "contatosList";
    }

}
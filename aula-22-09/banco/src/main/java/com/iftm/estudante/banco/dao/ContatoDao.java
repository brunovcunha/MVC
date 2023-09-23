package com.iftm.estudante.banco.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.iftm.estudante.banco.domain.Contato;

@Component
public class ContatoDao {

    @Autowired
    JdbcTemplate db;

    public List<Contato> getContatos() {
        String sql = "select email,nome from tb_contato";

        return db.query(sql, (res, rowNum) -> {
            return new Contato(
                    res.getString("nome"),
                    res.getString("email"));
        });
    }

    public List<Contato> getContatos(String nome) {

        String sql = "select email,nome from tb_contato where lower(nome) like ?";

        return db.query(sql,
                new BeanPropertyRowMapper<>(Contato.class),
                new Object[] { "%" + nome + "%" });
    }
}

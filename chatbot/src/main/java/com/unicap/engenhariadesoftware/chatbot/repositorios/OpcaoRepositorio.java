package com.unicap.engenhariadesoftware.chatbot.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;

import com.unicap.engenhariadesoftware.chatbot.modelos.Opcao;

public interface OpcaoRepositorio extends JpaRepository<Opcao, Long>{

	Opcao findById(long id);
}

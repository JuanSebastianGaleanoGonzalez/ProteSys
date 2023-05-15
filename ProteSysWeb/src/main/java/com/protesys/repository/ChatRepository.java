package com.protesys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.protesys.utils.chat.Chat;

@Repository
public interface ChatRepository extends CrudRepository<Chat, Long>{
}

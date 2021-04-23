package com.colval.messenger20.services;

import com.colval.messenger20.model.DTO.MessageDto;
import com.colval.messenger20.model.entities.Messages;

public interface IMessageService {

    Messages create(MessageDto message, String username);
}

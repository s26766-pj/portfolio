package org.carrental.service;

import org.carrental.model.client.Client;
import org.springframework.stereotype.Service;

public interface ClientService {
    Client getById(Integer clientId);
}

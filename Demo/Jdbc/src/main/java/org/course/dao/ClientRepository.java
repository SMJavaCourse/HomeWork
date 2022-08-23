package org.course.dao;

import org.course.entity.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ClientRepository extends Repository<Client, String> {
    protected static final Map<String, Client> clientById = new HashMap<>();
    private static volatile ClientRepository instance;

    public static ClientRepository getInstance() {
        var localInstance = instance;
        if (localInstance == null) {
            synchronized (ClientRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ClientRepository();
                }
            }
        }
        return localInstance;
    }

    private ClientRepository() {
    }

    public List<Client> all() {
        return new ArrayList<>(clientById.values());
    }

    public Client save(Client client) {
        if (client.getId() == null) {
            client.setId(UUID.randomUUID().toString());
        }
        clientById.put(client.getId(), client);
        return client;
    }

    public Client byId(String id) {
        return clientById.get(id);
    }

    public Client delete(String id) {
        return clientById.remove(id);
    }

    void deleteAll() {
        clientById.clear();
    }

}

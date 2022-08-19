package org.course.service;

import org.course.TestBase;
import org.course.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.emptyIterable;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ClientServiceTest extends TestBase {
    private final ClientService clientService = new ClientService();

    @ParameterizedTest
    @ValueSource(strings = {"Иван", "Ivan", "Ivан"})
    void saveClient_shouldSuccessfullySaveWithDifferentFirstnames(String firstName) {
        var client = given.clients().with(c -> c.setFirstName(firstName)).buildSingle();
        var savedClient = clientService.saveClient(client);
        assertNotNull(savedClient);
        assertEquals(client.getId(), savedClient.getId());
        assertEquals(firstName, savedClient.getFirstName());
    }

    @ParameterizedTest
    @MethodSource("generateClients")
//    @NullSource
    void saveClient_shouldSuccessfullySaveClient(Client client) {
        var savedClient = clientService.saveClient(client);
        assertNotNull(savedClient);
        assertEquals(client.getId(), savedClient.getId());
    }

    public static Stream<Client> generateClients() {
        return given.clients().withSome(3).build().stream();
    }

    @ParameterizedTest
    @MethodSource
    void saveClient_shouldSuccessfullySaveWithDifferentNames(String firstName, String lastName) {
        var client = given.clients().with(c -> {
            c.setFirstName(firstName);
            c.setLastName(lastName);
        }).buildSingle();
        var savedClient = clientService.saveClient(client);
        assertNotNull(savedClient);
        assertEquals(client.getId(), savedClient.getId());
        assertEquals(firstName, savedClient.getFirstName());
    }

    static Stream<Arguments> saveClient_shouldSuccessfullySaveWithDifferentNames() {
        return Stream.of(
                Arguments.of("Ivan", "Ivanov"),
                arguments("Иван", "Иванов"),
                arguments("Ivan", "Иванов"),
                arguments("Иван", "Ivanov")
        );
    }


    /* Hamcrest */
    @Test
    public void getClientWithCars_shouldSuccessfullyFoundClientCars() {
        var cars = given.cars().withSome(3).build();
        var client = given.clients().withAny().buildSingle();
        var repairRequests = given.repairRequests().withSome(
                        3,
                        index -> rr -> {
                            rr.setCarVin(cars.get(index).getVin());
                            rr.setClientId(client.getId());
                        })
                .build();

        var clientWithCars = clientService.getClientWithCars(client.getId());
        assertNotNull(clientWithCars);
        assertThat(clientWithCars.getCars(), not(emptyIterable()));
        assertThat(clientWithCars.getCars(), hasSize(3));
        assertEquals(3, clientWithCars.getCars().size());

        assertThat(clientWithCars.getCars(), hasItem(cars.get(0)));
        assertThat(clientWithCars.getCars(), containsInAnyOrder(cars.toArray()));

        var someAnotherCar = given.cars().withAny().buildSingle();
        assertThat(clientWithCars.getCars(), hasItem(someAnotherCar));

    }
}

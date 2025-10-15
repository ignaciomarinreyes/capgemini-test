package com.capgemini.test.code.user.infrastructure.service;

import com.capgemini.test.code.user.application.exception.InvalidDniException;
import com.capgemini.test.code.user.application.port.out.IDniPort;
import com.capgemini.test.code.user.infrastructure.controller.dto.CheckDniRequest;
import com.capgemini.test.code.user.infrastructure.controller.dto.CheckDniResponse;
import com.capgemini.test.code.user.infrastructure.service.mapper.UserInfrastructureServiceMapper;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DniClient implements IDniPort {

    private final IDniClient dniClient;
    private final UserInfrastructureServiceMapper userInfrastructureServiceMapper;

    public DniClient(IDniClient dniClient, UserInfrastructureServiceMapper userInfrastructureServiceMapper) {
        this.dniClient = dniClient;
        this.userInfrastructureServiceMapper = userInfrastructureServiceMapper;
    }

    @Override
    public void validateDni(String dni) {
        CheckDniRequest checkDniRequest = userInfrastructureServiceMapper.toCheckDniRequest(dni);
        try {
            dniClient.check(checkDniRequest);
        } catch (FeignException exception) {
            throw new InvalidDniException(dni);
        }
    }
}

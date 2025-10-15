package com.capgemini.test.code.user.infrastructure.spring;

import com.capgemini.test.code.user.application.port.out.IDniPort;
import com.capgemini.test.code.user.application.port.out.INotificationPort;
import com.capgemini.test.code.user.application.port.out.IRoomPort;
import com.capgemini.test.code.user.application.port.out.IUserPort;
import com.capgemini.test.code.user.application.service.UserApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserApplicationService createUserUseCase(IUserPort userPort, IRoomPort roomPort, IDniPort dniPort, INotificationPort notificationPort) {
        return new UserApplicationService(userPort, roomPort, dniPort, notificationPort);
    }
}

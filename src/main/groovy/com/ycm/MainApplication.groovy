package com.ycm

import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

@Slf4j
@SpringBootApplication
class MainApplication {

    public static final String COMMAND = 'ycm.command'

    public static void main(String... args) throws Exception {
        final ApplicationContext applicationContext = SpringApplication.run MainApplication, args
        final String command = applicationContext.getEnvironment().getRequiredProperty(COMMAND)
        final CliCommand cliCommand = applicationContext.getBean(command) as CliCommand
        cliCommand.execute()
    }
}
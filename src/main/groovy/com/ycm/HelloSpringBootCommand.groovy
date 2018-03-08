package com.ycm

import com.ycm.model.Database
import com.ycm.model.Payment
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

import javax.inject.Inject

@Slf4j
@Component("say_hello")
class HelloSpringBootCommand implements CliCommand {

    //this obj is injected through constructor, we mark it as final to explicitly maintain the immutable state
    //if all such fields are final, the HelloSpringBootCommand itself is immutable, which is ideal
    final Database db

    //demonstrating how an object can be injected in a diff way (besides the constructor injection)
    //note that because we need to let Spring not groovy interpret this string hello.world.env.notification
    //that is why we should use single quote '${...}' so that groovy wont take over to interpret it as GString
    //Groovy syntax - @Value('${hello.world.env.notification}')
    //Java syntax - @Value("${hello.world.env.notification}")
    @Inject
    Payment payment

    //demonstrating how an simple attribute can be injected in a diff way (besides the constructor injection)
    @Value('${hello.world.env.notification}')
    final String envNotification

    //demonstrating how this object can be instantiated through constructor injection
    //this initialization is preferred than the 'payment' object injection
    //because if the fields are all initialized through constructor injection and marked as final,
    //this HelloSpringBootCommand is immutable and thread-safe
    @Inject
    def HelloSpringBootCommand(Database db) {
        this.db = db
    }

    @Override
    def void execute() {
        log.info("say hi...")
        sayHello()

        log.info("loading database information...")
        connectToDatabase()

        log.info("making payment...")
        payMerchant()

        log.info("exiting the application...")
    }

    private sayHello() {
        log.warn("environment notification: ${envNotification}")
    }

    private connectToDatabase() {
        log.info("db url is ${db.url}")
        log.info("db username is ${db.username}")
        log.info("db password is ${db.password}")
        log.info("connecting to database...")
        log.info("connected to database...")
    }

    private payMerchant() {
        log.info("the payment method is ${payment.method}")
    }
}

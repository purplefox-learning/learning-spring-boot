package com.ycm.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix="payment")
@Component
class Payment {
    String method
}

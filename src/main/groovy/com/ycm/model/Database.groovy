package com.ycm.model

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties(prefix="database")
@Component
class Database {
    String url
    String username
    String password
}

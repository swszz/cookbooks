package com.swszz.cookbooks.reactivefeign

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactivefeign.spring.config.EnableReactiveFeignClients
import reactivefeign.webclient.WebReactiveOptions
import reactor.netty.resources.ConnectionProvider
import java.time.Duration

/**
 * @author: swszz
 */

@Configuration
@EnableReactiveFeignClients
class ReactiveFeignConfiguration {
    @Bean
    fun webReactiveOptions(): WebReactiveOptions {
        return WebReactiveOptions.Builder()
            .setReadTimeoutMillis(MAX_TIMEOUT_TO_MILLISECOND.toMillis())
            .setResponseTimeoutMillis(MAX_TIMEOUT_TO_MILLISECOND.toMillis())
            .setConnectionProvider(connectionProvider())
            .setConnectTimeoutMillis(MAX_TIMEOUT_TO_MILLISECOND.toMillis())
            .build()
    }

    fun connectionProvider(): ConnectionProvider {
        return ConnectionProvider.builder(WEB_CLIENT_NAME)
            .maxConnections(MAX_CONNECTION_POOL_SIZE)
            .maxIdleTime(MAX_TIMEOUT_TO_MILLISECOND)
            .maxLifeTime(MAX_TIMEOUT_TO_MILLISECOND)
            .pendingAcquireTimeout(MAX_TIMEOUT_TO_MILLISECOND)
            .pendingAcquireMaxCount(MAX_PENDING_ACQUIRE_COUNT)
            .evictInBackground(EVICT_IN_BACKGROUND_TO_MILLISECOND)
            .lifo()
            .metrics(METRICS_ENABLED)
            .build()
    }

    companion object {
        // unlimited
        private const val WEB_CLIENT_NAME: String = "client"
        private const val MAX_PENDING_ACQUIRE_COUNT: Int = -1
        private const val MAX_CONNECTION_POOL_SIZE: Int = 100
        private const val METRICS_ENABLED: Boolean = true
        private val EVICT_IN_BACKGROUND_TO_MILLISECOND = Duration.ofMillis(1000L)
        private val MAX_TIMEOUT_TO_MILLISECOND: Duration = Duration.ofMillis(1000L)
    }
}
package com.github.venth.swagger_ui_webflux.test;

import io.netty.util.concurrent.SingleThreadEventExecutor;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import reactor.blockhound.BlockHound;
import reactor.blockhound.integration.ReactorIntegration;

public class BlockHoundExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        BlockHound.builder()
                .with(new ReactorIntegration())
                .allowBlockingCallsInside(
                        SingleThreadEventExecutor.class.getName(),
                        "confirmShutdown")
                .install();
    }
}

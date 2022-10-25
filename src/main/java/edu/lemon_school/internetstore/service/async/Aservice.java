package edu.lemon_school.internetstore.service.async;

import java.util.concurrent.CompletableFuture;

public interface Aservice {
    CompletableFuture<Integer> getData() throws InterruptedException;
}

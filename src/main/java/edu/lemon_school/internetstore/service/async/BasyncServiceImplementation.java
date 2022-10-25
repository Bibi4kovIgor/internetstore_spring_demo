package edu.lemon_school.internetstore.service.async;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class BasyncServiceImplementation implements Aservice {
    @Override
    public CompletableFuture<Integer> getData() throws InterruptedException {
        Thread.sleep(2000);
        return new AsyncResult<>(1).completable();
    }
}

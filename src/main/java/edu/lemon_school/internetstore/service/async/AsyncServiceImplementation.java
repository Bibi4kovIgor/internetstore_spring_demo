package edu.lemon_school.internetstore.service.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncServiceImplementation implements Aservice{
    @Async
    @Override
    public CompletableFuture<Integer> getData() throws InterruptedException {
        Thread.sleep(3000);
        return new AsyncResult<>(2).completable();
    }
}

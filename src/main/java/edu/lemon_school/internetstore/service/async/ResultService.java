package edu.lemon_school.internetstore.service.async;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ResultService {

    private final AsyncServiceImplementation aService;
    private final BasyncServiceImplementation bService;

    public ResultService(
            AsyncServiceImplementation aService,
            BasyncServiceImplementation bService
    ) {
        this.aService = aService;
        this.bService = bService;
    }

    public CompletableFuture<Integer> mergeResults() throws InterruptedException {
        CompletableFuture<Integer> futureData1 = aService.getData();
        CompletableFuture<Integer> futureData2 = bService.getData();
        return futureData1.thenCompose(
                fd1Value -> futureData2.thenApply(fd2Value -> fd1Value + fd2Value)
        );
    }
}

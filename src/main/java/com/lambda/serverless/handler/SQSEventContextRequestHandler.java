package com.lambda.serverless.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;
import lombok.extern.java.Log;

@Log
public class SQSEventContextRequestHandler implements RequestHandler<SQSEvent, Void> {

    @Override
    public Void handleRequest(SQSEvent event, Context context) {
        for(SQSMessage msg : event.getRecords()){
            log.info(new String(msg.getBody()));
        }

        log.info("awsRequestId=" + context.getAwsRequestId());
        log.info("functionName=" + context.getFunctionName());
        log.info("functionVersion=" + context.getFunctionVersion());
        log.info("memoryLimitInMB=" + context.getMemoryLimitInMB());
        log.info("remainingTimeInMillis=" + context.getRemainingTimeInMillis());

        return null;
    }
}

package com.mycompany.queue.service.impl;

import com.mycompany.queue.data.QueueData;
import com.mycompany.queue.model.Queue;
import com.mycompany.queue.model.Status;
import com.mycompany.queue.service.QueueService;
import com.mycompany.queue.service.ReserveService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mbk_i
 */
@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private QueueService queueService;

    @Override
    public Queue addQueue() {
        int lastNumber = queueService.findLastQueueNumber();
        // can used ++lastNumber or lastNumber + 1
        Queue queue = new Queue(++lastNumber, Status.RESERVE);
        QueueData.queues.add(queue);
        return queue;
    }

    @Override
    public int checkWaitingQueue(Queue queue) {
        return queueService.checkWaitingQueue(queue);
    }

    @Override
    public void cancelQueue(Queue queue) {
        queueService.cancelQueue(queue);
    }

    @Override
    public void endQueue(Queue queue) {
        queueService.endQueue(queue);
    }

}

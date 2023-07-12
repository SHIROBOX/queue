package com.mycompany.queue.service.impl;

import com.mycompany.queue.data.QueueData;
import com.mycompany.queue.model.Queue;
import com.mycompany.queue.model.Status;
import com.mycompany.queue.service.QueueService;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 * @author mbk_i
 */
@Service
public class QueueServiceImpl implements QueueService {

    @Override
    public int findLastQueueNumber() {
        if (QueueData.queues.isEmpty()) {
            return 0;
        }
        Queue queue = QueueData.queues.stream()
                .max(Comparator.comparing(Queue::getNumber))
                .orElse(null);
        return queue.getNumber();
    }

    @Override
    public int checkWaitingQueue(Queue queue) {
        return QueueData.queues.stream()
                .filter(q -> q.getNumber() < queue.getNumber())
                .filter(q -> q.getStatus().equals(Status.RESERVE))
                .collect(Collectors.toList()).size();
    }

    @Override
    public void cancelQueue(Queue queue) {
        QueueData.queues.get(QueueData.queues.indexOf(queue)).setStatus(Status.CANCEL);
    }

    @Override
    public void endQueue(Queue queue) {
        QueueData.queues.get(QueueData.queues.indexOf(queue)).setStatus(Status.ENTERED);
    }
}

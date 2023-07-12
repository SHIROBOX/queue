package com.mycompany.queue.service;

import com.mycompany.queue.model.Queue;

/**
 *
 * @author mbk_i
 */
public interface QueueService {

    public int findLastQueueNumber();

    public int checkWaitingQueue(Queue queue);

    public void cancelQueue(Queue queue);

    public void endQueue(Queue queue);

}

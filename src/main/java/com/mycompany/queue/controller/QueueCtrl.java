package com.mycompany.queue.controller;

import com.mycompany.queue.model.Queue;
import com.mycompany.queue.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mbk_i
 *
 */
@RestController
public class QueueCtrl {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/queue/add")
    public Queue onAddQueue() {
        return reserveService.addQueue();
    }

    @PostMapping("/queue/cancel")
    public Queue onCancelQueue(Queue queue) {
        reserveService.cancelQueue(queue);
        return queue;
    }

    public void onEndQueue(Queue queue) {
        reserveService.endQueue(queue);
    }

}

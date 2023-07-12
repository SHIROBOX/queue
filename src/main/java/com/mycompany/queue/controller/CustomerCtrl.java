package com.mycompany.queue.controller;

import com.mycompany.queue.model.Queue;
import com.mycompany.queue.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mbk_i
 */
@RestController
public class CustomerCtrl {

    @Autowired
    private ReserveService reserveService;

    @GetMapping("/customer/addQueue")
    public Queue onAddQueue() {
        return reserveService.addQueue();
    }

    public int onCheckWaitingQueue(Queue queue) {
        return reserveService.checkWaitingQueue(queue);
    }

    public void onCancelQueue(Queue queue) {
        reserveService.cancelQueue(queue);
    }

}

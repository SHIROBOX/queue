package com.mycompany.queue.controller;

import com.mycompany.queue.data.QueueData;
import com.mycompany.queue.model.Queue;
import com.mycompany.queue.service.ReserveService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/queue/all")
    public List<Queue> onCheckQueue() {
        return QueueData.queues;
    }

    @PostMapping("/queue/add")
    public Queue onAddQueue() {
        return reserveService.addQueue();
    }

    @PutMapping("/queue/cancel")
    public Queue onCancelQueue(@RequestBody Queue queue) {
        reserveService.cancelQueue(queue);
        return QueueData.queues.get(QueueData.queues.indexOf(queue));
    }

    @PutMapping("/queue/end")
    public Queue onEndQueue(@RequestBody Queue queue) {
        reserveService.endQueue(queue);
        return QueueData.queues.get(QueueData.queues.indexOf(queue));
    }

}

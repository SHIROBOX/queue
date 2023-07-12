package com.mycompany.queue.controller;

import com.mycompany.queue.model.Queue;
import com.mycompany.queue.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mbk_i
 */
@RestController
public class CustomerCtrl {

    @Autowired
    private ReserveService reserveService;

    @PostMapping("/customer/add")
    public String onAddQueue() {
        Queue queue = reserveService.addQueue();
        return "ทำการจองคิวเรียบร้อบ !! หมายเลขคิวของคุณตือ : "
                + queue.getNumber();
    }

    @GetMapping("/customer/check")
    public String onCheckWaitingQueue(@RequestBody Queue queue) {
        return "คิวหมายเลขที่ : " + queue.getNumber()
                + " มีจำนวนคิวก่อนหน้าทั้งหมด "
                + reserveService.checkWaitingQueue(queue)
                + " คิว";
    }

    @PutMapping("/customer/cancel")
    public String onCancelQueue(@RequestBody Queue queue) {
        reserveService.cancelQueue(queue);
        return "คิวหมายเลขที่ : "
                + queue.getNumber()
                + " ยกเลิกการจองเรียบร้อบแล้ว !!!";
    }

}

package ru.crealex.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.crealex.kafka.Sender;

@Controller
@RequestMapping("/kafka")
public class RestController {

    private final Sender sender;

    public RestController(Sender sender) {
        this.sender = sender;
    }

    @GetMapping(value="/send")
    public void sendMessage(@RequestParam("topic") String topic, @RequestParam("message") String message) {
        sender.send(topic, message);

    }
}

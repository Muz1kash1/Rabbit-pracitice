package com.example.week9.publisher;

import com.example.week9.listeners.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

    private final RabbitTemplate template;


    @Autowired
    public Publisher(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping("/vs")
    public ResponseEntity<String> markChange(@RequestBody String textMessage){
        template.setExchange("virtual-school");
        template.convertAndSend(textMessage);
        return ResponseEntity.ok().body("Succed");
    }
}
